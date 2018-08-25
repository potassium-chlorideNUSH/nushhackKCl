package com.kcl.nushhack.potassiumchloride.fragments;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Debug;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.kcl.nushhack.potassiumchloride.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link school_cal_fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link school_cal_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class school_cal_fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public school_cal_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment school_cal_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static school_cal_fragment newInstance() {
        school_cal_fragment fragment = new school_cal_fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    static GridView grid;TextView month_year;String[] content;int start;
    ArrayList<LinearLayout> days=new ArrayList<LinearLayout>();
    void loadCalendar(){
        //somehow get the firebase thing as a whole string
        //month year day of 1st eventday1 eventday2 etc
        days.clear();
        String info="August,2018,3,No Event,No Event,No Event,No Event,No Event,No Event,No Event,No Event,National Day,No Event,No Event,No Event,No Event,No Event,No Event,No Event,No Event,No Event,No Event,No Event,No Event,Hari Raya Haji,No Event,Hack,Hack,No Event,No Event,No Event,No Event,No Event,No Event";
        content=info.split(",");
        month_year.setText(content[0]+","+content[1]);
        start=((Integer.parseInt(content[2]))%7);
        for (int i=0;i<start;i++){
            LinearLayout ll=new LinearLayout(this.getContext());
            TextView a=new TextView(getContext());a.setText("");
            TextView b=new TextView(getContext());a.setText("");
            ll.addView(a);
            ll.addView(b);
            days.add(ll);
        }
        for(int i=start;i<content.length+start-3;i++){
            LinearLayout ll=new LinearLayout(this.getContext());
            TextView a=new TextView(this.getContext());
            a.setTextSize(40);
            ll.addView(a);
            TextView b=new TextView(this.getContext());
            b.setTextSize(5);
            ll.addView(b);b.setText(content[i-start+3]);
            days.add(ll);
        }
        myAdapter ma=new myAdapter(getContext());
        ma.days=new String[days.size()];
        for(int i=0;i<days.size();i++){
            String s=((TextView)(this.days.get(i).getChildAt(1))).getText().toString();
            ma.days[i]=s;
        }
        ma.start=start;
        grid.setAdapter(ma);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_school_cal_fragment, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    static TextView bigDate,bigEvent;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        grid=getView().findViewById(R.id.calendar_grid);
        month_year=getView().findViewById(R.id.month_text);
        TextView x=getView().findViewById(R.id.days);
        bigDate=getView().findViewById(R.id.bigDate);
        bigEvent=getView().findViewById(R.id.bigEvent);
        x.setText("S       M       T       W       T       F       S     ");
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                try{
                    if(position<start||position>start+days.size()-3)
                        throw new Exception();
                bigDate.setText(String.valueOf(position-start+1));
                bigEvent.setText(String.valueOf(content[position-start+3]));}catch(Exception e){}
            }
        });
        loadCalendar();
    }
}
class myAdapter extends BaseAdapter{
    Context mContext;
    public myAdapter(Context c) {
        mContext = c;
    }
    String[] days;
    int start;
    public int getCount() {
        return days.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the item corresponding to your position
        LinearLayout row = (LinearLayout) (convertView == null
                ? LayoutInflater.from(mContext).inflate(R.layout.day_item, parent, false)
                : convertView);
        if(position<start) {
            ((TextView)row.findViewById(R.id.date)).setText("");
            ((TextView)row.findViewById(R.id.msg)).setText("");
            row.setBackgroundColor(Color.TRANSPARENT);
        }else{
            Log.d("ppppp",position+","+days[position-start+3]);
        ((TextView)row.findViewById(R.id.date)).setText(String.valueOf(position-start+1));
        ((TextView)row.findViewById(R.id.msg)).setText(days[position-start+3]);
        if(!days[position-start+3].equals("")&&!days[position-start+3].equals("No Event")){
            row.setBackgroundColor(Color.CYAN);
        }else{
            row.setBackgroundColor(Color.BLUE);
        }}

        return row;
    }




}
