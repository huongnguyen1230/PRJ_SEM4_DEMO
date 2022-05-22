package com.example.prj_demo_ver2.activity.demo;

import android.os.Bundle;
import android.widget.TableLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.demo_project.R;

public class HomeActivity extends AppCompatActivity {
    private TableLayout mTablayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_demo);
    }
}