package com.soundtrap.songtrend.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestContextConfiguration.class)
public class SoundCloudApiImplTest {

    @Autowired
    SoundCloudApi soundCloudApi;

    @Test
    public void testGetDailySongData() throws Exception {
        SongData[] songData = soundCloudApi.getDailySongData();

//        System.out.println("Song titles:");
//        for(SongData sd : songData) {
//            System.out.println(sd.getTitle());
//        }

        assertThat(songData)
                .isNotEmpty()
                .doesNotContainNull();
    }
}