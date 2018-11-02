package com.soundtrap.songtrend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soundtrap.songtrend.dao.WordCountDao;
import com.soundtrap.songtrend.dto.TimeSeries;
import com.soundtrap.songtrend.dto.WordStatisticsResponse;
import com.soundtrap.songtrend.entity.WordCount;
import com.soundtrap.songtrend.scheduler.ScheduledTasks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WordController {

    Logger logger = LoggerFactory.getLogger(WordController.class);

    @Autowired
    WordCountDao wordCountDao;

    @Autowired
    ScheduledTasks scheduledTasks;

    @GetMapping(value = "/word/", produces = "application/json")
    public WordStatisticsResponse getWordStatistics(@RequestParam("word") String word,
                                    @RequestParam("from") String from,
                                    @RequestParam("to") String to) {
        logger.trace("Incoming word statistics request: word={}, from={}, to={}", word, from, to);

        List<WordCount> wordCountList = wordCountDao.findWordCounts(word, from, to);
        logger.trace("Found {} word count object/objects.", wordCountList.size());

        WordStatisticsResponse response = transformToWordStatisticsResponse(word, wordCountList);
        try {
            ObjectMapper mapper = new ObjectMapper();
            logger.trace("Responding with: {}", mapper.writeValueAsString(response));
        } catch (JsonProcessingException e) {}

        return response;
    }

    @PostMapping(value = "/job/", produces = "application/json")
    public void runJob() {

        scheduledTasks.storeSongData();



    }

    private WordStatisticsResponse transformToWordStatisticsResponse(String word, List<WordCount> wordCountList) {
        WordStatisticsResponse response = new WordStatisticsResponse();
        response.setWord(word);

        List<TimeSeries> timeSeriesList = new ArrayList<>();
        wordCountList.forEach(wordCount -> timeSeriesList.add(new TimeSeries(wordCount.getDate(), wordCount.getCount())));
        response.setTimeSeries(timeSeriesList);

        return response;
    }
}
