package com.medical.etl.model;

import java.sql.Date;
import java.sql.Timestamp;

public class TestReportSource {

    private int id;
    private int testTypeId;
    private int patientId;
    private int doctorId;
    private int prescriptionId;
    private int labId;
    private Date patientDob;
    private short patientAge;
    private String testName;
    private double testValue;
    private Timestamp testTimestamp;

    public TestReportSource() {
    }

    public TestReportSource(int id, int testTypeId, int patientId, int doctorId, int prescriptionId, int labId, Date patientDob, short patientAge, String testName, double testValue, Timestamp testTimestamp) {
        this.id = id;
        this.testTypeId = testTypeId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.prescriptionId = prescriptionId;
        this.labId = labId;
        this.patientDob = patientDob;
        this.patientAge = patientAge;
        this.testName = testName;
        this.testValue = testValue;
        this.testTimestamp = testTimestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTestTypeId() {
        return testTypeId;
    }

    public void setTestTypeId(int testTypeId) {
        this.testTypeId = testTypeId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public int getLabId() {
        return labId;
    }

    public void setLabId(int labId) {
        this.labId = labId;
    }

    public Date getPatientDob() {
        return patientDob;
    }

    public void setPatientDob(Date patientDob) {
        this.patientDob = patientDob;
    }

    public short getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(short patientAge) {
        this.patientAge = patientAge;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public double getTestValue() {
        return testValue;
    }

    public void setTestValue(double testValue) {
        this.testValue = testValue;
    }

    public Timestamp getTestTimestamp() {
        return testTimestamp;
    }

    public void setTestTimestamp(Timestamp testTimestamp) {
        this.testTimestamp = testTimestamp;
    }

    @Override
    public String toString() {
        return "TestReportSource{" +
                "id=" + id +
                ", testTypeId=" + testTypeId +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", prescriptionId=" + prescriptionId +
                ", labId=" + labId +
                ", patientDob=" + patientDob +
                ", patientAge=" + patientAge +
                ", testName='" + testName + '\'' +
                ", testValue=" + testValue +
                ", testTimestamp=" + testTimestamp +
                '}';
    }

}
