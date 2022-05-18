package com.example.questionsandanswerapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.questionsandanswerapp.R;
import com.example.questionsandanswerapp.entity.Question;
import com.example.questionsandanswerapp.viewmodel.QuestionViewModel;

public class UpdateActivity extends AppCompatActivity {
    EditText updateQuestion, updateAnswer;
    Button updateButton;
    QuestionViewModel questionViewModel;
    Question question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        updateQuestion = findViewById(R.id.question_update);
        updateAnswer = findViewById(R.id.answer_update);
        updateButton = findViewById(R.id.update_button);
        questionViewModel = new QuestionViewModel(getApplication());
        Intent intent = getIntent();
        question = (Question) intent.getSerializableExtra(MainActivity.QUESTION_KEY);
        updateQuestion.setText(question.getQuestion());
        updateAnswer.setText(question.getAnswer());




        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String questionUpdate = updateQuestion.getText().toString();
                String answerUpdate = updateAnswer.getText().toString();
                question.setQuestion(questionUpdate);
                question.setAnswer(answerUpdate);
                questionViewModel.update(question);
               // startActivity(new Intent(UpdateActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}