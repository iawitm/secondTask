package com.example.user.secondtask.ui.list;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.user.secondtask.R;
import com.example.user.secondtask.adapters.CountScrollListener;
import com.example.user.secondtask.adapters.RecyclerAdapter;
import com.example.user.secondtask.entity.Technology;
import com.example.user.secondtask.ui.info.TechesHolderFragment;
import com.example.user.secondtask.ui.main.MainActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TechListFragment extends Fragment {

    View fragmentView;
    ArrayList<Technology> technologies;
    int counter;
    int prevpos = -1;

    public TechListFragment() { }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        technologies = (ArrayList<Technology>) getArguments().getSerializable("data");

        fragmentView = inflater.inflate(R.layout.fragment_tech_list, container, false);
        RecyclerView recycler = fragmentView.findViewById(R.id.techListRecycler);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setAdapter(new RecyclerAdapter(technologies, position -> {
            ((MainActivity) getActivity()).showDescriptionFragment(new TechesHolderFragment(), position);
        }, getContext(), pos -> {
            if (prevpos < pos){
                counter++;
                prevpos++;
                Toast toast = Toast.makeText(getContext(), String.valueOf(counter), Toast.LENGTH_LONG);
                toast.show();
            }
        }));
        return fragmentView;
    }

}
