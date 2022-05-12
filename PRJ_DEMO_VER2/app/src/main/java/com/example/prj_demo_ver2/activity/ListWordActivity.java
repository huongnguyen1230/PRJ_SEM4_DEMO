package com.example.prj_demo_ver2.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prj_demo_ver2.R;
import com.example.prj_demo_ver2.adapter.WordAdapter;
import com.example.prj_demo_ver2.database.WordDatabase;
import com.example.prj_demo_ver2.entity.Word;

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