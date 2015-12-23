package com.kec.project.layoutmeasuretest;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ManasShrestha on 12/22/15.
 */
public class CustomViewGroup extends ViewGroup {

    TextView ctv1;

    TextView ctv2;

//    ImageView civ1;

    ImageView civ2;

    ImageView civ3;

    public CustomViewGroup(Context context) {
        super(context);

        civ2 = (ImageView) findViewById(R.id.iv_civ2);
        civ3 = (ImageView) findViewById(R.id.iv_civ3);
//        civ1 = (ImageView) findViewById(R.id.iv_civ1);
        ctv1 = (TextView) findViewById(R.id.tv_ctv1);
        ctv2 = (TextView) findViewById(R.id.tv_ctv2);
    }

    public CustomViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);

        civ2 = (ImageView) findViewById(R.id.iv_civ2);
        civ3 = (ImageView) findViewById(R.id.iv_civ3);
//        civ1 = (ImageView) findViewById(R.id.iv_civ1);
        ctv1 = (TextView) findViewById(R.id.tv_ctv1);
        ctv2 = (TextView) findViewById(R.id.tv_ctv2);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthConstraints = getPaddingLeft() + getPaddingRight();
        int heightContraints = getPaddingTop() + getPaddingBottom();
        int width = 0;
        int height = 0;

        Log.e("++","--- onLayoutMeasure");
        Log.e("--", String.valueOf(getChildCount()));
        measureChildWithMargins(
                getChildAt(0),
                widthMeasureSpec,
                widthConstraints,
                heightMeasureSpec,
                heightContraints);

        // 3. Update the contraints.
        widthConstraints += getChildAt(0).getMeasuredWidth();
        width += getChildAt(0).getMeasuredWidth();
        height = Math.max(getChildAt(0).getMeasuredHeight(), height);

        measureChildWithMargins(
                getChildAt(1),
                widthMeasureSpec,
                widthConstraints,
                heightMeasureSpec,
                heightContraints);

        // 3. Update the contraints.
        widthConstraints += getChildAt(1).getMeasuredWidth();
        width += getChildAt(1).getMeasuredWidth();
        height = Math.max(getChildAt(1).getMeasuredHeight(), height);

        // 6. Prepare the vertical MeasureSpec.
        int verticalWidthMeasureSpec = MeasureSpec.makeMeasureSpec(
                MeasureSpec.getSize(widthMeasureSpec) - widthConstraints,
                MeasureSpec.getMode(widthMeasureSpec));

        int verticalHeightMeasureSpec = MeasureSpec.makeMeasureSpec(
                MeasureSpec.getSize(heightMeasureSpec) - heightContraints,
                MeasureSpec.getMode(heightMeasureSpec));

        measureChildWithMargins(
                getChildAt(2),
                verticalWidthMeasureSpec,
                0,
                verticalHeightMeasureSpec,
                0);

        measureChildWithMargins(
                getChildAt(3),
                verticalWidthMeasureSpec,
                0,
                verticalHeightMeasureSpec,
                getChildAt(2).getMeasuredHeight());

//        measureChildWithMargins(
//                getChildAt(4),
//                verticalWidthMeasureSpec,
//                0,
//                verticalHeightMeasureSpec,
//                getChildAt(3).getMeasuredHeight());

        width += Math.max(getChildAt(2).getMeasuredWidth(), getChildAt(3).getMeasuredWidth());
        height = Math.max(getChildAt(2).getMeasuredHeight() + getChildAt(3).getMeasuredHeight(), height);

        setMeasuredDimension(
                resolveSize(width, widthMeasureSpec),
                resolveSize(height, heightMeasureSpec));

    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {

    }

    @Override
    protected void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        LayoutParams lp =  child.getLayoutParams();
//        ViewGroup.MarginLayoutParams lpv = (ViewGroup.MarginLayoutParams) child.getLayoutParams();

        int childWidthMeasureSpec = getChildMeasureSpec(
                parentWidthMeasureSpec,
                widthUsed,
                lp.width);

        int childHeightMeasureSpec = getChildMeasureSpec(
                parentHeightMeasureSpec,
                heightUsed,
                lp.height);
        Log.e("&& width", String.valueOf(childWidthMeasureSpec));
        Log.e("&& height", String.valueOf(childHeightMeasureSpec));
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }

}
