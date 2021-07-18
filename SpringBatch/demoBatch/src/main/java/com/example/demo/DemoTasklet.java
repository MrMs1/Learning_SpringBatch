package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
@StepScope
public class DemoTasklet implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        System.out.println("Hello World");

        Map<String, String> envMap = new HashMap<String, String>(1);

        for (Map.Entry<String, String> entry : envMap.entrySet()) {
            System.out.println("containskey result:" + entry.getKey().contains(""));
        }

        return RepeatStatus.FINISHED;
    }
}