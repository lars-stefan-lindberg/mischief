package com.soundtrap.songtrend.dto;

import java.io.Serializable;
import java.util.List;

public class WordStatisticsResponse implements Serializable {

    private String word;
    private List<TimeSeries> timeSeries;

    public WordStatisticsResponse() {}

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<TimeSeries> getTimeSeries() {
        return timeSeries;
    }

    public void setTimeSeries(List<TimeSeries> timeSeries) {
        this.timeSeries = timeSeries;
    }
}
