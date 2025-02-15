package com.example.app3s2;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {
    TextView welcomeText;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        username = getIntent().getStringExtra("username");

        welcomeText = findViewById(R.id.tvWelcome);
        welcomeText.setText("Welcome " + username);
    }
}

