package com.medical.etl.model;

import java.sql.Date;
import java.sql.Timestamp;

public class TestReportTarget {

    private int id;
    private int testTypeId;
    private int patientId;
    private int doctorId;
    private int prescriptionId;
    private int labId;
    private Date date;
    private short timeId;
    private short patientAge;
    private double testValue;
    private String severity;
    private Timestamp testTimestamp;

    public TestReportTarget() {
    }

    public TestReportTarget(int id, int testTypeId, int patientId, int doctorId, int prescriptionId, int labId, Date date, short timeId, short patientAge, double testValue, String severity, Timestamp testTimestamp) {
        this.id = id;
        this.testTypeId = testTypeId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.prescriptionId = prescriptionId;
        this.labId = labId;
        this.date = date;
        this.timeId = timeId;
        this.patientAge = patientAge;
        this.testValue = testValue;
        this.severity = severity;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public short getTimeId() {
        return timeId;
    }

    public void setTimeId(short timeId) {
        this.timeId = timeId;
    }

    public short getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(short patientAge) {
        this.patientAge = patientAge;
    }

    public double getTestValue() {
        return testValue;
    }

    public void setTestValue(double testValue) {
        this.testValue = testValue;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public Timestamp getTestTimestamp() {
        return testTimestamp;
    }

    public void setTestTimestamp(Timestamp testTimestamp) {
        this.testTimestamp = testTimestamp;
    }

    @Override
    public String toString() {
        return "TestReportTarget{" +
                "id=" + id +
                ", testTypeId=" + testTypeId +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", prescriptionId=" + prescriptionId +
                ", labId=" + labId +
                ", date=" + date +
                ", timeId=" + timeId +
                ", patientAge=" + patientAge +
                ", testValue=" + testValue +
                ", severity='" + severity + '\'' +
                ", testTimestamp=" + testTimestamp +
                '}';
    }

}
