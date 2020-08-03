package com.nutrition.vought.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.nutrition.vought.blog.BlogFragment;
import com.nutrition.vought.food.FoodFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 1:
                return new FoodFragment();
            case 2:
                return new BlogFragment();
            case 3:
                return new BlogFragment();
            case 4:
                return new BlogFragment();
            default:
                return new BlogFragment();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }
}
