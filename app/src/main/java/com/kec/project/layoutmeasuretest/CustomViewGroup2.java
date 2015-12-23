package com.kec.project.layoutmeasuretest;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;

/**
 * Created by ManasShrestha on 12/23/15.
 */
public class CustomViewGroup2 extends ViewGroup {
    public CustomViewGroup2(Context context) {
        super(context);
        init();
    }

    public CustomViewGroup2(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomViewGroup2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.e("++", "onLayoutMeasure" + getChildCount());

        // 1. Setup initial constraints.
        int widthConstraints = getPaddingLeft() + getPaddingRight();
        int heightContraints = getPaddingTop() + getPaddingBottom();
        int width = 0;
        int height = 0;

        measureChild(getChildAt(0), widthMeasureSpec, heightMeasureSpec);

        setMeasuredDimension(resolveSize(getChildAt(0).getMeasuredWidth(), widthMeasureSpec),
                resolveSize(getChildAt(0).getMeasuredHeight(), heightMeasureSpec));

    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {

    }

}
