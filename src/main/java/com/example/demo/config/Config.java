package com.example.demo.config;

import com.example.demo.data.Data;
import com.example.demo.data.Output;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {

    @Bean
    @Scope("prototype")
    public Output output(Data data) {
        Output output = new Output();
        output.setOutput("I am output" + data.getName() + " output space " + data.getNumber());
        return output;
    }
}
