package com.kcl.nushhack.potassiumchloride;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Kerk Tai Heng on 25/8/2018.
 */

public class splashactivity extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Intent intent = new Intent(this, login.class);

        new CountDownTimer(800, 400) {

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                startActivity(intent);
                finish();
            }
        }.start();


    }

}
