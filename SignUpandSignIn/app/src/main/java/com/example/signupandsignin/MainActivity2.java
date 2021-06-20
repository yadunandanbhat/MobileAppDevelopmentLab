package com.example.signupandsignin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    //Many of these are same as the first activity.
    EditText username, password;
    Button signin;

    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        username = findViewById(R.id.username2);
        password = findViewById(R.id.password2);
        signin = findViewById(R.id.signin);

        //This is used to get the bundle from the first activity.
        Bundle bundle = getIntent().getExtras();
        String userName = bundle.getString("username");
        String passWord = bundle.getString("password");

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = username.getText().toString();
                String pword = password.getText().toString();

                if (uname.equals(userName) && pword.equals(passWord)) {
                    //This displays a toast if it logs in successfully.
                    Toast.makeText(MainActivity2.this, "Success", Toast.LENGTH_SHORT).show();
                }
                else {
                    //This is a counter to check the number of attempts.
                    count++;
                    if (count>=3) {
                        //If more than 3 attempts, then the sign in button gets disabled.
                        signin.setEnabled(false);
                        Toast.makeText(MainActivity2.this, "Tries exceeded more than 3!\nSign in disabled!", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(MainActivity2.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}