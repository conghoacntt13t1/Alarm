package com.example.hoa.alarm;

import android.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;

import java.util.ArrayList;
import java.util.List;

import fragment.AddFragment;
import fragment.FragmentList;
import viewpager.AlarmPagerAdapter;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private AlarmPagerAdapter alarmPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    private void initPage(){
        List<Fragment> lsFragment=new ArrayList<>();
        lsFragment.add(new AddFragment());
        lsFragment.add(new FragmentList());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_view,menu);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        return true;
    }
}
