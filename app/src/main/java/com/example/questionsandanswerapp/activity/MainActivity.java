package com.example.questionsandanswerapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.questionsandanswerapp.R;
import com.example.questionsandanswerapp.action.DeleteQuestion;
import com.example.questionsandanswerapp.adapter.QuestionAdapter;
import com.example.questionsandanswerapp.entity.Question;
import com.example.questionsandanswerapp.viewmodel.QuestionViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DeleteQuestion {
    RecyclerView recyclerView;
    FloatingActionButton addButton;
    QuestionAdapter questionAdapter;
    ArrayList<Question> questionArrayList;
    QuestionViewModel questionViewModel;
    public static final String QUESTION_KEY = "question";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        addButton = findViewById(R.id.add_button);
        questionArrayList = new ArrayList<>();
        questionViewModel = new QuestionViewModel(getApplication());
        if(questionArrayList.size() == 0){
            questionArrayList.add(new Question("Where is the capital of VietNam", "HaNoi"));
        }
        questionAdapter = new QuestionAdapter(questionArrayList, this);
        recyclerView.setAdapter(questionAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        questionViewModel.getAllQuestions().observe(this,questions -> {
            questionAdapter.setQuestion((ArrayList<Question>) questions);
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddQuestionActivity.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public void deleteQuestion(Question question) {
        questionViewModel.delete(question);
    }
}