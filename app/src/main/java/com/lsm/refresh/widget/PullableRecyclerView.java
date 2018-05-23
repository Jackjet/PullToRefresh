package com.lsm.refresh.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class PullableRecyclerView extends RecyclerView implements Pullable {
    public PullableRecyclerView(Context context) {
        super(context);
    }

    public PullableRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PullableRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean canPullDown() {
        if (getChildCount() == 0) { // 没有item的时候也可以下拉刷新
            return true;
        } else if (getVerticalScrollbarPosition() == 0 && (getChildCount() == 0 || getChildAt(0).getTop() >= 0)) {
            // 滑到RecyclerView的顶部了
            return true;
        }
        return false;
    }

    @Override
    public boolean canPullUp() {
        if (this == null) return false;
        if (computeVerticalScrollExtent() + computeVerticalScrollOffset() >= computeVerticalScrollRange())
            return true;
        return false;
    }
}
