package com.soundtrap.songtrend.dao;

import com.soundtrap.songtrend.entity.WordCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class WordCountDaoImpl implements WordCountDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<WordCount> findWordCounts(String word, String from, String to) {
        Map namedParameters = new HashMap<>();
        namedParameters.put("word", word);
        namedParameters.put("from", from);
        namedParameters.put("to", to);
        return namedParameterJdbcTemplate.query("select * from word_count where word=:word and date >= :from and date <= :to",
                namedParameters,
                new WordCountRowMapper());
    }

    public int batchUpdate(List<WordCount> wordCountList, int batchSize) {
        int numberOfCalls = (wordCountList.size() / batchSize) + 1;
        int totalInserted = 0;
        for(int i = 1; i <= numberOfCalls; i++) {
            int endIndex = i == numberOfCalls ? wordCountList.size() : batchSize * i ;
            int[] inserts = batchUpdate(wordCountList.subList((i - 1) * batchSize, endIndex));
            for(int insertCount : inserts) {
                totalInserted += insertCount;
            }
        }

        return totalInserted;
    }

    private int[] batchUpdate(List<WordCount> wordCountList) {
        SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(wordCountList.toArray());
        int[] updateCounts = namedParameterJdbcTemplate.batchUpdate("insert into word_count values (:word, :date, :count)", batch);
        return updateCounts;
    }

    class WordCountRowMapper implements RowMapper<WordCount> {

        public WordCountRowMapper() {}

        @Override
        public WordCount mapRow(ResultSet rs, int rowNum) throws SQLException {
            WordCount wordCount = new WordCount();
            wordCount.setWord(rs.getString("word"));
            wordCount.setCount(rs.getInt("count"));
            wordCount.setDate(rs.getDate("date"));
            return wordCount;
        }
    }
}
