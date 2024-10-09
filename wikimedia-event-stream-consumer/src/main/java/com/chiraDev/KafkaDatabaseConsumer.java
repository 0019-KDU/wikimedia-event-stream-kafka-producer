package com.chiraDev;

import com.chiraDev.entity.WikimediaData;
import com.chiraDev.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    private WikimediaDataRepository wikimedaDataRepository;

    public KafkaDatabaseConsumer(WikimediaDataRepository wikimediaDataRepository) {
        this.wikimedaDataRepository = wikimediaDataRepository;
    }

    @KafkaListener(
            topics = "wikimedia_recentchange",
            groupId = "myGroup" // Define a unique group ID to ensure proper ordering and fault tolerance.
    )
    public void consume(String eventMessage) {
        LOGGER.info(String.format("Event message received ->%s", eventMessage));
        // Perform database operations here

        WikimediaData wikimediaData=new WikimediaData();

        wikimediaData.setWikiEventData(eventMessage);

        wikimedaDataRepository.save(wikimediaData);
    }
}
