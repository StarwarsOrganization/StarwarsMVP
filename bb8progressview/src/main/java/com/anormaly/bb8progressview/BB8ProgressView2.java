package com.anormaly.bb8progressview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by ichigo on 14/07/17.
 */

public class BB8ProgressView2 extends RelativeLayout implements View.OnClickListener
{
    private static final String TAG = BB8ProgressView2.class.getSimpleName();
    private static final TimeInterpolator TIME_INTERPOLATOR = new LinearInterpolator();
    private BB8 bb8;
    private BB8.Calculate calculate;
    private ImageView mHeadImageView;
    private ImageView mBodyImageView;
    boolean s = true;
private float bodyRotation;
    private ObjectAnimator rotateAnimator;
    private Paint linePaint;
    private double changeX;
    private OnProgressEventListener listener;


    public BB8ProgressView2(Context context)
    {
        this(context,null);
    }

    public BB8ProgressView2(Context context, @Nullable AttributeSet attrs)
    {
        this(context, attrs,0);
    }

    public BB8ProgressView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr)
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


        LayoutInflater.from(getContext()).inflate(R.layout.bb8_layout,this,true);

        setWillNotDraw(false);
        mHeadImageView = (ImageView) findViewById(R.id.headImageView);
        mBodyImageView = (ImageView) findViewById(R.id.bodyImageView);

        loadScreenDimensionsToBB8();
        bb8.setHeadDrawableId(R.drawable.head);
        bb8.setBodyDrawableId(R.drawable.body);
        bb8.setHeadBitmap(Utils.drawableToBitmap(ContextCompat.getDrawable(getContext(),bb8.getHeadDrawableId())));
        bb8.setBodyBitmap(Utils.drawableToBitmap(ContextCompat.getDrawable(getContext(),bb8.getBodyDrawableId())));
        bb8.getCalculate().headAndBodyBounds();
        mHeadImageView.setImageBitmap(bb8.getHeadBitmap());
        mBodyImageView.setImageBitmap(bb8.getBodyBitmap());
        setOnClickListener(this);
        setPaints();
    }

    private void setPaints()
    {
        linePaint = new Paint();
        linePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        linePaint.setColor(Color.GRAY);
        linePaint.setStrokeWidth(10);


    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {


        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int desiredWidth = calculate.getScreenWidth();
        int desiredHeight = bb8.getBodyHeight();

        int measuredWidth;
        int measuredHeight;

        if (widthMode == MeasureSpec.AT_MOST)
        {
            measuredWidth = Math.min(widthSize,desiredWidth);
        } else if (widthMode == MeasureSpec.EXACTLY)
        {
            measuredWidth = widthSize;
        } else
        {
            measuredWidth = desiredWidth;
        }

        if (heightMode == MeasureSpec.AT_MOST)
        {
            measuredHeight = Math.min(heightSize,desiredHeight);
        } else if (widthMode == MeasureSpec.EXACTLY)
        {
            measuredHeight = heightSize;
        } else
        {
            measuredHeight = desiredHeight;
        }

        bb8.getCalculate().setMeasuredWidthAndHeight(measuredWidth,measuredHeight);

        setMeasuredDimension(desiredWidth,desiredHeight);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    boolean t=true;
    Matrix matrix;
    float highest = 0;
    float lastX = 0;

    // TODO: 15/07/17 Restructure the logic for performance #perfmatters
    private void rotateBody()
    {

        if(t)
        {
            matrix = new Matrix();
            mBodyImageView.setScaleType(ImageView.ScaleType.MATRIX);
            mHeadImageView.setScaleType(ImageView.ScaleType.MATRIX);
            t = false;
        }
        //836 523 313
        double divisor = 1.45517841601;
        matrix.setRotate(getBodyRotation(),mBodyImageView.getWidth()/2, (float) (mBodyImageView.getHeight()/divisor));
        mBodyImageView.setImageMatrix(matrix);
        if(getBodyRotation()<=180)
        highest= getBodyRotation()>highest? (int) getBodyRotation() :highest;
        if(highest<=360)
        {
            matrix.setRotate((highest) / 6, mBodyImageView.getWidth() / 2, (float) (mBodyImageView.getHeight() / divisor));
        }else{
            matrix.setRotate((720-highest)/6, mBodyImageView.getWidth() / 2, (float) (mBodyImageView.getHeight() / divisor));
        }
        mHeadImageView.setImageMatrix(matrix);
        if(lastX==0){
            lastX = mBodyImageView.getX();
        }

        //changeX = 2 * Math.PI * (261.5) * (getBodyRotation() - lastX) / 360;
        changeX = 0;
        postInvalidate();
        if(mBodyImageView.getX()<(getWidth()-mBodyImageView.getWidth()-20))
        {
            mBodyImageView.setX((float) (mBodyImageView.getX() + changeX));
            mHeadImageView.setX((float) (mHeadImageView.getX() + changeX));
        }
        lastX = getBodyRotation();
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canvas.drawColor(Color.TRANSPARENT);

    }




    private void animateRotation(){
        rotateAnimator = ObjectAnimator.ofFloat(this,BB8ProgressView2.BODY_ROTATE_PROPERTY,0f,720f);
        rotateAnimator.setDuration(750);
        rotateAnimator.setRepeatMode(ValueAnimator.RESTART);
        rotateAnimator.setRepeatCount(ValueAnimator.INFINITE);
        //rotateAnimator.setStartDelay(0);
        rotateAnimator.setInterpolator(TIME_INTERPOLATOR);

        final ObjectAnimator accelerateAnimator = ObjectAnimator.ofFloat(this,BB8ProgressView2.BODY_ROTATE_PROPERTY,0f,720f);
        accelerateAnimator.setDuration(1500);
        accelerateAnimator.setInterpolator(new FastOutLinearInInterpolator());
        accelerateAnimator.addListener(new AnimatorListenerAdapter()
        {
            @Override
            public void onAnimationEnd(Animator animation)
            {
                rotateAnimator.setCurrentPlayTime(accelerateAnimator.getCurrentPlayTime());
                rotateAnimator.start();
            }
        });
        accelerateAnimator.start();
    }

    @Override
    public void onClick(View view)
    {
        /*if(s)
        {
            animateRotation();
            s = false;
        }else{
            stopAnimation();
        }
        this.getLayoutParams().width = ViewPager.LayoutParams.MATCH_PARENT;*/
    }

    private void stopAnimation()
    {
        rotateAnimator.end();
        s = true;
    }

    public float getBodyRotation()
    {
        return bodyRotation;
    }

    public void setBodyRotation(float bodyRotation)
    {
        this.bodyRotation = bodyRotation;
        rotateBody();
    }

    public static final Property<BB8ProgressView2,Float> BODY_ROTATE_PROPERTY =
            new Property<BB8ProgressView2, Float>(Float.class,"bodyRotate")
            {
                @Override
                public Float get(BB8ProgressView2 view)
                {
                    return view.getBodyRotation();
                }

                @Override
                public void set(BB8ProgressView2 object, Float value)
                {
                    object.setBodyRotation(value);
                }
            };


    private void loadScreenDimensionsToBB8(){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity)getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        calculate.setScreenHeight(displayMetrics.heightPixels);
        calculate.setScreenWidth(displayMetrics.widthPixels);
    }

    public void start(){
        animateRotation();
        if(listener!=null) listener.onStart();
    }

    public void end(){
        stopAnimation();
        if(listener!=null) listener.onEnd();
    }


    interface OnProgressEventListener
    {
        void onStart();
        void onEnd();
    }

    public void setOnProgressEventListener(OnProgressEventListener onProgressEventListener){
        this.listener = onProgressEventListener;
    }

}
