package com.creativesourceapps.android.simpledrawerlayout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;

public class SimpleDrawerLayout extends DrawerLayout {

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

    private void init(Context context, AttributeSet set) {}
}
