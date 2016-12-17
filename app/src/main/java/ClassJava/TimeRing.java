package classJava;

import java.sql.Time;
import java.util.Date;

/**
 * Created by hoa on 17/12/2016.
 */

public class TimeRing {
    private Date date;
    private Time time;
    private String note;
    private String name;

    public TimeRing(Date date, Time time, String note, String name) {
        this.date = date;
        this.time = time;
        this.note = note;
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
