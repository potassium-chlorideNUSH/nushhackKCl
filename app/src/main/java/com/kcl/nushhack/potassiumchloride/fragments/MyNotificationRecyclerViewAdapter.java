package com.kcl.nushhack.potassiumchloride.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kcl.nushhack.potassiumchloride.R;
import com.kcl.nushhack.potassiumchloride.fragments.notification_fragment.OnListFragmentInteractionListener;
import com.kcl.nushhack.potassiumchloride.fragments.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.ArrayList;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyNotificationRecyclerViewAdapter extends RecyclerView.Adapter<MyNotificationRecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> titles;
    private ArrayList<String> contents;

    private OnListFragmentInteractionListener mListener;
    
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }


    public MyNotificationRecyclerViewAdapter(ArrayList<String> titles, ArrayList<String> contents) {
        this.titles = titles;
        this.contents = contents;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View titleText = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_notification, parent, false);
        View contentText = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_notification, parent, false);
        return new ViewHolder(titleText);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mIdView.setText(titles.get(position));
        holder.mContentView.setText(contents.get(position));

    }
    @Override
    public int getItemCount() {
        if (titles == null) return -1;
        else return titles.size();
    }

    public ArrayList<String> getTitles() {
        return titles;
    }

    public void setTitles(ArrayList<String> titles) {
        this.titles = titles;
        notifyDataSetChanged();
    }

    public ArrayList<String> getContents() {
        return contents;
    }

    public void setContents(ArrayList<String> contents) {
        this.contents = contents;
        notifyDataSetChanged();
    }
}
