package com.hawkeyetech.sofia.expandablerecyclerview;

import android.view.View;
import android.widget.TextView;

public class MoviesViewHolder extends ChildViewHolder {

    private TextView mMoviesTextView;
    private RecyclerViewClickListener myListener;
    int mViewType;
    View view;


    public MoviesViewHolder(View itemView, RecyclerViewClickListener listener, int viewType) {
        super(itemView);
        myListener= listener;
        mViewType=viewType;
        view = itemView;
        mMoviesTextView = (TextView) itemView.findViewById(R.id.tv_movies);
        //itemView.setOnClickListener(this);
    }

    public void bind(final Movies movies) {
        mMoviesTextView.setText(movies.getName());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myListener.onViewClick(view, getAdapterPosition(), mViewType, movies);
            }
        });

    }

    /*@Override
    public void onClick(View view) {
        myListener.onViewClick(view, getAdapterPosition(), mViewType);
    }*/
}