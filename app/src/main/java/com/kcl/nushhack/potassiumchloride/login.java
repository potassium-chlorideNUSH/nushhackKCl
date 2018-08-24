package com.kcl.nushhack.potassiumchloride;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    EditText idText;
    EditText passwordtext;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        idText = findViewById(R.id.input_id);
        passwordtext = findViewById(R.id.input_password);
        loginButton = findViewById(R.id.btn_login);
    }

    public void login(View view) {
        loginButton.setEnabled(false);
        if (!check()) {
            loginFail();
            return;
        }
        final ProgressDialog progressDialog = new ProgressDialog(login.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Logging in...");
        progressDialog.show();
        String id = idText.getText().toString();
        String password = passwordtext.getText().toString();
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        progressDialog.dismiss();
                        loginPass();
                    }
                }, 1000);
    }
    void loginFail(){
        Toast t=Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG);
        t.show();
        loginButton.setEnabled(true);
    }
    void loginPass(){
        //go main
        Intent intent=new Intent(this,main.class);
        intent.putExtra("name",idText.getText().toString());
        loginButton.setEnabled(true);
    }
    public boolean check() {
        boolean valid = true;
        //check on firebase
        return valid;
    }
}
