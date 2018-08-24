package com.kcl.nushhack.potassiumchloride;

import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.kcl.nushhack.potassiumchloride.fragments.school_cal_fragment;

import java.lang.reflect.Constructor;

public class main extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,school_cal_fragment.OnFragmentInteractionListener {

    ConstraintLayout cl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        cl=findViewById(R.id.fragment_layout);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        load_school_cal();
    }
    @Override
    public void onFragmentInteraction(Uri x) {
//do something here, maybe switch to another fragment
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.announcements) {
            //load respective fragment
        } else if (id == R.id.timetable) {
            load_timetable();
        } else if (id == R.id.school_cal) {
            load_school_cal();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    void load_notif(){
        setTitle("Announcements&Notifications");
        for (Fragment fragment:getSupportFragmentManager().getFragments()) {
            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
        }
        //Fragment newFragment = new notif_fragment();
        //getSupportFragmentManager().beginTransaction().add(cl.getId(),newFragment).commit();

    }
    void load_timetable(){
        setTitle("Your Timetable");for (Fragment fragment:getSupportFragmentManager().getFragments()) {
            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
        }
        //Fragment newFragment = new timetable_fragment();
        //getSupportFragmentManager().beginTransaction().add(cl.getId(),newFragment).commit();
    }
    void load_school_cal(){
        setTitle("School Calendar");for (Fragment fragment:getSupportFragmentManager().getFragments()) {
            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
        }
        Fragment newFragment = new school_cal_fragment();
        getSupportFragmentManager().beginTransaction().add(cl.getId(),newFragment).commit();
    }
}
