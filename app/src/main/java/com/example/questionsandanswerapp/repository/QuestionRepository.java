package com.example.questionsandanswerapp.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.questionsandanswerapp.dao.QuestionDao;
import com.example.questionsandanswerapp.database.QuestionDatabase;
import com.example.questionsandanswerapp.entity.Question;

import java.util.List;

public class QuestionRepository {
    QuestionDao questionDao;
    LiveData<List<Question>> questionLiveData;

    public QuestionRepository(Application application) {
        QuestionDatabase questionDatabase = QuestionDatabase.questionDatabase(application);
        questionDao = questionDatabase.questionDao();
        questionLiveData = questionDao.getAllQuestions();
    }

    public LiveData<List<Question>> getAllQuestions(){
        return questionLiveData;
    }

    public void insert(Question question){
        new Thread(() -> questionDao.insert(question)).start();
    }

    public void update(Question question){
        new Thread(() -> questionDao.update(question)).start();
    }

    public void delete(Question question){
        new Thread(() -> questionDao.delete(question)).start();
    }
}
