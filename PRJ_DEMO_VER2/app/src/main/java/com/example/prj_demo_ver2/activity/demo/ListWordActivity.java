package com.example.prj_demo_ver2.activity.demo;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo_project.MainActivity;
import com.example.demo_project.R;
import com.example.demo_project.adapter.ListWordAdapter;
import com.example.demo_project.entity.Word;
import com.example.demo_project.entity.WordResponse;
import com.example.demo_project.service.WordService;
import com.example.demo_project.util.RetrofitGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

public class ListWordActivity extends AppCompatActivity {
    private List<Word> words;
    private RecyclerView rvWord;
    private WordService wordService;
    private ImageView btn_back_list_word, btn_setting_list_word;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int SDK_INT = Build.VERSION.SDK_INT;
        if (SDK_INT > 8)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
            //your codes here
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_word);
        initData();
        initView();
        initBackView();
        initSettingView();
    }

    private void initView() {

        rvWord = findViewById(R.id.rvWord);
        rvWord.setLayoutManager(new LinearLayoutManager(this));
        rvWord.setAdapter(new ListWordAdapter(this, words));
    }

    private void initData() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        words = new ArrayList<>();
        if (wordService == null){
            wordService = RetrofitGenerator.createService(WordService.class);
        }
        try {
            Response<WordResponse> listResponse = wordService.getAll().execute();
            if (listResponse.isSuccessful()){
               words.addAll(listResponse.body().getContent());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void initBackView() {
        btn_back_list_word = findViewById(R.id.btn_back_list_word);
        btn_back_list_word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListWordActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private void initSettingView() {
        btn_setting_list_word = findViewById(R.id.btn_setting_list_word);
        btn_setting_list_word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListWordActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });
    }
}