package com.example.androiddemo.toolbarDemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;

import com.example.androiddemo.R;

import java.lang.reflect.Field;

public class ToolbarActivity extends AppCompatActivity {
    private Handler mHandler;
    private static final String TAG = "ToolbarActivity.class";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTheme(R.style.MyTheme_MyToolbarStyle);

        setContentView(R.layout.activity_toolbar);

        Toolbar toolbar = findViewById(R.id.toolbar);

        if (mHandler == null) {
            mHandler = new Handler();
        }
//        toolbar.setTitle("Title");
//        toolbar.setSubtitle("Subtitle");
//        toolbar.setLogo(R.mipmap.ic_launcher);

        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_white);


        try {
            Class cls = toolbar.getClass();
            Field field =  cls.getDeclaredField("mNavButtonView");
            field.setAccessible(true);
            Object button = field.get(toolbar);
            ImageButton iButton = (ImageButton) button;
            System.out.println(iButton);

            toolbar.post(new Runnable() {
                @Override
                public void run() {
                    Log.d(TAG, "run: " + toolbar.getPaddingLeft());

                }
            });

            toolbar.setPadding(0, 0, 0, 0);
            iButton.post(() -> {
                Log.d(TAG, "button widt: " + iButton.getWidth());
            });

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }
}