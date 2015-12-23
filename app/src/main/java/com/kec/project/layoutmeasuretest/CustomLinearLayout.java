package com.kec.project.layoutmeasuretest;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ManasShrestha on 12/22/15.
 */
public class CustomLinearLayout extends LinearLayout {
    String tag = this.getClass().getSimpleName();
    int measureTotal = 0;

    TextView ctv1;

    TextView ctv2;

    ImageView civ1;

    ImageView civ2;
    private int width =0;
    private int height = 0;

//    ImageView civ3;

    public CustomLinearLayout(Context context) {
        super(context);
    }

    public CustomLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.e("++", "--- onLayoutMeasure " + getChildCount());
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = 0;
        height = 0;
        for (int i = 0 ; i < (getChildCount()-1); i++){
            measureChild(getChildAt(i),widthMeasureSpec,heightMeasureSpec);
            widthMeasureSpec = widthMeasureSpec - getChildAt(i).getMeasuredWidth();
            heightMeasureSpec = heightMeasureSpec - getChildAt(i).getMeasuredHeight();

            height += getChildAt(i).getMeasuredHeight();
            width += getChildAt(i).getMeasuredWidth();
        }

        setMeasuredDimension(width,height);
        measureTotal++;
    }

}
