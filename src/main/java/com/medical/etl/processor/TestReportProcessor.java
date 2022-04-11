package com.medical.etl.processor;

import com.medical.etl.model.TestReportSource;
import com.medical.etl.model.TestReportTarget;
import org.springframework.batch.item.ItemProcessor;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

public class TestReportProcessor implements ItemProcessor<TestReportSource, TestReportTarget> {

    @Override
    public TestReportTarget process(TestReportSource testReportSource) {
        final LocalDate testDate = testReportSource.getTestTimestamp().toLocalDateTime().toLocalDate();
        final LocalTime testTime = testReportSource.getTestTimestamp().toLocalDateTime().toLocalTime();

        final Date dateId = Date.valueOf(testDate);
        final short timeId = (short) (testTime.getHour() * 100 + testTime.getMinute());
        final short patientAge = (short) getAge(testDate, testReportSource.getPatientDob());
        final double testValue = testReportSource.getTestValue();
        final String severity = getSeverity(testReportSource.getTestName(), testValue);

        return new TestReportTarget(testReportSource.getId(), testReportSource.getTestTypeId(), testReportSource.getPatientId(), testReportSource.getDoctorId(), testReportSource.getPrescriptionId(), testReportSource.getLabId(), dateId, timeId, patientAge, testValue, severity, testReportSource.getTestTimestamp());
    }

    private int getAge(LocalDate testDate, Date patientDob) {
        final LocalDate dob = patientDob.toLocalDate();
        int age = testDate.getYear() - dob.getYear();
        if (testDate.getMonthValue() < dob.getMonthValue()) {
            return age - 1;
        } else if (testDate.getMonthValue() == dob.getMonthValue() && testDate.getDayOfMonth() < dob.getDayOfMonth()) {
            return age - 1;
        }
        return age;
    }

    private String getSeverity(String testName, double testValue) {
        if (testName.equalsIgnoreCase("diabetes")) {
            return getDiabetesSeverity(testValue);
        } else if (testName.equalsIgnoreCase("blood pressure systolic")) {
            return getBpSystolicSeverity(testValue);
        } else if (testName.equalsIgnoreCase("blood pressure diastolic")) {
            return getBpDiastolicSeverity(testValue);
        }
        return "";
    }

    public String getDiabetesSeverity(double testValue) {
        if (testValue >= 6.5d) {
            return "diabetes";
        } else if (testValue >= 5.7d) {
            return "prediabetes";
        } else if (testValue >= 0) {
            return "normal";
        }
        return "wrong analysis";
    }

    public String getBpSystolicSeverity(double testValue) {
        if (testValue > 180d) {
            return "hypertensive crisis";
        } else if (testValue >= 140d) {
            return "hypertension stage 2";
        } else if (testValue >= 130d) {
            return "hypertension stage 1";
        } else if (testValue >= 120d) {
            return "elevated";
        } else if (testValue >= 90d) {
            return "normal";
        } else if (testValue > 0) {
            return "hypotension";
        }
        return "wrong analysis";
    }

    public String getBpDiastolicSeverity(double testValue) {
        if (testValue > 120d) {
            return "hypertensive crisis";
        } else if (testValue >= 90d) {
            return "hypertension stage 2";
        } else if (testValue >= 80d) {
            return "hypertension stage 1";
        } else if (testValue >= 60d) {
            return "normal";
        } else if (testValue > 0) {
            return "hypotension";
        }
        return "wrong analysis";
    }

}
