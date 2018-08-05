package com.hawkeyetech.sofia.expandablerecyclerview;

import android.view.View;

public interface RecyclerViewClickListener {

    void onViewClick(View view, int position, int viewType, Object obj);
}
