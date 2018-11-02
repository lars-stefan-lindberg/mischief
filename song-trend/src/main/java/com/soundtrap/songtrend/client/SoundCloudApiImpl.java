package com.soundtrap.songtrend.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Component
public class SoundCloudApiImpl implements SoundCloudApi {

    @Value("${soundcloudapi.songdata.endpoint}")
    private String dailySongDataEndpoint;

    @Override
    public SongData[] getDailySongData() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(dailySongDataEndpoint, SongData[].class);
    }
}
