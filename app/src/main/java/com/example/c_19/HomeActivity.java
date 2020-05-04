package com.example.c_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private Button button;
    private Button button1;
    private Button buttonState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddActivity();
            }
        });

        buttonState = (Button) findViewById(R.id.buttonstate);
        buttonState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openStateActivity();
            }
        });


        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openListActivity();
            }
        });
    }

    public void openListActivity() {

        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);


    }

    public void openStateActivity() {

        Intent intent = new Intent(this, StateActivity.class);
        startActivity(intent);


    }

    public void openAddActivity() {

        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }
}