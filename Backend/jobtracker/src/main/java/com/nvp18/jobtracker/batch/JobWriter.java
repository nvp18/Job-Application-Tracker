package com.nvp18.jobtracker.batch;

import org.springframework.batch.infrastructure.item.Chunk;
import org.springframework.batch.infrastructure.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
public class JobWriter implements ItemWriter {
    @Override
    public void write(Chunk chunk) throws Exception {
        System.out.println("came to job writer");
    }
}
