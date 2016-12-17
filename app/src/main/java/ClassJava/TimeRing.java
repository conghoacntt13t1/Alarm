package classJava;

import android.os.Parcel;
import android.os.Parcelable;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hoa on 17/12/2016.
 */

public class TimeRing implements Parcelable {
    private int id;
    private Date date;
    private Time time;
    private String note;
    private String name;

    public TimeRing(){

    }

    public TimeRing(Date date, Time time, String note, String name) {
        this.date = date;
        this.time = time;
        this.note = note;
        this.name = name;
    }

    protected TimeRing(Parcel in)  {
        SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = format.parse(in.readString());
        } catch (ParseException e) {
            try {
                date = format.parse("01/01/2000");
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        time = Time.valueOf(in.readString());
        note = in.readString();
        name = in.readString();

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
        dest.writeString(format.format(date));
        dest.writeString(time.toString());
        dest.writeString(note);
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TimeRing> CREATOR = new Creator<TimeRing>() {
        @Override
        public TimeRing createFromParcel(Parcel in) {
            return new TimeRing(in);
        }

        @Override
        public TimeRing[] newArray(int size) {
            return new TimeRing[size];
        }
    };

    public int getId() {
        return id;
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
