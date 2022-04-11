package com.medical.etl.processor;

import com.medical.etl.model.Doctor;
import org.springframework.batch.item.ItemProcessor;

public class DoctorProcessor implements ItemProcessor<Doctor, Doctor> {

    @Override
    public Doctor process(Doctor doctor) {
        final String name = doctor.getName().toLowerCase();
        final String department = doctor.getDepartment().toLowerCase();
        final String hospital = doctor.getHospital().toLowerCase();
        final String district = doctor.getDistrict().toLowerCase();
        final String city = doctor.getCity().toLowerCase();
        final String state = doctor.getState().toLowerCase();

        return new Doctor(doctor.getId(), name, department, hospital, doctor.getPincode(), district, city, state);
    }

}
