package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    /**
     * This method is called when answers are submitted and checks to see which answers are correct.
     */
    public void submitAnswers(View view) {

        /// Variable specifying the number of correct answers
        int numberCorrect = 0;

        /// Checks to see if the answer to question 1 is correct
        RadioButton question1 = findViewById(R.id.beagle_radio_button);
        boolean isQuestion1Correct = question1.isChecked();
        if (isQuestion1Correct) {
            numberCorrect += 1;
        }

        /// Checks to see if the answer to question 2 is correct
        RadioButton question2 = findViewById(R.id.whippet_radio_button);
        boolean isQuestion2Correct = question2.isChecked();
        if (isQuestion2Correct) {
            numberCorrect += 1;
        }

        /// Checks to see if the answer to question 3 is correct
        CheckBox question3A = findViewById(R.id.german_shepherd_checkbox);
        CheckBox question3B = findViewById(R.id.cattle_dog_checkbox);
        CheckBox question3C = findViewById(R.id.corgi_checkbox);
        CheckBox question3D = findViewById(R.id.labrador_retriever_checkbox);
        boolean hasCorrectAnswers = question3A.isChecked() & question3C.isChecked();
        boolean hasNoIncorrectAnswers = !question3B.isChecked() & !question3D.isChecked();
        if (hasCorrectAnswers & hasNoIncorrectAnswers) {
            numberCorrect += 1;
        }

        /// Checks to see if the answer to question 4 is correct
        EditText question4 = findViewById(R.id.pomeranian_edit_text);
        String question4Answer = question4.getText().toString().toLowerCase();
        if (question4Answer.equals("pomeranian")) {
            numberCorrect += 1;
        }

        /// Creates toasts telling you how many questions you got right/wrong
        if (numberCorrect == 4) {
            Toast.makeText(this, getString(R.string.congrats), Toast.LENGTH_LONG).show();
        } else if (numberCorrect == 3) {
            Toast.makeText(this, getString(R.string.incorrect1) + " " + (4 - numberCorrect) + " " + getString(R.string.incorrect2), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, getString(R.string.incorrect1) + " " + (4 - numberCorrect) + " " + getString(R.string.incorrect3), Toast.LENGTH_LONG).show();
        }
    }
}
