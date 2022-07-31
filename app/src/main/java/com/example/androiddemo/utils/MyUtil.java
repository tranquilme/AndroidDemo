package com.example.androiddemo.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import java.util.Random;

/**
 * @author clll
 * @date 2022/7/31 14:57
 */
public class MyUtil {
    /**
     * 生成随机颜色
     *
     * @return
     */
    public static int randomColor() {
        Random random = new Random();
        int red = random.nextInt(200);
        int green = random.nextInt(200);
        int blue = random.nextInt(200);
        return Color.rgb(red, green, blue);
    }

    /**
     * 生成随机透明度的白色
     * @return
     */
    public static int randomWhiteColor() {
        Random random = new Random();
        int a = random.nextInt(200);

        return Color.argb(a, 255, 255,255);
    }

    /**
     * dp 转化为 px
     */
    public static int dp2px(Context context, int dp) {
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dp * density + 0.5f);
    }

    /**
     * drawble转成Bitmap
     * @param drawable
     * @return
     */
    public static Bitmap drawable2Bitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bd = (BitmapDrawable) drawable;
            return bd.getBitmap();
        }
        int w = drawable.getIntrinsicWidth();
        int h = drawable.getIntrinsicHeight();
        Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, w, h);
        drawable.draw(canvas);
        return bitmap;
    }
}
