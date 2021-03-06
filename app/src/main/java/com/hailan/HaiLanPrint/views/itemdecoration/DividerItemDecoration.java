package com.hailan.HaiLanPrint.views.itemdecoration;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hailan.HaiLanPrint.R;
import com.hailan.HaiLanPrint.application.MDGroundApplication;
import com.hailan.HaiLanPrint.utils.ViewUtils;

/**
 * Created by yoghourt on 5/16/16.
 */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    private int mMargin = 0;

    private Drawable mDrawable;

    public DividerItemDecoration(int margin) {
        mDrawable = MDGroundApplication.sInstance.getResources().getDrawable(R.drawable.shape_divider);

        mMargin = margin;
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent) {
        final int left = ViewUtils.dp2px(mMargin);
        final int right = parent.getWidth() - left;

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin;
            final int bottom = top + mDrawable.getIntrinsicHeight();
            mDrawable.setBounds(left, top, right, bottom);
            mDrawable.draw(c);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, int position, RecyclerView parent) {
        outRect.set(0, 0, 0, mDrawable.getIntrinsicWidth());
    }
}
