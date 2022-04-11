package com.medical.etl.processor;

import com.medical.etl.model.Lab;
import org.springframework.batch.item.ItemProcessor;

public class LabProcessor implements ItemProcessor<Lab, Lab> {

    @Override
    public Lab process(Lab lab) {
        final String name = lab.getName().toLowerCase();
        final String district = lab.getDistrict().toLowerCase();
        final String city = lab.getCity().toLowerCase();
        final String state = lab.getState().toLowerCase();

        return new Lab(lab.getId(), name, lab.getPincode(), district, city, state);
    }

}