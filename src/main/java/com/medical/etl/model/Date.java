package com.medical.etl.model;

import java.time.LocalDate;

public class Date {

    private java.sql.Date dateId;
    private short year;
    private short month;
    private short day;

    public Date() {
    }

    public Date(java.sql.Date date) {
        final LocalDate localDate = date.toLocalDate();

        this.dateId = date;
        this.year = (short) localDate.getYear();
        this.month = (short) localDate.getMonthValue();
        this.day = (short) localDate.getDayOfMonth();
    }

    public Date(java.sql.Date dateId, short year, short month, short day) {
        this.dateId = dateId;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public java.sql.Date getDateId() {
        return dateId;
    }

    public void setDateId(java.sql.Date dateId) {
        this.dateId = dateId;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public short getMonth() {
        return month;
    }

    public void setMonth(short month) {
        this.month = month;
    }

    public short getDay() {
        return day;
    }

    public void setDay(short day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "DateTarget{" +
                "dateId=" + dateId +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

}
