package com.example.demo_project.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;

import com.example.demo_project.R;
import com.example.demo_project.adapter.WordAdapter;
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
    }

    private void initView() {

        rvWord = findViewById(R.id.rvWord);
        rvWord.setLayoutManager(new LinearLayoutManager(this));
        rvWord.setAdapter(new WordAdapter(this, words));
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
}