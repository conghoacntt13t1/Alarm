package com.example.hoa.alarm;



import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import fragment.AddFragment;
import fragment.FragmentList;
import viewpager.AlarmPagerAdapter;

public class MainActivity extends AppCompatActivity {
    private AlarmPagerAdapter mAlarmPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPage();
    }
    private void initPage(){
        List<Fragment> lsFragment=new ArrayList<>();
        lsFragment.add(new AddFragment());
        lsFragment.add(new FragmentList());

        mAlarmPagerAdapter =new AlarmPagerAdapter(this.getSupportFragmentManager(),lsFragment);
        mViewPager=(ViewPager) findViewById(R.id.vpMain);
        mViewPager.setAdapter(mAlarmPagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_view,menu);
        return true;
    }


}
