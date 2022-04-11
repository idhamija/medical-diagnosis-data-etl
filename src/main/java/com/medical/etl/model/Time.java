package com.medical.etl.model;

import java.time.LocalTime;

public class Time {

    private java.sql.Time time;
    private short timeId;
    private short hour;
    private short minute;

    public Time() {
    }

    public Time(java.sql.Time time) {
        LocalTime localTime = time.toLocalTime();

        this.hour = (short) (localTime.getHour());
        this.minute = (short) (localTime.getMinute());
        this.timeId = (short) (hour * 100 + minute);
    }

    public Time(java.sql.Time time, short timeId, short hour, short minute) {
        this.time = time;
        this.timeId = timeId;
        this.hour = hour;
        this.minute = minute;
    }

    public java.sql.Time getTime() {
        return time;
    }

    public void setTime(java.sql.Time time) {
        this.time = time;
    }

    public short getTimeId() {
        return timeId;
    }

    public void setTimeId(short timeId) {
        this.timeId = timeId;
    }

    public short getHour() {
        return hour;
    }

    public void setHour(short hour) {
        this.hour = hour;
    }

    public short getMinute() {
        return minute;
    }

    public void setMinute(short minute) {
        this.minute = minute;
    }

    @Override
    public String toString() {
        return "Time{" +
                "time=" + time +
                ", timeId=" + timeId +
                ", hour=" + hour +
                ", minute=" + minute +
                '}';
    }

}
