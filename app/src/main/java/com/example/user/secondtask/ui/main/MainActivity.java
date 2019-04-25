package com.example.user.secondtask.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user.secondtask.R;
import com.example.user.secondtask.adapters.RecyclerAdapter;
import com.example.user.secondtask.entity.Technology;
import com.example.user.secondtask.ui.info.TechesHolderFragment;
import com.example.user.secondtask.ui.list.TechListFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Technology> technologies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        technologies = (ArrayList<Technology>) getIntent().getSerializableExtra("data");
        if (savedInstanceState == null) showListFragment(new TechListFragment());
    }

    void showListFragment(TechListFragment fragment){
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", technologies);
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment, "list")
                .commit();
    }

    public void showDescriptionFragment(TechesHolderFragment fragment,  int position){
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", technologies);
        bundle.putInt("item_number", position);
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment, "description")
                .commit();
    }

    @Override
    public void onBackPressed(){
        if (getSupportFragmentManager().findFragmentByTag("description") != null){
            showListFragment(new TechListFragment());
        }
        else{
            super.onBackPressed();
        }
    }
}
