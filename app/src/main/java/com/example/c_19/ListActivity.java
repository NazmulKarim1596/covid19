package com.example.c_19;

import android.os.Bundle;
import android.widget.ListView;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;


public class ListActivity extends AppCompatActivity {

    ListView listViewPatients;



    public DatabaseReference databasePatients;
    public List<Patients> patientsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);



        listViewPatients =  findViewById(R.id.listViewPatients);
        patientsList = new ArrayList<>();
        final PatientsList adapter = new PatientsList(ListActivity.this,patientsList);
        databasePatients = FirebaseDatabase.getInstance().getReference("Patients");
        listViewPatients.setAdapter(adapter);








        databasePatients.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    patientsList.clear();

                    for(DataSnapshot patientSnapshot : dataSnapshot.getChildren()){

                        Patients patients = patientSnapshot.getValue(Patients.class);

                        patientsList.add(patients);
                    }


                    listViewPatients.setAdapter(adapter);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });


        }

    }







