package com.hawkeyetech.sofia.expandablerecyclerview;

import java.util.List;

public class MainHeading implements HeadingListItem {
    private String mName;

    private List<MovieCategory> mMovieCategories;

    public MainHeading(String name, List<MovieCategory> movies){
        mMovieCategories=movies;
        mName = name;

    }
    @Override
    public List<?> getChildItemList() {
        return mMovieCategories;
    }
    public String getName() {
        return mName;
    }

}
