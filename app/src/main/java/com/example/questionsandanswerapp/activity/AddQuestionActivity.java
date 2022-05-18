package com.example.questionsandanswerapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.questionsandanswerapp.R;
import com.example.questionsandanswerapp.entity.Question;
import com.example.questionsandanswerapp.viewmodel.QuestionViewModel;

public class AddQuestionActivity extends AppCompatActivity {
    QuestionViewModel questionViewModel;
    EditText questionEdittext, answerEdittext;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);
        questionViewModel = new QuestionViewModel(getApplication());
        questionEdittext = findViewById(R.id.question_edittext);
        answerEdittext = findViewById(R.id.answer_edittext);
        saveButton = findViewById(R.id.save_button);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String question = questionEdittext.getText().toString();
                String answer = answerEdittext.getText().toString();
                questionViewModel.insert(new Question(question, answer));
                finish();
            }
        });


    }
}