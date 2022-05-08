package com.example.demo_project.database;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.demo_project.entity.Word;

import java.util.List;

@Dao
public interface WordDao {
    @Insert(onConflict = REPLACE)
    void insertWord(Word word);

    @Query("SELECT * FROM words" )
    List<Word> getAllWord();
}
