package com.kec.project.layoutmeasuretest;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by ManasShrestha on 12/22/15.
 */
public class CustomImageView extends ImageView {

    public CustomImageView(Context context) {
        super(context);
        Log.e("init","img");
    }

    public CustomImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.e("init", "img");
    }

    public CustomImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.e("init", "img");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.e("++", "-- CustomImageView ");
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

}
