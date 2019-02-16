package com.creativesource.simpledrawerlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class SimpleDrawerLayout extends DrawerLayout {

    private boolean drawerItem;
    private FrameLayout frameLayout;
    private NavigationView navigationView;
    private int menuId = -1;
    private int layoutId = -1;
    private DrawerLayout drawerLayout;

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
        navigationView = findViewById(R.id.navigation);
        drawerLayout = findViewById(R.id.drawer_layout);

        if(set == null)
            return;

        TypedArray ta = context.obtainStyledAttributes(set, R.styleable.SimpleDrawerLayout_Layout);
        menuId = ta.getResourceId(R.styleable.SimpleDrawerLayout_Layout_menuRes, -1);
        layoutId = ta.getResourceId(R.styleable.SimpleDrawerLayout_Layout_headerLayout, -1);
        DrawerLayout.LayoutParams params = new DrawerLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        params.gravity = ta.getInteger(R.styleable.SimpleDrawerLayout_Layout_drawerGravity, GravityCompat.START);
        navigationView.setLayoutParams(params);
        ta.recycle();

        if(menuId > -1)
            navigationView.inflateMenu(menuId);

        if(layoutId > -1)
            navigationView.inflateHeaderView(layoutId);
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if(frameLayout == null){
            super.addView(child, index, params);
        } else {
            if(drawerItem) {
                if(menuId > -1)
                    navigationView.addHeaderView(child);
                else
                    navigationView.addView(child, index, params);
            }
            else
                frameLayout.addView(child, index, params);
        }
    }

    @Override
    public ViewGroup.LayoutParams generateLayoutParams (AttributeSet attrs){
        LayoutParams params = new SimpleDrawerLayout.LayoutParams(getContext(), attrs);
        return params;
    }

    @Override
    protected boolean checkLayoutParams (ViewGroup.LayoutParams p){
        return p instanceof LayoutParams;
    }

    @Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams (){
        return new LayoutParams(getContext(), null);
    }


    public class LayoutParams extends DrawerLayout.LayoutParams{


        public LayoutParams(Context context, AttributeSet attrs) {
            super(context, attrs);
            TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.SimpleDrawerLayout_Layout);
            drawerItem = arr.getBoolean(R.styleable.SimpleDrawerLayout_Layout_drawerItem,false);
            arr.recycle();
        }

    }

    public void setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener navigationListener) {
        navigationView.setNavigationItemSelectedListener(navigationListener);
    }

    public void closeDrawers() {
        drawerLayout.closeDrawers();
    }

    @Override
    public void openDrawer(int gravity) {
        drawerLayout.openDrawer(gravity);
    }
}
