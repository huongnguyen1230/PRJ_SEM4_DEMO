package com.example.demo_project.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.demo_project.MainActivity;
import com.example.demo_project.R;
import com.example.demo_project.entity.Word;
import com.example.demo_project.service.WordService;
import com.example.demo_project.util.RetrofitGenerator;
import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.Response;
import retrofit2.Retrofit;

public class AddNewWordActivity extends AppCompatActivity {
    private EditText etWord, etWordMeaning, etPartOfSpeech, etWordExample, etExampleTrans;
    private Button btnSubmit;
    private ImageView btn_back_add_form;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_word);
        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
            //your codes here

        }
        initData();
        initListener();
        initBackView();
    }
    private void initData() {
        etWord = findViewById(R.id.etWord);
        etWordMeaning = findViewById(R.id.etWordMeaning);
        etPartOfSpeech = findViewById(R.id.etPartOfSpeech);
        etWordExample = findViewById(R.id.etWordExample);
        etExampleTrans = findViewById(R.id.etExampleTrans);
        btnSubmit = findViewById(R.id.btnSubmit);
        btn_back_add_form = findViewById(R.id.btn_back_add_form);
    }
    private void initListener() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String word = etWord.getText().toString();
                String meaningWord = etWordMeaning.getText().toString();
                String partOfSpeech = etPartOfSpeech.getText().toString();
                String example = etWordExample.getText().toString();
                String translated_example = etExampleTrans.getText().toString();

                Word newWord = new Word();
                newWord.setName(word);
                newWord.setContent(meaningWord);
                newWord.setPart_of_speech(partOfSpeech);
                newWord.setExample(example);
                newWord.setExampleTrans(translated_example);
                newWord.setUser_id(1);

                WordService wordService = RetrofitGenerator.createService(WordService.class);
                Log.d("Thất bại", new Gson().toJson(newWord));
                Response<Word> wordCall = null;
                try {
                    wordCall = wordService.addNewWord(newWord).execute();
                    if(wordCall.isSuccessful()){
                        CharSequence charSequence = "Tạo thành công";
                        Toast toast = Toast.makeText(getApplicationContext(), charSequence, Toast.LENGTH_LONG);
                        toast.show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    CharSequence charSequence = e.getMessage();
                    Toast toast = Toast.makeText(getApplicationContext(), charSequence, Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }
    private void initBackView() {
        btn_back_add_form = findViewById(R.id.btn_back_add_form);
        btn_back_add_form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddNewWordActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}