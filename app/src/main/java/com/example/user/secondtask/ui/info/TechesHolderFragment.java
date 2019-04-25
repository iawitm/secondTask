package com.example.user.secondtask.ui.info;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.secondtask.R;
import com.example.user.secondtask.adapters.ViewPagerAdapter;
import com.example.user.secondtask.entity.Technology;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TechesHolderFragment extends Fragment {

    View fragmentView;
    ArrayList<Technology> technologies;

    public TechesHolderFragment() { }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragment_teches_holder, container, false);
        technologies = (ArrayList<Technology>) getArguments().getSerializable("data");
        ViewPager viewPager = fragmentView.findViewById(R.id.fragmentsHolder);
        ViewPagerAdapter adapter = new ViewPagerAdapter(technologies, getChildFragmentManager());
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(getArguments().getInt("item_number"));
        return fragmentView;
    }

}
