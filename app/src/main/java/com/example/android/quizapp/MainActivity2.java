package com.example.android.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        int totalCorrect = intent.getIntExtra("totalCorrect", 0);
        int totalQuestions = intent.getIntExtra("totalQuestions", 0);

        TextView result = findViewById(R.id.result);
        ImageView resultPic = findViewById(R.id.image_result);

        if (totalCorrect == 8) {
            resultPic.setImageResource(R.drawable.potterhead);
            result.setText("Congratulations you got 100%\nYer a Wizard!");
        } else if (totalCorrect > 0) {
            resultPic.setImageResource(R.drawable.almost_potterhead);
            result.setText("You got " + totalCorrect + " out of " + totalQuestions + " correct!\nTry again to be a Potterhead.");
        } else {
            resultPic.setImageResource(R.drawable.sad_dobby);
            result.setText("All your answers are incorrect :(\n Yer not a Potterhead");
        }
    }
}