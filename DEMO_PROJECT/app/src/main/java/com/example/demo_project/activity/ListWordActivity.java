package com.example.demo_project.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.demo_project.R;
import com.example.demo_project.adapter.WordAdapter;
import com.example.demo_project.database.WordDatabase;
import com.example.demo_project.entity.Word;

import java.util.ArrayList;
import java.util.List;

public class ListWordActivity extends AppCompatActivity {
    private List<Word> wordList = new ArrayList<>();
    private RecyclerView rvWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_word);
        initData();
        WordAdapter adapter = new WordAdapter(this,wordList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        RecyclerView rvWord = findViewById(R.id.rvWord);
        rvWord.setLayoutManager(layoutManager);
        rvWord.setAdapter(adapter);
    }

    private void initData() {
        rvWord = findViewById(R.id.rvWord);
        wordList = WordDatabase.getAppDatabase(this).wordDao().getAllWord();
    }
}