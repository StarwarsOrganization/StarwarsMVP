package com.anormaly.bb8progressview;

import android.graphics.Bitmap;
import android.support.annotation.DrawableRes;

/**
 * Created by ichigo on 14/07/17.
 */

public class BB8
{

    private final Calculate calculate;
    @DrawableRes
    private int headDrawableId;
    @DrawableRes
    private int bodyDrawableId;
    private Bitmap headBitmap;
    private Bitmap bodyBitmap;
    private int headWidth,headHeight;
    private int bodyWidth,bodyHeight;
    private int x,y;

    public BB8()
    {
        calculate = new Calculate();
    }

    public int getHeadDrawableId()
    {
        return headDrawableId;
    }

    public void setHeadDrawableId(int headDrawableId)
    {
        this.headDrawableId = headDrawableId;
    }

    public int getBodyDrawableId()
    {
        return bodyDrawableId;
    }

    public void setBodyDrawableId(int bodyDrawableId)
    {
        this.bodyDrawableId = bodyDrawableId;
    }

    public Bitmap getHeadBitmap()
    {
        return headBitmap;
    }

    public void setHeadBitmap(Bitmap headBitmap)
    {
        this.headBitmap = headBitmap;
    }

    public Bitmap getBodyBitmap()
    {
        return bodyBitmap;
    }

    public void setBodyBitmap(Bitmap bodyBitmap)
    {
        this.bodyBitmap = bodyBitmap;
    }

    public int getHeadWidth()
    {
        return headWidth;
    }

    public void setHeadWidth(int headWidth)
    {
        this.headWidth = headWidth;
    }

    public int getHeadHeight()
    {
        return headHeight;
    }

    public void setHeadHeight(int headHeight)
    {
        this.headHeight = headHeight;
    }

    public int getBodyWidth()
    {
        return bodyWidth;
    }

    public void setBodyWidth(int bodyWidth)
    {
        this.bodyWidth = bodyWidth;
    }

    public int getBodyHeight()
    {
        return bodyHeight;
    }

    public void setBodyHeight(int bodyHeight)
    {
        this.bodyHeight = bodyHeight;
    }

    public Calculate getCalculate()
    {
        return calculate;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public class Calculate
    {

        private int screenHeight;
        private int screenWidth;
        private int measuredWidth, measuredHeight;
        public void setScreenHeight(int screenHeight)
        {
            this.screenHeight = screenHeight;
        }
        public int getScreenHeight()
        {
            return screenHeight;
        }
        public void setScreenWidth(int screenWidth)
        {
            this.screenWidth = screenWidth;
        }
        public int getScreenWidth()
        {
            return screenWidth;
        }
        public void setMeasuredWidthAndHeight(int measuredWidth, int measuredHeight)
        {
            this.measuredWidth = measuredWidth;
            this.measuredHeight = measuredHeight;
        }

        public int getMeasuredWidth()
        {
            return measuredWidth;
        }

        public int getMeasuredHeight()
        {
            return measuredHeight;
        }

        public void headAndBodyBounds()
        {
            setBodyWidth(screenWidth/8);
            setBodyHeight((bodyBitmap.getHeight()*getBodyWidth())/bodyBitmap.getWidth());

            setHeadWidth(getBodyWidth());
            setHeadHeight(getBodyHeight());

            bodyBitmap = Bitmap.createScaledBitmap(bodyBitmap,getBodyWidth(),getBodyHeight(),false);
            headBitmap = Bitmap.createScaledBitmap(headBitmap,getHeadWidth(),getHeadHeight(),false);
        }
    }
}
