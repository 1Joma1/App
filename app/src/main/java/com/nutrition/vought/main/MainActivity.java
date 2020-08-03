package com.nutrition.vought.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nutrition.vought.R;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        listener();
    }

    private void initView(){
        viewPager = findViewById(R.id.main_view_pager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        viewPager.setOffscreenPageLimit(5);
        bottomNavigationView = findViewById(R.id.main_bottom_navigation);
    }

    private void listener(){
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_blog:
                        viewPager.setCurrentItem(0, false);
                        break;
                    case R.id.menu_food:
                        viewPager.setCurrentItem(1, false);
                        break;
                    case R.id.menu_search:
                        viewPager.setCurrentItem(2, false);
                        break;
                    case R.id.menu_chat:
                        viewPager.setCurrentItem(3, false);
                        break;
                    case R.id.menu_profile:
                        viewPager.setCurrentItem(4, false);
                        break;
                }
                return true;
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bottomNavigationView.setSelectedItemId(R.id.menu_blog);
                        break;
                    case 1:
                        bottomNavigationView.setSelectedItemId(R.id.menu_food);
                        break;
                    case 2:
                        bottomNavigationView.setSelectedItemId(R.id.menu_search);
                        break;
                    case 3:
                        bottomNavigationView.setSelectedItemId(R.id.menu_chat);
                        break;
                    case 4:
                        bottomNavigationView.setSelectedItemId(R.id.menu_profile);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() != 0) {
            viewPager.setCurrentItem(0, false);
        } else {
            super.onBackPressed();
        }
    }
}