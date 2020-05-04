package com.example.c_19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StateActivity extends AppCompatActivity {

    TextView ts,offr,jco,or,civ;
    Button Show;
    DatabaseReference databasePatients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state);


        ts = (TextView) findViewById(R.id.textViewts);
        offr = (TextView) findViewById(R.id.textViewofficer);
        jco = (TextView) findViewById(R.id.textViewjco);
        or = (TextView) findViewById(R.id.textViewor);
        civ = (TextView) findViewById(R.id.textViewciv);
        Show = (Button) findViewById(R.id.buttonShow);

        databasePatients = FirebaseDatabase.getInstance().getReference("State");

        Show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                databasePatients.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String Total = dataSnapshot.child("Total").getValue().toString();
                        String Offr = dataSnapshot.child("Offr").getValue().toString();
                        String Jco = dataSnapshot.child("JCO").getValue().toString();
                        String OR = dataSnapshot.child("OR").getValue().toString();
                        String Civ = dataSnapshot.child("Civ").getValue().toString();

                        ts.setText(Total);
                        offr.setText(Offr);
                        jco.setText(Jco);
                        or.setText(OR);
                        civ.setText(Civ);


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
