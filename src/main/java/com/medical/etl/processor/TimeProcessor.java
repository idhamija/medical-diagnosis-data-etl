package com.medical.etl.processor;

import com.medical.etl.model.Time;
import org.springframework.batch.item.ItemProcessor;

public class TimeProcessor implements ItemProcessor<Time, Time> {

    @Override
    public Time process(Time time) {
        return new Time(time.getTime());
    }

}
