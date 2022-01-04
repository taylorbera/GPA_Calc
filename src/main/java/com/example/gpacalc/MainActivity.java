package com.example.gpacalc;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.gpacalc.R.color.green;
import static com.example.gpacalc.R.color.red;
import static com.example.gpacalc.R.color.yellow;

public class MainActivity extends AppCompatActivity {

    Button gpaButton;
    int c1, c2, c3, c4, c5, GPA;
    String course1, course2, course3, course4, course5;
    TextView finalGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RelativeLayout currentLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        gpaButton = (Button)findViewById(R.id.button);
        gpaButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"ResourceAsColor", "SetTextI18n"})
            @Override
            public void onClick(View view) {
                gpaButton.setBackgroundColor(android.R.color.background_light);

                course1 = ((EditText) findViewById(R.id.editTextNumber)).getText().toString();
                course2 = ((EditText) findViewById(R.id.editTextNumber2)).getText().toString();
                course3 = ((EditText) findViewById(R.id.editTextNumber3)).getText().toString();
                course4 = ((EditText) findViewById(R.id.editTextNumber5)).getText().toString();
                course5 = ((EditText) findViewById(R.id.editTextNumber4)).getText().toString();

                if (TextUtils.isEmpty(course1)) {
                    ((EditText) findViewById(R.id.editTextNumber)).setError("EMPTY");
                    ((EditText) findViewById(R.id.editTextNumber)).setBackgroundColor(getResources().getColor(red));
                }

                if (TextUtils.isEmpty(course2)) {
                    ((EditText) findViewById(R.id.editTextNumber2)).setError("EMPTY");
                    ((EditText) findViewById(R.id.editTextNumber2)).setBackgroundColor(getResources().getColor(red));
                }

                if (TextUtils.isEmpty(course3)) {
                    ((EditText) findViewById(R.id.editTextNumber3)).setError("EMPTY");
                    ((EditText) findViewById(R.id.editTextNumber3)).setBackgroundColor(getResources().getColor(red));
                }

                if (TextUtils.isEmpty(course4)) {
                    ((EditText) findViewById(R.id.editTextNumber5)).setError("EMPTY");
                    ((EditText) findViewById(R.id.editTextNumber5)).setBackgroundColor(getResources().getColor(red));
                }

                if (TextUtils.isEmpty(course5)) {
                    ((EditText) findViewById(R.id.editTextNumber4)).setError("EMPTY");
                    ((EditText) findViewById(R.id.editTextNumber4)).setBackgroundColor(getResources().getColor(red));
                } else {
                    c1 = Integer.parseInt(course1);
                    c2 = Integer.parseInt(course2);
                    c3 = Integer.parseInt(course3);
                    c4 = Integer.parseInt(course4);
                    c5 = Integer.parseInt(course5);
                    GPA = (c1 + c2 + c3 + c4 + c5) / 5;
                    finalGPA = (TextView) findViewById(R.id.textView8);
                    finalGPA.setText("You're final grade is " + GPA);
                    if (GPA <= 60) {
                        currentLayout.setBackgroundColor(getResources().getColor(red));
                    } else if (GPA >= 61 && GPA <= 79) {
                        currentLayout.setBackgroundColor(getResources().getColor(yellow));
                    } else if (GPA >= 80) {
                        currentLayout.setBackgroundColor(getResources().getColor(green));
                    }
                }
            }
        });
    }
}



