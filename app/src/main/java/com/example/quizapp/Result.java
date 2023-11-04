package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Result extends AppCompatActivity {

    TextView textView; Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //Showing Score
        textView = findViewById(R.id.score);
        int scoreCounter = getIntent().getIntExtra("score",0);
        textView.setText(String.valueOf(scoreCounter));

        button = findViewById(R.id.button);
        button.setOnClickListener(v -> startActivity(new Intent(this, MainActivity.class)));
    }
}