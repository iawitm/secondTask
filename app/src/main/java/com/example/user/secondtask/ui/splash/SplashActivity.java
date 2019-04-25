package com.example.user.secondtask.ui.splash;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.secondtask.R;
import com.example.user.secondtask.entity.Technology;
import com.example.user.secondtask.ui.main.MainActivity;

import java.util.ArrayList;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        SplashViewModel viewModel = ViewModelProviders.of(this).get(SplashViewModel.class); // назначение вьюмодели для этой активности
        viewModel.getData();

        viewModel.technologies.observe(this, technologies -> { // observe - позволяет наблюдать за изменениями в technologies,
            if (technologies != null){
                ArrayList<Technology> no_null_technologies =  new ArrayList<>();
                for (Technology t: technologies) if(t.getName() != null) no_null_technologies.add(t);
                Intent switchToMain = new Intent(this, MainActivity.class);
                switchToMain.putExtra("data", no_null_technologies);
                startActivity(switchToMain);
                finish();
            }
        });

    }
}
