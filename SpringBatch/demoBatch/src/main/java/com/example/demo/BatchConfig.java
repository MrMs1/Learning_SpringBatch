package com.example.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class BatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private DemoTasklet demoTasklet;

    @Autowired
    private DemoTasklet2 demoTasklet2;

    @Bean
    public Job demoJob(Step demoStep, Step demoStep2) {
        return jobBuilderFactory.get("demoJob") //Job名を指定
                .start(demoStep) //実行するStepを指定
                .next(demoStep2)
                .build();
    }

    @Bean
    public Step demoStep() {
        return stepBuilderFactory.get("demoStep") //Step名を指定
                .tasklet(demoTasklet) //実行するTaskletを指定
                .build();
    }

    @Bean
    public Step demoStep2() {
        return stepBuilderFactory.get("demoStep2") //Step名を指定
                .tasklet(demoTasklet2) //実行するTaskletを指定
                .build();
    }

    //    @Bean
    //    public RedisScript<Boolean> script() {
    //
    //        String scriptSource = "";
    //        return RedisScript.of(scriptSource, Boolean.class);
    //    }
}
