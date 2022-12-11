package com.example.android.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //public static final int EXTRA_TEXT = "com.example.android.quizapp.EXTRA_TEXT";
    final int totalQuestions = 8;
    int totalCorrect = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* Checks for any missed questions before submitting */

    public void submitButtonValidation(View v) {
        Button submitButton = findViewById(R.id.submitBtn);
        RadioGroup q1Selected = (RadioGroup) findViewById(R.id.q1_selectCheck);
        RadioGroup q2Selected = (RadioGroup) findViewById(R.id.q2_selectCheck);
        RadioGroup q3Selected = (RadioGroup) findViewById(R.id.q3_selectCheck);
        RadioGroup q5Selected = (RadioGroup) findViewById(R.id.q5_selectCheck);
        EditText q6input = findViewById(R.id.q6_potion);
        String potion = q6input.getText().toString();
        RadioGroup q7Selected = (RadioGroup) findViewById(R.id.q7_selectCheck);
        RadioGroup q8Selected = (RadioGroup) findViewById(R.id.q8_selectCheck);

        CheckBox q4Selected_a = (CheckBox) findViewById(R.id.q4_yaxley);
        CheckBox q4Selected_b = (CheckBox) findViewById(R.id.q4_lestrange);
        CheckBox q4Selected_c = (CheckBox) findViewById(R.id.q4_dursley);
        CheckBox q4Selected_d = (CheckBox) findViewById(R.id.q4_moody);

        boolean q4a = q4Selected_a.isChecked();
        boolean q4b = q4Selected_b.isChecked();
        boolean q4c = q4Selected_c.isChecked();
        boolean q4d = q4Selected_d.isChecked();


        String toastMessage;

        if (q1Selected.getCheckedRadioButtonId() == -1 || q2Selected.getCheckedRadioButtonId() == -1 || q3Selected.getCheckedRadioButtonId() == -1 || q5Selected.getCheckedRadioButtonId() == -1
                || potion == null || q7Selected.getCheckedRadioButtonId() == -1 || q8Selected.getCheckedRadioButtonId() == -1 ||
                (q4a == false && q4b == false && q4c == false && q4d == false)) {

            Log.v("MainActivity", "Checkbox a: " + potion);
            Log.v("MainActivity", "Checkbox b: " + q7Selected.getCheckedRadioButtonId());
            Log.v("MainActivity", "Checkbox c: " + q8Selected.getCheckedRadioButtonId());
            Log.v("MainActivity", "Checkbox d: " + q5Selected.getCheckedRadioButtonId());

            toastMessage = "You missed a question! Please check again.";

            Toast showToast = Toast.makeText(this, toastMessage, Toast.LENGTH_LONG);
            showToast.show();
        }
        else {
            computeResults();
        }

    }

    public void computeResults() {

        /* Answer 1 : Radio Button : Cedric */
        RadioButton q1Answer = (RadioButton) findViewById(R.id.q1_cedric);
        if (q1Answer.isChecked()) {
            totalCorrect += 1;
        }

        /* Answer 2 : Radio Button : Chamber of Secrets */
        RadioButton q2Answer = (RadioButton) findViewById(R.id.q2_chamberofsecrets);
        if (q2Answer.isChecked()) {
            totalCorrect += 1;
        }

        /* Answer 3 : Radio Button : Dentist */
        RadioButton q3Answer = (RadioButton) findViewById(R.id.q3_dentist);
        if (q3Answer.isChecked()) {
            totalCorrect += 1;
        }


        /* Answer 4 : CheckBox Death eaters */
        int q4Correct = 0;

        CheckBox yaxleyCheckTrue = (CheckBox) findViewById(R.id.q4_yaxley);
        CheckBox lestrageCheckTrue = (CheckBox) findViewById(R.id.q4_lestrange);

        if (yaxleyCheckTrue.isChecked()) {
            q4Correct++;
        }

        if (lestrageCheckTrue.isChecked()) {
            q4Correct++;
        }

        if (q4Correct == 2) {
            totalCorrect++;
        }

        /* Answer 5 : Radio Button : Animagi */
        RadioButton q5Answer = (RadioButton) findViewById(R.id.q5_animagi);
        if (q5Answer.isChecked()) {
            totalCorrect += 1;
        }

        /* Answer 6 : Text: Polyjuice or Polyjuice Potion */
        EditText q6Answer = (EditText) findViewById(R.id.q6_potion);
        String potionName = q6Answer.getText().toString();
        if (potionName.equals("Polyjuice") || potionName.equals("Polyjuice Potion")) {
            totalCorrect += 1;
        }

        /* Answer 7 : Image: Hufflepuff Cup */
        RadioButton q7Answer = (RadioButton) findViewById(R.id.q7_hufflepuffCup_btn);
        if (q7Answer.isChecked()) {
            totalCorrect += 1;
        }

        /* Answer 8 : RadioButton: Occlumency */
        RadioButton q8Answer = (RadioButton) findViewById(R.id.q8_occlumency);
        if (q8Answer.isChecked()) {
            totalCorrect += 1;
        }

        /* DISPLAY THEN RESET SCORE */

        /* Show the result via Second Page */

        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("totalCorrect", totalCorrect);
        intent.putExtra("totalQuestions", totalQuestions);
        startActivity(intent);

    }
}