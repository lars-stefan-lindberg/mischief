package com.soundtrap.songtrend.controller;

import com.soundtrap.songtrend.dao.WordCountDao;
import com.soundtrap.songtrend.entity.WordCount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(WordController.class)
public class WordControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private WordCountDao wordCountDao;

    @Test
    @WithMockUser(username = "user1", password = "superdupersecret", roles = "USER")
    public void testGetWordStatistics() throws Exception {

        List<WordCount> wordCountList = Arrays.asList(new WordCount("love", new Date(), 20),
                new WordCount("love", new Date(), 30));
        when(wordCountDao.findWordCounts("love", "2018-10-09", "2018-10-14")).thenReturn(wordCountList);

        mvc.perform(get("/word/?word=love&from=2018-10-09&to=2018-10-14")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.word", is("love")))
                .andExpect(jsonPath("$.timeSeries[0].count", is(20)))
                .andExpect(jsonPath("$.timeSeries[0].date", anything()))
                .andExpect(jsonPath("$.timeSeries[1].count", is(30)))
                .andExpect(jsonPath("$.timeSeries[1].date", anything()));
    }

    @Test
    public void testGetWordStatistics_unauthorized() throws Exception {

        mvc.perform(get("/word/?word=love&from=2018-10-09&to=2018-10-14"))
                .andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));
    }
}