package com.example.demo_project.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Word{
    public int id;
    public String name;
    public String content;
    public String example;
    public String translated_example;
    public String pronounce;
    public String partOfSpeech;
    public int user_id;
    public String last_remind;
    public int category_type;
    public int success_time;
    public String created_at;
    public String updated_at;

    public Word() {
    }

    public Word(int id, String name, String content, String example, String translated_example, String pronounce, String partOfSpeech, int user_id, String last_remind, int category_type, int success_time, String created_at, String updated_at) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.example = example;
        this.translated_example = translated_example;
        this.pronounce = pronounce;
        this.partOfSpeech = partOfSpeech;
        this.user_id = user_id;
        this.last_remind = last_remind;
        this.category_type = category_type;
        this.success_time = success_time;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getTranslated_example() {
        return translated_example;
    }

    public void setTranslated_example(String translated_example) {
        this.translated_example = translated_example;
    }

    public String getPronounce() {
        return pronounce;
    }

    public void setPronounce(String pronounce) {
        this.pronounce = pronounce;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getLast_remind() {
        return last_remind;
    }

    public void setLast_remind(String last_remind) {
        this.last_remind = last_remind;
    }

    public int getCategory_type() {
        return category_type;
    }

    public void setCategory_type(int category_type) {
        this.category_type = category_type;
    }

    public int getSuccess_time() {
        return success_time;
    }

    public void setSuccess_time(int success_time) {
        this.success_time = success_time;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public static class DateConverter {
        @TypeConverter
        public static Date toDate(Long timestamp) {
            return timestamp == null ? null : new Date(timestamp);
        }
        @TypeConverter
        public static Long toTimestamp(Date date) {
            return date == null ? null : date.getTime();
        }
    }
}
