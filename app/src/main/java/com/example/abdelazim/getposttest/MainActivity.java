package com.example.abdelazim.getposttest;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference cityReference = firebaseDatabase.getReference().child("city");

        DatabaseReference sohagRef = cityReference.child("sohag");

        sohagRef.child("suggestions").push().setValue("sohag street");
        sohagRef.child("suggestions").push().setValue("15 st");

        sohagRef.child("suggestions").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String suggestion = dataSnapshot.getValue(String.class);
                Log.i("QQQQ", "onDataChange: suggestion: " + suggestion);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String suggestion = dataSnapshot.getValue(String.class);
                Log.i("QQQQ", "onDataChange: suggestion: " + suggestion);
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        // save city name into firebase database

        // save suggestions under the city name
    }
}
