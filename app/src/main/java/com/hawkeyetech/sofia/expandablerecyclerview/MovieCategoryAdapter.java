package com.hawkeyetech.sofia.expandablerecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MovieCategoryAdapter extends ExpandableRecyclerAdapter<MovieCategoryViewHolder, MoviesViewHolder, MainHeadingViewHolder> {

    private LayoutInflater mInflator;
    private RecyclerViewClickListener mListener;


    public MovieCategoryAdapter(Context context, List<? extends HeadingListItem> headingListItems, RecyclerViewClickListener listener) {
        super(headingListItems);
        mInflator = LayoutInflater.from(context);
        mListener=listener;
    }

    @Override
    public MovieCategoryViewHolder onCreateParentViewHolder(ViewGroup parentViewGroup) {
        View movieCategoryView = mInflator.inflate(R.layout.movie_category_view, parentViewGroup, false);
        return new MovieCategoryViewHolder(movieCategoryView);
    }

    @Override
    public MoviesViewHolder onCreateChildViewHolder(ViewGroup childViewGroup, int viewType) {
        View moviesView = mInflator.inflate(R.layout.movies_view, childViewGroup, false);
        return new MoviesViewHolder(moviesView, mListener, viewType);
    }

    @Override
    public MainHeadingViewHolder onCreateHeadingViewHolder(ViewGroup headingViewGroup) {
        View headingView = mInflator.inflate(R.layout.main_heading_view, headingViewGroup, false);
        return new MainHeadingViewHolder(headingView);
    }

    @Override
    public void onBindParentViewHolder(MovieCategoryViewHolder movieCategoryViewHolder, int position, ParentListItem parentListItem) {
        MovieCategory movieCategory = (MovieCategory) parentListItem;
        movieCategoryViewHolder.bind(movieCategory);
    }

    @Override
    public void onBindChildViewHolder(MoviesViewHolder moviesViewHolder, int position, Object childListItem) {
        Movies movies = (Movies) childListItem;
        moviesViewHolder.bind(movies);
    }

    @Override
    public void onBindHeadingViewHolder(MainHeadingViewHolder headingViewHolder, int position, Object HeadingListItem) {
        MainHeading mainHeading = (MainHeading) HeadingListItem;
        headingViewHolder.bind(mainHeading);
    }
}
