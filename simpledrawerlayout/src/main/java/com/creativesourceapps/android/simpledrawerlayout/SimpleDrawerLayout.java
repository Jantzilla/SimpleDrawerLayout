package com.creativesourceapps.android.simpledrawerlayout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class SimpleDrawerLayout extends DrawerLayout {

    private FrameLayout frameLayout;

    public SimpleDrawerLayout(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public SimpleDrawerLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public SimpleDrawerLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet set) {
        LayoutInflater.from(context).inflate(R.layout.simple_drawer_layout, this, true);
        frameLayout = findViewById(R.id.fl_main);
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
    }
}
