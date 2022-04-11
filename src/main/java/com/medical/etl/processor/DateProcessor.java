package com.medical.etl.processor;

import com.medical.etl.model.Date;
import org.springframework.batch.item.ItemProcessor;

public class DateProcessor implements ItemProcessor<Date, Date> {

    @Override
    public Date process(Date date) {
        return new Date(date.getDateId());
    }

}
