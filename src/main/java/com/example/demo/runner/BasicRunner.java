package com.example.demo.runner;

import com.example.demo.data.Data;
import com.example.demo.data.Output;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class BasicRunner implements CommandLineRunner {
    @Autowired
    Data data;

    @Autowired
    Output output;

    @Override
    public void run(String... args) throws Exception {
        /*System.out.println("Output is: " + output.getOutput());
        //output = getOutput();
        System.out.println("Output is: " + output.getOutput());*/
        System.out.println("Data is: " + data.getName() + data.getNumber());
        data = getData("bikbik", 11);
        System.out.println("Data is: " + data.getName() + data.getNumber());

        System.out.println("Output is: " + output.getOutput());
        System.out.println("Output is: " + getOutput(data).getOutput());


    }

    @Lookup
    public Output getOutput(Data data) {
        return null;
    }

    @Lookup
    public Data getData(String name, int number) {
        return null;
    }


    public void refresh(Data data) {
        Output output = new Output();
        output.setOutput(data.getName() + " " + data.getNumber());
    }

    @Bean
    @Scope("prototype")
    public Data createData(@Value("name") String name, @Value("4") int number) {
        Data data = new Data();
        data.setName(name);
        data.setNumber(number);
        return data;
    }


    /*@Bean
    public Data getData(Data data) {
        //Data data = new Data();
        //data.setName("bikbik");
        //data.setNumber(44);
        return data;
    }*/
}
