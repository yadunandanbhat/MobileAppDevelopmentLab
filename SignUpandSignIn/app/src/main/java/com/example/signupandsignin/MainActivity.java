package com.example.signupandsignin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    Button signup;

    String regex="^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!])[A-Za-z\\d@$!]{8,}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        signup = findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = username.getText().toString();
                String passWord = password.getText().toString();

                if (validatePassword(passWord)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("username", userName);
                    bundle.putString("password", passWord);

                    Intent intent =  new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this, "Invalid password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean validatePassword(String pwd){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(pwd);

        return matcher.matches();


    }
}