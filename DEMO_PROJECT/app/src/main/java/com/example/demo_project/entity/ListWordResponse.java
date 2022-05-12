package com.example.demo_project.entity;

import java.util.List;

public class ListWordResponse {
    private List<Word> data;
    private String message;

    public ListWordResponse(List<Word> data, String message) {
        this.data = data;
        this.message = message;
    }

    public ListWordResponse() {
    }

    public List<Word> getData() {
        return data;
    }

    public void setData(List<Word> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
