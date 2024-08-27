package com.example.myapplication;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizNeu extends AppCompatActivity {
    RadioGroup radioGroup1, radioGroup2, radioGroup3, radioGroup4;
    RadioButton radioButton;
    Button btnSubmit1, btnCheck1, btnSubmit2, btnCheck2, btnSubmit3, btnCheck3, btnSubmit4, btnCheck4, btnback;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Cursor cursor;
    int currentQuestionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quizneu);

        // Initialize UI components
        radioGroup1 = findViewById(R.id.radioGroupEpochen);
        radioGroup2 = findViewById(R.id.radioGroupKuenstler);
        radioGroup3 = findViewById(R.id.radioGroupEpochen2);
        radioGroup4 = findViewById(R.id.radioGroupKuenstler2);

        btnSubmit1 = findViewById(R.id.submit_answers_button1);
        btnCheck1 = findViewById(R.id.check_answers_button1);
        btnSubmit2 = findViewById(R.id.submit_answers_button2);
        btnCheck2 = findViewById(R.id.check_answers_button2);
        btnSubmit3 = findViewById(R.id.submit_answers_button3);
        btnCheck3 = findViewById(R.id.check_answers_button3);
        btnSubmit4 = findViewById(R.id.submit_answers_button4);
        btnCheck4 = findViewById(R.id.check_answers_button4);
        btnback = findViewById(R.id.quiz_button1);

        openHelper = new DatabaseHelper(this);
        setupListeners();
    }

    private void setupListeners() {
        // Setup listeners for Quiz 1
        btnSubmit1.setOnClickListener(v -> handleSubmit(radioGroup1, 1));
        btnCheck1.setOnClickListener(v -> handleCheck(1));

        // Setup listeners for Quiz 2
        btnSubmit2.setOnClickListener(v -> handleSubmit(radioGroup2, 2));
        btnCheck2.setOnClickListener(v -> handleCheck(2));

        // Setup listeners for Quiz 3
        btnSubmit3.setOnClickListener(v -> handleSubmit(radioGroup3, 3));
        btnCheck3.setOnClickListener(v -> handleCheck(3));

        // Setup listeners for Quiz 4
        btnSubmit4.setOnClickListener(v -> handleSubmit(radioGroup4, 4));
        btnCheck4.setOnClickListener(v -> handleCheck(4));

        btnCheck4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleCheck(4);
            }
        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void handleSubmit(RadioGroup radioGroup, int quizNumber) {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        if (selectedId == -1) {
            Toast.makeText(getApplicationContext(), "Please select an answer", Toast.LENGTH_SHORT).show();
            return;
        }

        radioButton = findViewById(selectedId);
        if (radioButton == null) {
            Toast.makeText(getApplicationContext(), "Error: RadioButton not found", Toast.LENGTH_LONG).show();
            return;
        }

        String text = radioButton.getText().toString();
        db = openHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_SA_2, text);
        long id = db.insert(DatabaseHelper.TABLE_SA, null, contentValues);

        if (id == -1) {
            Toast.makeText(getApplicationContext(), "Error while inserting", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Answer submitted successfully", Toast.LENGTH_LONG).show();
        }

        // Evaluate the answer
        evaluateAnswer(text, quizNumber);
    }


    private void evaluateAnswer(String answer, int quizNumber) {
        db = openHelper.getReadableDatabase();
        String qry = "SELECT " + DatabaseHelper.COL_ANS_2 + " FROM " + DatabaseHelper.TABLE_ANSWER + " WHERE " + DatabaseHelper.COL_ANS_1 + " = ?";
        Log.d("EvaluateAnswer", "Query: " + qry + " with quizNumber: " + quizNumber);
        Cursor cursor = db.rawQuery(qry, new String[]{String.valueOf(quizNumber)});

        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
                    String correctAnswer = cursor.getString(0);
                    Log.d("EvaluateAnswer", "Correct answer found: " + correctAnswer);
                    // Continue processing
                } else {
                    Log.d("EvaluateAnswer", "No data found");
                    Toast.makeText(getApplicationContext(), "Error: No correct answer found", Toast.LENGTH_LONG).show();
                }
            } finally {
                cursor.close();
            }
        } else {
            Log.d("EvaluateAnswer", "Cursor is null");
            Toast.makeText(getApplicationContext(), "Error: Cursor is null", Toast.LENGTH_LONG).show();
        }
    }



    private void handleCheck(int quizNumber) {
        db = openHelper.getReadableDatabase();
        String checkQuery = "SELECT " + DatabaseHelper.COL_COM_2 + " FROM " + DatabaseHelper.TABLE_COM + " ORDER BY " + DatabaseHelper.COL_COM_1 + " DESC LIMIT 1";
        Log.d("HandleCheck", "Query: " + checkQuery);
        Cursor cursor = db.rawQuery(checkQuery, null);

        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
                    String value = cursor.getString(0);
                    Log.d("HandleCheck", "Value found: " + value);
                    Toast.makeText(getApplicationContext(), "Your submitted answer is " + value, Toast.LENGTH_LONG).show();
                } else {
                    Log.d("HandleCheck", "No data found");
                    Toast.makeText(getApplicationContext(), "Error: No data found", Toast.LENGTH_LONG).show();
                }
            } finally {
                cursor.close();
            }
        } else {
            Log.d("HandleCheck", "Cursor is null");
            Toast.makeText(getApplicationContext(), "Error: Cursor is null", Toast.LENGTH_LONG).show();
        }
    }



}

