package me.student2026.model;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class TimezoneResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "timezone_seq")
    @SequenceGenerator(name = "timezone_seq", sequenceName = "timezone_seq", allocationSize = 1)
    private Long id;

    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int seconds;
    private int milliSeconds;
    private String dateTime;
    private String date;
    private String time;
    private String timeZone;
    private String dayOfWeek;
    private boolean dstActive;

    public TimezoneResponse(int year, int month, int day, int hour, int minute, int seconds, int milliSeconds, String dateTime, String date, String time, String dayOfWeek, String timeZone, boolean dstActive) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.seconds = seconds;
        this.milliSeconds = milliSeconds;
        this.dateTime = dateTime;
        this.date = date;
        this.time = time;
        this.dayOfWeek = dayOfWeek;
        this.timeZone = timeZone;
        this.dstActive = dstActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getMilliSeconds() {
        return milliSeconds;
    }

    public void setMilliSeconds(int milliSeconds) {
        this.milliSeconds = milliSeconds;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public boolean isDstActive() {
        return dstActive;
    }

    public void setDstActive(boolean dstActive) {
        this.dstActive = dstActive;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TimezoneResponse timeZone1 = (TimezoneResponse) o;
        return year == timeZone1.year && month == timeZone1.month && day == timeZone1.day && hour == timeZone1.hour && minute == timeZone1.minute && seconds == timeZone1.seconds && milliSeconds == timeZone1.milliSeconds && dstActive == timeZone1.dstActive && Objects.equals(id, timeZone1.id) && Objects.equals(dateTime, timeZone1.dateTime) && Objects.equals(date, timeZone1.date) && Objects.equals(time, timeZone1.time) && Objects.equals(timeZone, timeZone1.timeZone) && Objects.equals(dayOfWeek, timeZone1.dayOfWeek);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year, month, day, hour, minute, seconds, milliSeconds, dateTime, date, time, timeZone, dayOfWeek, dstActive);
    }

    @Override
    public String toString() {
        return "TimeZone{" +
                "id=" + id +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", hour=" + hour +
                ", minute=" + minute +
                ", seconds=" + seconds +
                ", milliSeconds=" + milliSeconds +
                ", dateTime='" + dateTime + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", timeZone='" + timeZone + '\'' +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                ", dstActive=" + dstActive +
                '}';
    }
}
