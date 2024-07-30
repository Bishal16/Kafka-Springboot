package dev.mahathir.kafkaspringboot.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class kafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(kafkaConsumer.class);
    @KafkaListener(topics = "specialTopic", groupId = "myGroup")
    public void consume(String message) {
        LOGGER.info("Message received -> " + message);
    }

}
