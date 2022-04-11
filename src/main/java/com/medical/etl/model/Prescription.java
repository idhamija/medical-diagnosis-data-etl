package com.medical.etl.model;

import java.sql.Date;

public class Prescription {

    private int id;
    private int doctorId;
    private Date date;
    private String diagnosis;
    private String treatment;

    public Prescription() {
    }

    public Prescription(int id, int doctorId, Date date, String diagnosis, String treatment) {
        this.id = id;
        this.doctorId = doctorId;
        this.date = date;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "id=" + id +
                ", doctorId=" + doctorId +
                ", date=" + date +
                ", diagnosis='" + diagnosis + '\'' +
                ", treatment='" + treatment + '\'' +
                '}';
    }

}
