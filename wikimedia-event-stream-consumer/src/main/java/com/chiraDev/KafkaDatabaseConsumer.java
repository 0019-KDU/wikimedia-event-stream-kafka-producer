package com.chiraDev;

import com.chiraDev.entity.WikimediaData;
import com.chiraDev.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class KafkaDatabaseConsumer {

    private  static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    private final WikimediaDataRepository wikimediaDataRepository;

    public KafkaDatabaseConsumer(WikimediaDataRepository wikimediaDataRepository) {
        this.wikimediaDataRepository = wikimediaDataRepository;
    }

    @KafkaListener(
            topics = "wikimedia_recentchange",
            groupId = "myGroup",
            containerFactory = "kafkaListenerContainerFactory"  // Specify the batch-enabled container factory
    )
    @Transactional
    public void consume(List<String> eventMessage) {
        LOGGER.info("Event message received -> {}", eventMessage);

        try {
            // Persist the event message to the database
            WikimediaData wikimediaData = new WikimediaData();
            wikimediaData.setWikiEventData(eventMessage.toString());
            wikimediaDataRepository.save(wikimediaData);

            LOGGER.info("Event message saved to database successfully.");
        } catch (Exception e) {
            // Handle errors gracefully
            LOGGER.error("Error saving event message to database: {}", eventMessage, e);
            // Depending on your use case, you may want to retry or perform other actions
        }
    }
}
