package com.hawkeyetech.sofia.expandablerecyclerview;

import android.view.View;
import android.widget.TextView;

public class MainHeadingViewHolder extends ChildViewHolder {

    private TextView mMainHeading;

    /**
     * Default constructor.
     *
     * @param itemView The {@link View} being hosted in this ViewHolder
     */

    public MainHeadingViewHolder(View itemView) {
        super(itemView);
        mMainHeading = (TextView) itemView.findViewById(R.id.tv_heading);

    }
    public void bind(MainHeading mainHeading) {
        mMainHeading.setText(mainHeading.getName());
    }

}
