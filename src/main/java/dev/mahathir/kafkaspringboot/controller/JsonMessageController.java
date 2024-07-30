package dev.mahathir.kafkaspringboot.controller;

import dev.mahathir.kafkaspringboot.kafkaSevice.JsonKafkaProducer;
import dev.mahathir.kafkaspringboot.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/v1/json")
//http:localhost:8080/api/v1/json/message
public class JsonMessageController {
    private JsonKafkaProducer jsonKafkaProducer;
    public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }
    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        jsonKafkaProducer.sendMessage(user);
        return  ResponseEntity.ok("Message sent to topic");
    }
}
