package com.example.c_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText UserID;
    private EditText Password;
    private Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        UserID = (EditText) findViewById(R.id.editTextUserid);
        Password = (EditText) findViewById(R.id.editTextpassword);
        Login = (Button) findViewById(R.id.buttonlogin);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(UserID.getText().toString(),Password.getText().toString());
            }
        });
    }

    private void validate(String userName, String userPassword){
        if((userName.equals("Admin") ) && (userPassword.equals("123456"))){

            Intent intent = new Intent(LoginActivity.this , HomeActivity.class);
            startActivity(intent);
        }

    }
}
