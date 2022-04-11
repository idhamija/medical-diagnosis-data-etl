package com.medical.etl.processor;

import com.medical.etl.model.Prescription;
import org.springframework.batch.item.ItemProcessor;

public class PrescriptionProcessor implements ItemProcessor<Prescription, Prescription> {

    @Override
    public Prescription process(Prescription prescription) {
        final String diagnosis = prescription.getDiagnosis().toLowerCase();
        final String treatment = prescription.getTreatment().toLowerCase();

        return new Prescription(prescription.getId(), prescription.getDoctorId(), prescription.getDate(), diagnosis, treatment);
    }

}
