package com.example.c_19;



import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class AddActivity extends AppCompatActivity {

    EditText editTextname, editTextrank, editTextunit, editTextstart, editTextend;
    Button buttonsave;

    DatabaseReference databasePatients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        databasePatients = FirebaseDatabase.getInstance().getReference("Patients");

        editTextname =  findViewById(R.id.editTextname);
        editTextrank =  findViewById(R.id.editTextrank);
        editTextunit =  findViewById(R.id.editTextunit);
        editTextstart =  findViewById(R.id.editTextstart);
        editTextend =  findViewById(R.id.editTextend);

        buttonsave =  findViewById(R.id.buttonsave);

        buttonsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPatient();

            }
        });
    }

    private void addPatient(){

        String name = editTextname.getText().toString().trim();
        String rank = editTextrank.getText().toString().trim();
        String unit = editTextunit.getText().toString().trim();
        String start = editTextstart.getText().toString().trim();
        String end = editTextend.getText().toString().trim();


        if(!TextUtils.isEmpty(name)){

            String id = databasePatients.push().getKey();
            Patients patients = new Patients(id, name, rank, unit, start, end);

            assert id != null;
            databasePatients.child(id).setValue(patients);  //11.16

            Toast.makeText(this, "Patient Added", Toast.LENGTH_SHORT).show();
        }else{

            Toast.makeText(this, "Enter a Name",Toast.LENGTH_SHORT).show();
        }



    }

}
