package com.hawkeyetech.sofia.expandablerecyclerview;

import java.util.List;

public class HeaderWrapper {

    private HeadingListItem headingListItem;

    /**
     * Default constructor.
     *
     */
    public HeaderWrapper(HeadingListItem mheadingListItem) {
        this.headingListItem = mheadingListItem;
    }

    /**
     * Gets the {@link ParentListItem} being wrapped.
     *
     * @return The {@link ParentListItem} being wrapped
     */
    public HeadingListItem getHeaderListItem() {
        return headingListItem;
    }

    /**
     * Sets the {@link ParentListItem} to wrap.
     *
     */
    public void setHeadingListItem(HeadingListItem mheadingListItem) {
        headingListItem = mheadingListItem;
    }

    public List<?> getChildItemList() {
        return headingListItem.getChildItemList();
    }
}
