package com.soundtrap.songtrend.entity;

import java.util.Date;

public class WordCount {

    private String word;
    private Date date;
    private int count;

    public WordCount() {}

    public WordCount(String word, Date date, int count) {
        this.word = word;
        this.date = date;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
