package com.example.user.secondtask.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.user.secondtask.entity.Technology;
import com.example.user.secondtask.ui.info.TechInfoFragment;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

   private ArrayList<Technology> technologies;

    public ViewPagerAdapter(ArrayList<Technology> technologies, FragmentManager fragmentManager){
        super(fragmentManager);
        this.technologies = technologies;
    }

    @Override
    public Fragment getItem(int i) {
        TechInfoFragment fragment = new TechInfoFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", technologies.get(i));
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return technologies.size();
    }
}
