package com.example.questionsandanswerapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.questionsandanswerapp.entity.Question;
import com.example.questionsandanswerapp.repository.QuestionRepository;

import java.util.List;

public class QuestionViewModel extends AndroidViewModel {

    QuestionRepository questionRepository;
    LiveData<List<Question>> questionLiveData;

    public QuestionViewModel(@NonNull Application application) {
        super(application);
        questionRepository = new QuestionRepository(application);
        questionLiveData = questionRepository.getAllQuestions();
    }

    public LiveData<List<Question>> getAllQuestions(){
        return questionLiveData;
    }

    public void insert(Question question){
        questionRepository.insert(question);
    }

    public void update(Question question){
        questionRepository.update(question);
    }

    public void delete(Question question){
        questionRepository.delete(question);
    }
}
