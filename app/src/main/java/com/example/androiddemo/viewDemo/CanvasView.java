package com.example.androiddemo.viewDemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @author clll
 * @date 2022/7/31 23:19
 */
public class CanvasView extends View {

    public CanvasView(Context context) {
        super(context);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawARGB(100, 100, 100, 100);
    }

    private void clipDemo(Canvas canvas) {
        // 为了方便观察,我将坐标系移到屏幕中央
        canvas.translate(300, 500);

        //原来画布设置为灰色
        canvas.drawColor(Color.GRAY);

        //第一次裁剪
        canvas.clipRect(0, 0, 600, 600);

        //将第一次裁剪后的区域设置为红色
        canvas.drawColor(Color.RED);

        //第二次裁剪,并显示第一次裁剪与第二次裁剪不重叠的区域
        canvas.clipRect(0, 200, 600, 400, Region.Op.DIFFERENCE);

        //将第一次裁剪与第二次裁剪不重叠的区域设置为黑色
        canvas.drawColor(Color.BLACK);
    }
}
