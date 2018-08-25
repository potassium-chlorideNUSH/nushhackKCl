package com.kcl.nushhack.potassiumchloride;

import android.app.ProgressDialog;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.text.TextUtils;
import android.util.Log;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class login extends AppCompatActivity {

    public static user Current_user;
    private EditText idText;
    private EditText passwordtext;
    private AppCompatButton loginButton;

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
            public void onAuthStateChanged(@NonNull final FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()!=null){
                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference(main.USER_TABLE).child(firebaseAuth.getCurrentUser().getUid());
                    ref.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            Current_user = dataSnapshot.getValue(user.class);
                            startActivity(new Intent(login.this, main.class));
                            finish();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

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

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= 8;
    }

    private boolean validate_login_input(String email, String password){
        boolean error = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            passwordtext.setError(getString(R.string.error_invalid_password));
            focusView = passwordtext;
            error = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            idText.setError(getString(R.string.error_field_required));
            focusView = idText;
            error = true;
        } else if (!isEmailValid(email)) {
            idText.setError(getString(R.string.error_invalid_email));
            focusView = idText;
            error = true;
        }
        if(error) focusView.requestFocus();

        return !error;
    }
}
