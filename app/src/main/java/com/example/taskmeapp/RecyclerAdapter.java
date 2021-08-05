package com.example.taskmeapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private ArrayList<Task> localDataSet;
    private OnNoteListener mOnNoteListener;
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView textView;
        OnNoteListener onNoteListener;

        public ViewHolder(View view, OnNoteListener onNoteListener) {
            super(view);
            // Define click listener for the ViewHolder's View

            textView = (TextView) view.findViewById(R.id.textView);
            this.onNoteListener = onNoteListener;

            view.setOnClickListener(this);
        }

        public TextView getTextView() {
            return textView;
        }


        @Override
        public void onClick(View v) {
            onNoteListener.OnNoteClick(getAdapterPosition(), v);
        }
    }
    public interface OnNoteListener {
        void OnNoteClick(int position, View v);
    }
    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public RecyclerAdapter(ArrayList<Task> dataSet, OnNoteListener onNoteListener) {
        localDataSet = dataSet;
        this.mOnNoteListener = onNoteListener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_items, viewGroup, false);

        return new ViewHolder(view, mOnNoteListener);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        String name = localDataSet.get(position).getWhat();
        viewHolder.getTextView().setText(name);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

}
