package viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by hoa on 17/12/2016.
 */

public class AlarmPagerAdapter extends FragmentPagerAdapter {


    List<Fragment> Fragments;
    public AlarmPagerAdapter(FragmentManager fm, List<Fragment> Fragment) {
        super(fm);
        this.Fragments=Fragment;
    }

    @Override
    public Fragment getItem(int position) {
        return this.Fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.Fragments.size();
    }
}
