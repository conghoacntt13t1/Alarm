package AlarmDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import classJava.TimeRing;

/**
 * Created by hoa on 17/12/2016.
 */

public class TimeDatabase {
    public static final String DATABASE_NAME="DB_TIME_ALARM";
    public static final String TABLE_ACCOUNT="TIME_TABLE";
    public static final int VERSION=1;
    public static final String COLUMN_ID="._id";
    public static final String COLUMN_NAME="Name";
    public static final String COLUMN_DATE="Date";
    public static final String COLUMN_TIME="Time";
    public static final String COLUMN_NOTE="Note";


    private static Context context;
    static SQLiteDatabase db;
    private OpenHelper openHelper;

    public TimeDatabase(Context context) {
        this.context=context;
    }

    public TimeDatabase open() throws SQLException{
        openHelper =new OpenHelper(context);
        db=openHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        openHelper.close();
    }

    public long addData(String name, String date, String time, String note){
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_NAME,name);
        cv.put(COLUMN_DATE,date);
        cv.put(COLUMN_TIME,time);
        cv.put(COLUMN_NOTE,note);
        return db.insert(TABLE_ACCOUNT,null,cv);
    }

    public List<TimeRing> getData() throws ParseException {
        List<TimeRing> list=new ArrayList<>();
        String[] columns={COLUMN_ID,COLUMN_NAME,COLUMN_DATE,COLUMN_TIME,COLUMN_NOTE};
        Cursor c=db.query(TABLE_ACCOUNT,columns,null,null,null,null,null);
        int iName=c.getColumnIndex(COLUMN_NAME);
        int iDate=c.getColumnIndex(COLUMN_DATE);
        int iTime=c.getColumnIndex(COLUMN_TIME);
        int iNote=c.getColumnIndex(COLUMN_NOTE);

        for (c.moveToFirst();c.isAfterLast();c.moveToNext()){
            TimeRing timeRing=new TimeRing();
            timeRing.setName(c.getString(iName));
            SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
            timeRing.setDate(format.parse(c.getString(iDate)));
            timeRing.setTime(Time.valueOf(c.getString(iTime)));
            timeRing.setNote(c.getString(iNote));
            list.add(timeRing);
        }
        return list;
    }
    public int update(TimeRing timeRing){
        ContentValues cv=new ContentValues();
        String[] columns={COLUMN_ID,COLUMN_NAME,COLUMN_DATE,COLUMN_TIME,COLUMN_NOTE};
        SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
        cv.put(COLUMN_NAME,timeRing.getName());
        cv.put(COLUMN_DATE,format.format(timeRing.getDate()));
        cv.put(COLUMN_TIME,timeRing.getTime().toString());
        cv.put(COLUMN_NOTE,timeRing.getName());
        return db.update(TABLE_ACCOUNT,cv,COLUMN_ID+" = "+timeRing.getId(),columns);
    }

    static class OpenHelper extends SQLiteOpenHelper{

        public OpenHelper(Context context) {
            super(context, DATABASE_NAME, null, VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(" CREATE TABLE "+TABLE_ACCOUNT +" ("
                    + COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COLUMN_NAME +" TEXT MOT NULL, "
                    + COLUMN_DATE +" TEXT NOT NULL, "
                    + COLUMN_TIME +" TEXT NOT NULL, "
                    + COLUMN_NOTE +"TEXT);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+ TABLE_ACCOUNT);
            onCreate(db);
        }
    }
}
