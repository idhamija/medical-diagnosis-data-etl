package com.medical.etl.processor;

import com.medical.etl.model.Patient;
import org.springframework.batch.item.ItemProcessor;

public class PatientProcessor implements ItemProcessor<Patient, Patient> {

    @Override
    public Patient process(Patient patient) {
        final String gender = patient.getGender().toLowerCase();
        final String district = patient.getDistrict().toLowerCase();
        final String city = patient.getCity().toLowerCase();
        final String state = patient.getState().toLowerCase();

        return new Patient(patient.getId(), gender, patient.getWeight(), patient.getHeight(), state, city, district);
    }

}
