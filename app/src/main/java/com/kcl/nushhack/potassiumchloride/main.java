package com.kcl.nushhack.potassiumchloride;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class main extends AppCompatActivity {

    Button testButton;
    user user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String name=getIntent().getStringExtra("name");
        //user=find by name in database like user=new student(blabla);
        testButton = this.findViewById(R.id.testButton2);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
            }
        });
    }

}
