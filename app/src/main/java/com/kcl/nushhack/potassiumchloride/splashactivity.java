package com.kcl.nushhack.potassiumchloride;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Kerk Tai Heng on 25/8/2018.
 */

public class splashactivity extends AppCompatActivity{

    private FirebaseAuth mAuth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mAuth = FirebaseAuth.getInstance();

        mAuth.signOut();

        if(mAuth.getCurrentUser()==null){
            startActivity(new Intent(this, login.class));
            finish();
        } else if(mAuth.getCurrentUser()!=null){
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference(main.USER_TABLE).child(mAuth.getCurrentUser().getUid());
            ref.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    login.Current_user = dataSnapshot.getValue(user.class);
                    startActivity(new Intent(splashactivity.this, main.class));
                    finish();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }

        /*
        new CountDownTimer(800, 400) {

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                startActivity(new Intent(splashactivity.this, login.class));
                finish();
            }
        }.start();
        */




    }

}
