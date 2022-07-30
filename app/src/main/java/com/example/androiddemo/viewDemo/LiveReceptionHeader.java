package com.example.androiddemo.viewDemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.androiddemo.R;

public class LiveReceptionHeader extends FrameLayout {

    public LiveReceptionHeader(@NonNull Context context) {
        super(context);
    }

    public LiveReceptionHeader(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public LiveReceptionHeader(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LiveReceptionHeader(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_live_reception_header, this);
    }
}
