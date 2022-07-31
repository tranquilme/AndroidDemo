package com.example.androiddemo.viewDemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.example.androiddemo.utils.MyUtil;

/**
 * @author clll
 * @date 2022/8/1 0:17
 */

public class CircleImageShader extends androidx.appcompat.widget.AppCompatImageView {

    private Paint mPaint = new Paint(); //画笔
    private int mRadius; //圆形图片的半径
    private float mScale; //图片的缩放比例

    public CircleImageShader(Context context) {
        super(context);
    }

    public CircleImageShader(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleImageShader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //因为是圆形图片,所以宽高保持一致
        int size = Math.min(getMeasuredWidth(), getMeasuredHeight());
        mRadius = size / 2;
        //设置最终尺寸
        setMeasuredDimension(size, size);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //设置抗锯齿
        mPaint.setAntiAlias(true);
        //将drawable转成Bitmap
        Bitmap bitmap = MyUtil.drawable2Bitmap(getDrawable());
        //初始化BitmapShader，TileMode设置为拉模式
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        //计算缩放比例
        mScale = (mRadius * 2.0f) / Math.min(bitmap.getHeight(), bitmap.getWidth());
        //使用Matrix对bitmapShader进行缩放，为什么要缩放？因为当图片大于View的设定的宽高时，只会绘制左上角的局域，
        // 这样会显示不完全。
        Matrix matrix = new Matrix();
        matrix.setScale(mScale, mScale);
        bitmapShader.setLocalMatrix(matrix);
        //画笔设置定义好的BitmapShader
        mPaint.setShader(bitmapShader);
        //画圆形，参数分别为中心点坐标、半径、画笔
        canvas.drawCircle(mRadius, mRadius, mRadius, mPaint);
    }


}