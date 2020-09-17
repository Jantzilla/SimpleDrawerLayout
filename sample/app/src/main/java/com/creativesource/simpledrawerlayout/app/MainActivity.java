package com.creativesource.simpledrawerlayout.app;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.creativesource.simpledrawerlayout.SimpleDrawerLayout;

public class MainActivity extends AppCompatActivity {

    private View navigation;
    private TextView option_1, option_2, option_3, option_4;
    public static Fragment restoreFragment;
    private Fragment fragment;
    private SimpleDrawerLayout drawerLayout;
    private FragmentManager fragmentManager;
    private Toolbar toolbar;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        option_1 = findViewById(R.id.tv_option1);
        option_2 = findViewById(R.id.tv_option2);
        option_3 = findViewById(R.id.tv_option3);
        option_4 = findViewById(R.id.tv_option4);
        drawerLayout = findViewById(R.id.simple_drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.menu);

        fragmentManager = getSupportFragmentManager();

        navigation = option_1;
        option_1.setBackgroundColor(getResources().getColor(R.color.colorChecked));
        fragment = new FirstFragment();
        fragmentManager.beginTransaction().add(R.id.fl_content_main, fragment).commit();

        option_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateNavigation(option_1);
                drawerLayout.closeDrawers();
                fragment = new FirstFragment();
                MainActivity.restoreFragment = fragment;
                fragmentManager.beginTransaction().replace(R.id.fl_content_main, fragment).commit();
            }
        });
        option_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateNavigation(option_2);
                drawerLayout.closeDrawers();
                fragment = new SecondFragment();
                MainActivity.restoreFragment = fragment;
                fragmentManager.beginTransaction().replace(R.id.fl_content_main, fragment).commit();
            }
        });
        option_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateNavigation(option_3);
                drawerLayout.closeDrawers();
                fragment = new ThirdFragment();
                MainActivity.restoreFragment = fragment;
                fragmentManager.beginTransaction().replace(R.id.fl_content_main, fragment).commit();
            }
        });
        option_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateNavigation(option_4);
                drawerLayout.closeDrawers();
                fragment = new FourthFragment();
                MainActivity.restoreFragment = fragment;
                fragmentManager.beginTransaction().replace(R.id.fl_content_main, fragment).commit();
            }
        });

    }

    private void animateNavigation(View view) {

        if(navigation == null) {
            navigation = view;
            navigation.setBackgroundColor(getResources().getColor(R.color.colorChecked));
        }
        else {
            navigation.setBackgroundColor(getResources().getColor(R.color.colorUnchecked));
            view.setBackgroundColor(getResources().getColor(R.color.colorChecked));
            navigation = view;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
