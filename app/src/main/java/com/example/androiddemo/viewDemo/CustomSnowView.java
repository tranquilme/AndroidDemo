package com.example.androiddemo.viewDemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.androiddemo.model.SnowFlate;
import com.example.androiddemo.utils.MyUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author clll
 * @date 2022/7/31 11:13
 */
public class CustomSnowView extends View {
    private int mDefaultWidthSize = MyUtil.dp2px(getContext(), 100);
    private int mDefaultHeightSize = MyUtil.dp2px(getContext(), 100);
    private int mMeasuredWidthSize = 0;
    private int mMeasuredHeightSize = 0;
    private List<SnowFlate> mSnowFlateList = new ArrayList<SnowFlate>();
    private Random mRandom = new Random();
    private Paint mPaint = new Paint();


    public CustomSnowView(Context context) {
        super(context);
    }

    public CustomSnowView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomSnowView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomSnowView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    // 属性为 wrap_content 时设置默认值
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthSpecMode == MeasureSpec.EXACTLY) {
            mMeasuredWidthSize = widthSpecSize;
        } else {
            mMeasuredWidthSize = Math.min(mDefaultWidthSize, widthSpecSize);
        }

        if (heightSpecMode == MeasureSpec.EXACTLY) {
            mMeasuredHeightSize = heightSpecSize;
        } else {
            mMeasuredHeightSize = Math.min(mDefaultHeightSize, heightSpecSize);
        }

        mMeasuredWidthSize = mMeasuredWidthSize - getPaddingLeft() - getPaddingRight();
        mMeasuredHeightSize = mMeasuredHeightSize - getPaddingTop() - getPaddingBottom();
        setMeasuredDimension(mMeasuredWidthSize, mMeasuredHeightSize);
    }

    // 计算出所有雪花的状态
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
         for (int i = 0; i < mMeasuredWidthSize; i++) {
             SnowFlate snowFlate = new SnowFlate();

             float snowX = mRandom.nextFloat() * mMeasuredWidthSize;
             float snowY = mRandom.nextFloat() * mMeasuredHeightSize;

             snowFlate.positionX = snowX;
             snowFlate.positionY = snowY;
             snowFlate.radius = mRandom.nextFloat() * 5 + 1;
             snowFlate.speed = mRandom.nextInt(3) + 1;
             snowFlate.color = MyUtil.randomWhiteColor();

             mSnowFlateList.add(snowFlate);
         }
    }

    // 绘制雪花
    @Override
    protected void onDraw(Canvas canvas) {
        for (SnowFlate snowFlate: mSnowFlateList) {
            mPaint.setColor(snowFlate.color);
            float randValue = mRandom.nextFloat() * 2 - 1;
            snowFlate.positionX = snowFlate.positionX + randValue;
            snowFlate.positionY = snowFlate.positionY + snowFlate.speed;

            if (snowFlate.positionY > mMeasuredHeightSize) {
                snowFlate.positionY = 0;
            }
            if (snowFlate.positionX > mMeasuredWidthSize) {
                snowFlate.positionX = 0;
            }

            canvas.drawCircle(snowFlate.positionX, snowFlate.positionY, snowFlate.radius, mPaint);
        }

        postInvalidateDelayed(10);
    }

}
