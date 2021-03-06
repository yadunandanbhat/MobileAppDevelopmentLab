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

    // This is the regex for password validation.
    String regex="^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!])[A-Za-z\\d@$!]{8,}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // This finds the fields.
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        signup = findViewById(R.id.signup);

        // OnClick event listener for signing up.
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = username.getText().toString();
                String passWord = password.getText().toString();

                if (validatePassword(passWord)) {
                    //Bundle is used to share information between two activities.
                    Bundle bundle = new Bundle();

                    //Here we are assigning a key for each value. "username" is the key for userName. Same for password.
                    bundle.putString("username", userName);
                    bundle.putString("password", passWord);

                    //Intent is used to pass the bundle to the other activity.
                    Intent intent =  new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else {
                    //This displays a toast for ivalid password.
                    Toast.makeText(MainActivity.this, "Invalid password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean validatePassword(String pwd){
        //This is used to create a pattern for the given regex and match that to the input.
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(pwd);

        return matcher.matches();
    }
}