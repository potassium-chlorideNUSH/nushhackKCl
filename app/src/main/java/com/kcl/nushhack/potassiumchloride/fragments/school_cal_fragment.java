package com.kcl.nushhack.potassiumchloride.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextClock;
import android.widget.TextView;

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
    GridView grid;Text month_year;
    ArrayList<LinearLayout> days=new ArrayList<LinearLayout>();
    void loadCalendar(){
        //somehow get the firebase thing as a whole string
        String info="";//pretend to be many commas seperated
        String[] content=info.split(",");
        grid=getActivity().findViewById(R.id.calendar_grid);
        month_year=getActivity().findViewById(R.id.month_text);
        month_year.setTextContent(content[0]+" "+content[1]);
        int start=(Integer.parseInt(content[2])%7);
        for(int i=3;i<content.length;i++){
            LinearLayout ll=new LinearLayout(this.getContext());
            ll.setOrientation(LinearLayout.VERTICAL);
            TextView a=new TextView(this.getContext());
            a.setTextSize(20);a.setText(i-2+"");
            ll.addView(a);
            TextView b=new TextView(this.getContext());
            b.setTextSize(15);b.setText(content[3]);
            ll.addView(b);
            days.add(ll);
            i++;
        }
        ArrayAdapter aa=new ArrayAdapter((getContext()),R.layout.fragment_school_cal_fragment,days.toArray());
        grid.setAdapter(aa);

    }
    void initGrid(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadCalendar();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
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
}
