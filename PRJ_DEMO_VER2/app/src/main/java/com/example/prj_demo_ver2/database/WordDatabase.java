package com.example.prj_demo_ver2.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.prj_demo_ver2.entity.Word;

@Database(entities = {Word.class}, version = 1)
public abstract class WordDatabase extends RoomDatabase{
    private static WordDatabase wordDatabase;

    public abstract com.example.prj_demo_ver2.database.WordDao wordDao();

    public static WordDatabase getAppDatabase(Context context){
        if (wordDatabase == null){
            wordDatabase = Room.databaseBuilder(context, WordDatabase.class, "Words").allowMainThreadQueries().build();
        }
        return wordDatabase;
    }
}
