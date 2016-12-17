package fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.hoa.alarm.R;

/**
 * Created by hoa on 17/12/2016.
 */

public class FragmentList extends Fragment {

    private ListView lvList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.list_fragment,null);
        lvList=(ListView) view.findViewById(R.id.lvTime);
        return view;
    }
}
