package AlarmDatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hoa.alarm.R;

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
        if (lsTime.isEmpty()) {
            return 0;
        }
        else {
            return lsTime.size();
        }
    }

    @Override
    public Object getItem(int position) {
        return lsTime.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
            convertView=layoutInflater.inflate(R.layout.item_listview,null);
            holder=new ViewHolder();
            holder.tvName=(TextView) convertView.findViewById(R.id.tvName);
            holder.tvTime=(TextView) convertView.findViewById(R.id.tvTime);
            convertView.setTag(holder);
        }
        else {
            holder=(ViewHolder) convertView.getTag();
        }

        TimeRing timeRing=this.lsTime.get(position);
        holder.tvTime.setText(timeRing.getTime().toString());
        holder.tvName.setText(timeRing.getName());
        return convertView;
    }

    static class ViewHolder{
        TextView tvName;
        TextView tvTime;
    }
}
