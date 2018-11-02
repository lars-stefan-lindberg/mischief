package com.soundtrap.songtrend.scheduler;

import com.soundtrap.songtrend.client.SongData;
import com.soundtrap.songtrend.client.SoundCloudApi;
import com.soundtrap.songtrend.dao.WordCountDao;
import com.soundtrap.songtrend.entity.WordCount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ScheduledTasks {

    Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    @Value("${wordcount.batchsize}")
    private int wordCountBatchSize;

    @Autowired
    SoundCloudApi soundCloudApi;

    @Autowired
    WordCountDao wordCountDao;

    @Scheduled(cron = "${cron.storedailysongdata.expression}")
    public void storeSongData() {
        logger.info("Starting the store song data task...");

        SongData[] songData = soundCloudApi.getDailySongData();
        logger.info("Found {} number of song data objects.", songData.length);

        //Count the number of occurrences of each word song titles
        Map<String, Integer> wordCountMap = getSongTitleWordCount(songData);

        //Preparing list of objects to store to database
        Date today = new Date();
        List<WordCount> wordCountList = new ArrayList<>();
        wordCountMap.forEach((word, count) -> wordCountList.add(new WordCount(word, today, count)));

        logger.info("Storing {} word count objects to database...", wordCountList.size());
        int totalInserted = wordCountDao.batchUpdate(wordCountList, wordCountBatchSize);

        logger.info("Daily song data task completed. Inserted {} number of records.", totalInserted);
    }

    private Map<String, Integer> getSongTitleWordCount(SongData[] songData) {
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (SongData song : songData) {
            String songTitle = song.getTitle();

            for (String word : songTitle.toLowerCase().split(" ")) {
                if (word.trim().matches("[A-Za-z]+")) {
                    Integer count = wordCountMap.get(word);
                    if (count == null) {
                        wordCountMap.put(word, 1);
                    } else {
                        wordCountMap.put(word, count + 1);
                    }
                }
            }
        }

        return wordCountMap;
    }
}
