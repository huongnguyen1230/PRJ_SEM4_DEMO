package com.example.bottomnavigationview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.widget.LinearLayout;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class ScrollToolbarActivity extends AppCompatActivity {
    AppBarLayout appBarLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    RecyclerView rvWord;
    Menu mMenu;
    boolean isExpanded = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_toolbar);
        
        initView();
        initToolbar();
        initToolbarAnnimation();

    }
    private void initView() {
        appBarLayout = findViewById(R.id.appBarLayout);
        collapsingToolbarLayout = findViewById(R.id.collapsingToolbarLayout);
        toolbar = findViewById(R.id.toolbar);
        rvWord = findViewById(R.id.rvWord);
    }
    private void initToolbar() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
    private void initToolbarAnnimation() {
        collapsingToolbarLayout = findViewById(R.id.collapsingToolbarLayout);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.banner_list_word);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {
                int myColor = palette.getVibrantColor(getResources().getColor(R.color.orange));
                collapsingToolbarLayout.setContentScrimColor(myColor);
                collapsingToolbarLayout.setStatusBarScrimColor(getResources().getColor(R.color.orange));
            }
        });
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (Math.abs(verticalOffset) > 200){
                    isExpanded = false;
                } else {
                    isExpanded = true;
                }
                invalidateOptionsMenu();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list, menu);
        mMenu = menu;
        return true;
    }

}