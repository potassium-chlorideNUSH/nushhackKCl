package com.kcl.nushhack.potassiumchloride;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class login extends AppCompatActivity {

    private EditText idText;
    private EditText passwordtext;
    private Button loginButton;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        idText = findViewById(R.id.input_id);
        passwordtext = findViewById(R.id.input_password);
        loginButton = findViewById(R.id.btn_login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLogin();
            }
        });

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()!=null){
                    startActivity(new Intent(login.this, main.class));
                }
            }
        };
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
        //updateUI(currentUser);
    }

    private void startLogin(){
        String email = idText.getText().toString();
        String password = passwordtext.getText().toString();
        if(validate_login_input(email, password)) {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        Toast.makeText(login.this, "Sign in failed", Toast.LENGTH_LONG).show();
                    }
                }
            });
        } else {
            Toast.makeText(login.this, "Sign in failed", Toast.LENGTH_LONG).show();
        }


    }

    private boolean validate_login_input(String email, String password){
        return true;
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
