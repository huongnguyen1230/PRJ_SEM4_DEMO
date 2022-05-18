package com.example.demo_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.demo_project.activity.AddNewWordActivity;
import com.example.demo_project.activity.FragmentAccount;
import com.example.demo_project.activity.FragmentHome;
import com.example.demo_project.activity.FragmentSearch;
import com.example.demo_project.activity.FragmentSetting;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener{
    FrameLayout frameLayout;
    FloatingActionButton floatingActionButton;
    BottomNavigationView bottomNavigationView;
    FragmentHome fragmentHome;
    FragmentSearch fragmentSearch;
    FragmentAccount fragmentAccount;
    FragmentSetting fragmentSetting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView() {
        floatingActionButton = findViewById(R.id.btn_floating_add);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddNewWordActivity.class);
                startActivity(intent);
            }
        });

        frameLayout = findViewById(R.id.frameLayout);
        bottomNavigationView = findViewById(R.id.btn_navigation_view);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.setOnItemSelectedListener(this);

        fragmentHome = new FragmentHome();
        fragmentSearch = new FragmentSearch();
        fragmentAccount = new FragmentAccount();
        fragmentSetting = new FragmentSetting();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, fragmentHome, FragmentHome.class.getName())
                .commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_home:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, fragmentHome, FragmentHome.class.getName())
                        .commit();
                break;
            case R.id.menu_search:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, fragmentSearch, FragmentSearch.class.getName())
                        .commit();
                break;

            case R.id.menu_account:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, fragmentAccount, FragmentAccount.class.getName())
                        .commit();
                break;
            case R.id.menu_setting:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, fragmentSetting, FragmentSetting.class.getName())
                        .commit();
                break;
        }
        return false;
    }
}