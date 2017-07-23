package com.anormaly.bb8progressview;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Created by ichigo on 14/07/17.
 */

public class BB8ProgressView extends View
{
    private BB8 bb8;
    private BB8.Calculate calculate;

    public BB8ProgressView(Context context)
    {
        this(context,null);
    }

    public BB8ProgressView(Context context, @Nullable AttributeSet attrs)
    {
        this(context, attrs,0);
    }

    public BB8ProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);

        intializeAttrs(attrs);
    }

    private void intializeAttrs(AttributeSet attrs)
    {
        bb8 = new BB8();
        calculate = bb8.getCalculate();
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs,R.styleable.BB8ProgressView);

        try{

        }finally
        {
            typedArray.recycle();
        }

        this.getLayoutParams().width = ViewPager.LayoutParams.MATCH_PARENT;

        bb8.setHeadDrawableId(R.drawable.head);
        bb8.setBodyDrawableId(R.drawable.body);
        bb8.setHeadBitmap(Utils.drawableToBitmap(ContextCompat.getDrawable(getContext(),bb8.getHeadDrawableId())));
        bb8.setBodyBitmap(Utils.drawableToBitmap(ContextCompat.getDrawable(getContext(),bb8.getBodyDrawableId())));

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        loadScreenDimensionsToBB8();
        setPaints();

        int measuredHeight;
        int measuredWidth;

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int desiredHeight = heightSize;
        int desiredWidth = widthSize;

        if (widthMode == MeasureSpec.AT_MOST)
        {
            measuredWidth = widthSize;
        } else if (widthMode == MeasureSpec.EXACTLY)
        {
            measuredWidth = widthSize;
        } else
        {
            measuredWidth = widthSize;
        }

        if (heightMode == MeasureSpec.AT_MOST)
        {
            measuredHeight = heightSize;
        } else if (widthMode == MeasureSpec.EXACTLY)
        {
            measuredHeight = heightSize;
        } else
        {
            measuredHeight = heightSize;
        }

        setMeasuredDimension(measuredWidth,measuredHeight);
        calculate.setMeasuredWidthAndHeight(measuredWidth,measuredHeight);
        calculate.headAndBodyBounds();
        postInvalidate();
    }

    private void setPaints()
    {

    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canvas.drawColor(Color.TRANSPARENT);
        drawBody(canvas);
        drawHead(canvas);
    }

    void drawBody(Canvas canvas){
        canvas.drawBitmap(bb8.getBodyBitmap(),0,(int) (bb8.getHeadHeight()/1.3),null);
    }

    void drawHead(Canvas canvas){
        canvas.drawBitmap(bb8.getHeadBitmap(),bb8.getBodyWidth()/2-bb8.getHeadWidth()/2,0,null);
    }

    private void loadScreenDimensionsToBB8(){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity)getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        calculate.setScreenHeight(displayMetrics.heightPixels);
        calculate.setScreenWidth(displayMetrics.widthPixels);
    }
}
