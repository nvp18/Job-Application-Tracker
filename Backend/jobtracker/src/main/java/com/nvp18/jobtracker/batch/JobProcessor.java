package com.nvp18.jobtracker.batch;

import org.springframework.batch.infrastructure.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class JobProcessor implements ItemProcessor {


    @Override
    public Object process(Object item) throws Exception {
        System.out.println("cvame to ItemProcessor" );
        return "";
    }


}
