package com.kcl.nushhack.potassiumchloride;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class firebase_handler {

    private static final DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();

    private DatabaseReference mConditionRef = mRootRef.child("condition");
    public DatabaseReference getmConditionRef() {
        return mConditionRef;
    }


}
