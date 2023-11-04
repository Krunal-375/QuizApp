package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> Questions = new ArrayList();
    public String[][] Options  = new String[10][4];
    public int[] CorrectAnswers = new int[10];
    TextView Question,Response;
    int questionNumber = 0,optionChoosed,scoreCounter=0;

    Button Optioan1,Option2,Option3,Option4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Defining Qustions
        Questions.add("What is the world's longest freshwater lake?");
        Questions.add("Which mountain range serves as the boundary between Europe and Asia?");
        Questions.add("What is the capital of Japan?");
        Questions.add("What is the chemical formula for water?");
        Questions.add("What is the largest planet in the solar system?");
        Questions.add("What is the largest ocean in the world?");
        Questions.add("What is the square root of 16?");
        Questions.add("What is the name of the largest desert in the world?");
        Questions.add("What is the name of the largest river in the world by volume?");
        Questions.add("What is the name of the highest mountain in the world?");

        Question = findViewById(R.id.Question);
        Question.setText(Questions.get(questionNumber));

        Optioan1 = findViewById(R.id.Optioan1);
        Option2 = findViewById(R.id.Optioan2);
        Option3 = findViewById(R.id.Option3);
        Option4 = findViewById(R.id.Optioan4);

        //Options for Q1
        Options[0][0] = "Lake Superior";
        Options[0][1] = "Lake Victoria";
        Options[0][2] = "Lake Tanganyika";
        Options[0][3] = "Lake Baikal";

        //Options for Q2
        Options[1][0] = "The Alps";
        Options[1][1] = "The Ural Mountains";
        Options[1][2] = "The Caucasus Mountains";
        Options[1][3] = "The Himalayas";

        //Options for Q3
        Options[2][0] = "Yokohama";
        Options[2][1] = "Kyoto";
        Options[2][2] = "Osaka";
        Options[2][3] = "Tokyo";

        //Options for Q4
        Options[3][0] = "O2";
        Options[3][1] = "N2";
        Options[3][2] = "H2O";
        Options[3][3] = "CO2";

        //Options for Q5
        Options[4][0] = "Neptune";
        Options[4][1] = "Uranus";
        Options[4][2] = "Saturn";
        Options[4][3] = "Jupiter";

        //Options for Q6
        Options[5][0] = "Indian Ocean";
        Options[5][1] = "Arctic Ocean";
        Options[5][2] = "Atlantic Ocean";
        Options[5][3] = "Pacific Ocean";

        //Options for Q7
        Options[6][0] = "4";
        Options[6][1] = "8";
        Options[6][2] = "16";
        Options[6][3] = "12";

        //Options for Q8
        Options[7][0] = "Arabian Desert";
        Options[7][1] = "Patagonian Desert";
        Options[7][2] = "Gobi Desert";
        Options[7][3] = "Sahara Desert";

        //Options for Q9
        Options[8][0] = "Yangtze River";
        Options[8][1] = "Mississippi River";
        Options[8][2] = "Nile River";
        Options[8][3] = "Amazon River";

        //Options for Q10
        Options[9][0] = "Mount Everest";
        Options[9][1] = "K2";
        Options[9][2] = "Kangchenjunga";
        Options[9][3] = "Lhotse";

        Optioan1.setText(Options[questionNumber][0]);
        Option2.setText(Options[questionNumber][1]);
        Option3.setText(Options[questionNumber][2]);
        Option4.setText(Options[questionNumber][3]);

        Optioan1.setOnClickListener(v -> {
            OptionChoosed();
            optionChoosed=1;


        });
        Option2.setOnClickListener(v -> {
            OptionChoosed();
            optionChoosed=2;
        });
        Option3.setOnClickListener(v -> {
            OptionChoosed();
            optionChoosed=3;
        });
        Option4.setOnClickListener(v -> {
            OptionChoosed();
            optionChoosed=4;
        });

        //Defining Correct Answers
        CorrectAnswers[0] = 3;
        CorrectAnswers[1] = 2;
        CorrectAnswers[2] = 4;
        CorrectAnswers[3] = 3;
        CorrectAnswers[4] = 4;
        CorrectAnswers[5] = 4;
        CorrectAnswers[6] = 1;
        CorrectAnswers[7] = 4;
        CorrectAnswers[8] = 4;
        CorrectAnswers[9] = 1;

        Response = findViewById(R.id.response);

    }

    private void OptionChoosed(){
        if (optionChoosed==CorrectAnswers[questionNumber]){
            Response.setText("Correct");
            ++scoreCounter;
        }else Response.setText("Incorrect");
        try {
            Question.setText(Questions.get(++questionNumber));
            Optioan1.setText(Options[questionNumber][0]);
            Option2.setText(Options[questionNumber][1]);
            Option3.setText(Options[questionNumber][2]);
            Option4.setText(Options[questionNumber][3]);

        }catch (IndexOutOfBoundsException e){
            Intent intent = new Intent(this, Result.class);
            intent.putExtra("score",scoreCounter);
            startActivity(intent);
        }
    }
}