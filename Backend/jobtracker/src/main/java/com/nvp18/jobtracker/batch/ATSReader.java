package com.nvp18.jobtracker.batch;

import org.springframework.batch.infrastructure.item.ItemReader;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class ATSReader implements ItemReader {

    private Iterator<String> iterator;

    // Constructor - initialize data once
    public ATSReader() {
        List<String> ats = new ArrayList<>();
        ats.add("1");
        ats.add("2");
        this.iterator = ats.iterator();
    }

    @Override
    public Object read() throws Exception {
        System.out.println("came to ATS Reader");
        if(iterator.hasNext()) {
            return iterator.next();
        }
        return  null;
    }
}
