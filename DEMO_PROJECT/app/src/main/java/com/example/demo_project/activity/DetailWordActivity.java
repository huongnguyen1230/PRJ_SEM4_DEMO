package com.example.demo_project.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demo_project.R;
import com.example.demo_project.entity.Word;
import com.example.demo_project.entity.WordResponse;
import com.example.demo_project.service.WordService;
import com.example.demo_project.util.RetrofitGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

public class DetailWordActivity extends AppCompatActivity {
    TextView tvName_word_detail, tvPos_word_detail, tvWord_detail_meaning, tvWord_detail_example, tvWord_detail_example_trans;
    ImageView back_detail_word_page, search_detail_word_page, edit_detail_word_page;
    Word currentWord;
    List<Word> words;
//        WordService wordService;
    int currentPosition;
    int x = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_word);

        initView();
        initData();
    }
    private void initView() {
        tvName_word_detail = findViewById(R.id.name_word_detail);
        tvPos_word_detail = findViewById(R.id.pos_word_detail);
        tvWord_detail_example = findViewById(R.id.word_detail_example);
        tvWord_detail_example_trans = findViewById(R.id.word_detail_example_trans);
        back_detail_word_page = findViewById(R.id.btn_back_detail_word_page);
        edit_detail_word_page = findViewById(R.id.btn_edit_detail_word_page);
        search_detail_word_page = findViewById(R.id.btn_search_detail_word_page);
    }
    private void initData() {
//        words =(List<Word>) getIntent().getSerializableExtra("words");
//        currentPosition = getIntent().getIntExtra("position", 0);
//        currentWord = words.get(currentPosition);
//        tvName_word_detail.setText(currentWord.getName());
//        tvPos_word_detail.setText(currentWord.getPart_of_speech());
//        tvWord_detail_meaning.setText(currentWord.getContent());
//        tvWord_detail_example.setText(currentWord.getExample());
//        tvWord_detail_example_trans.setText(currentWord.getExampleTrans());
        
    }
}