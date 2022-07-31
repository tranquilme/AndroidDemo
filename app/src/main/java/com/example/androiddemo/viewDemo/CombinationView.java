package com.example.androiddemo.viewDemo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author clll
 * @date 2022/8/1 1:15
 */
public class CombinationView extends FrameLayout {
    public CombinationView(@NonNull Context context) {
        super(context);
    }

    public CombinationView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CombinationView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CombinationView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


}
