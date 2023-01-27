package com.kafka.config;

import com.kafka.entity.WikimediaData;
import com.kafka.repository.WikimediaDataRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaDatabaseConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
    private final WikimediaDataRepository repository;

    @KafkaListener(topics = "wikimedia_recentChange", groupId = "myGroup")
    public void consume(String message){
        LOGGER.info(String.format("Message received -> %s", message));

        WikimediaData wikimediaData = new WikimediaData();

        wikimediaData.setWikiEventData(message);
        repository.save(wikimediaData);
    }

}
