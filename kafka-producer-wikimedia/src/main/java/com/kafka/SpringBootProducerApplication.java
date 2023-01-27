package com.kafka;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class SpringBootProducerApplication implements CommandLineRunner {
    public static void main(String[] args) {SpringApplication.run(SpringBootProducerApplication.class);}
    private final WikimediaChangeProducer wikimediaChangeProducer;

    @Override
    public void run(String... args) throws Exception {
        wikimediaChangeProducer.sendMessage();
    }
}