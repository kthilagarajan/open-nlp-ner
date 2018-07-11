package com.mynlp.nlporgfinder;

import java.util.HashMap;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class NlporgfinderApplication {

    public static void main(String[] args) {
        HashMap<String, Object> props = new HashMap<>();
        props.put("server.port", 2010);

        new SpringApplicationBuilder()
                .sources(NlporgfinderApplication.class)
                .properties(props)
                .run(args);
    }
}
