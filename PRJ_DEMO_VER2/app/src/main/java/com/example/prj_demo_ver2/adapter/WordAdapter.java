package com.example.prj_demo_ver2.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.prj_demo_ver2.R;
import com.example.prj_demo_ver2.entity.Word;

import java.util.List;

public class WordAdapter extends RecyclerView.Adapter {
    private Activity activity;
    private List<Word> listWord;
    public WordAdapter(Activity activity, List<Word> listWord){
        this.activity = activity;
        this.listWord = listWord;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.item_list_word, parent, false);
        WordHolder holder = new WordHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        WordHolder wordHolder = (WordHolder) holder;
        Word model = listWord.get(position);
        wordHolder.tvWord.setText(model.getName());
        wordHolder.tvMeaning.setText(model.getContent());
        wordHolder.tvPartOfSpeech.setText(model.getPart_of_speech());
    }

    @Override
    public int getItemCount() {
        return listWord.size();
    }
    public class WordHolder extends RecyclerView.ViewHolder{
        TextView tvWord;
        TextView tvMeaning;
        TextView tvPartOfSpeech;
        public WordHolder(@NonNull View itemView){
            super(itemView);
            tvWord = itemView.findViewById(R.id.tv_word);
            tvMeaning = itemView.findViewById(R.id.tv_meaning);
            tvPartOfSpeech = itemView.findViewById(R.id.tv_part_of_speech);
        }
    }
}
