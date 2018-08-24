package com.kcl.nushhack.potassiumchloride;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class main extends AppCompatActivity {
    user user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String name=getIntent().getStringExtra("name");
        //user=find by name in database like user=new student(blabla);
    }
}
