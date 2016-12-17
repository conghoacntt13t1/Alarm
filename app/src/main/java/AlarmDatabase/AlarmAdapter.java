package AlarmDatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import classJava.TimeRing;

/**
 * Created by hoa on 17/12/2016.
 */

public class AlarmAdapter extends BaseAdapter {

    private List<TimeRing> lsTime;
    private Context mContext;
    private LayoutInflater layoutInflater;

    public AlarmAdapter(List<TimeRing> lsTime, Context mContext) {
        this.lsTime = lsTime;
        this.mContext = mContext;
        layoutInflater=LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
