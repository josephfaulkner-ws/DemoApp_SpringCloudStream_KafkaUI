package com.example.message_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
	private StreamBridge streamBridge;

    @PostMapping("/")
    public String sendMessage(@RequestBody Message message) {
        streamBridge.send("messages-out-0", message);
        return String.format("Message Sent %s", message);
    }

}
