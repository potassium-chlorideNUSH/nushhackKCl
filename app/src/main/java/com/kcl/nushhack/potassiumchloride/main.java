package com.kcl.nushhack.potassiumchloride;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;

import java.lang.reflect.Constructor;

public class main extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final String USER_TABLE = "users";
    public static final String STUDENT_TABLE = "students";
    public static final String TEACHER_TABLE = "teachers";
    public static final String TOKEN_TEACHER = "TEACHER";
    public static final String TOKEN_STUDENT = "STUDENT";

    private teacher Current_teacher;
    private student Current_student;

    ConstraintLayout cl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        cl = findViewById(R.id.fragment_layout);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        load_notif();

    }


    @Override
    protected void onStart(){
        super.onStart();
        NavigationView navigationView = findViewById(R.id.nav_view);

        View headerLayout = navigationView.getHeaderView(0);
        TextView header_name = headerLayout.findViewById(R.id.header_name);
        TextView header_email = headerLayout.findViewById(R.id.header_email);
        header_name.setText(login.Current_user.getName());
         header_email.setText(login.Current_user.getEmail());

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        if(login.Current_user.getType().equals(TOKEN_STUDENT)){
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference(main.STUDENT_TABLE).child(mAuth.getCurrentUser().getUid());
            ref.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    Current_student = dataSnapshot.getValue(student.class);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        if(login.Current_user.getType().equals(TOKEN_TEACHER)){
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference(main.TEACHER_TABLE).child(mAuth.getCurrentUser().getUid());
            ref.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    Current_teacher = dataSnapshot.getValue(teacher.class);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
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
        MenuItem mi = menu.findItem(R.id.signout);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.signout){
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(main.this, login.class));
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.announcements) {
           load_notif();
        } else if (id == R.id.timetable) {
            load_timetable();
        } else if (id == R.id.school_cal) {
            load_school_cal();
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    void load_notif(){
        setTitle("Announcements&Notifications");
        for (Fragment fragment:getSupportFragmentManager().getFragments()) {
            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
        }
        //Fragment newFragment = new notif_fragment();
        //getSupportFragmentManager().beginTransaction().add(dl.getId(),newFragment).commit();

    }
    void load_timetable(){
        setTitle("Your Timetable");for (Fragment fragment:getSupportFragmentManager().getFragments()) {
            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
        }
        //Fragment newFragment = new timetable_fragment();
        //getSupportFragmentManager().beginTransaction().add(dl.getId(),newFragment).commit();
    }
    void load_school_cal(){
        setTitle("School Calendar");for (Fragment fragment:getSupportFragmentManager().getFragments()) {
            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
        }
        //Fragment newFragment = new school_cal_fragment();
        //getSupportFragmentManager().beginTransaction().add(dl.getId(),newFragment).commit();
    }
}
