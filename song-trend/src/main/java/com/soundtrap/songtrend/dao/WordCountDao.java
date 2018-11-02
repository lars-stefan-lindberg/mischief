package com.soundtrap.songtrend.dao;

import com.soundtrap.songtrend.entity.WordCount;

import java.util.List;

public interface WordCountDao {
    List<WordCount> findWordCounts(String word, String from, String to);
    int batchUpdate(List<WordCount> wordCountList, int batchSize);
}
