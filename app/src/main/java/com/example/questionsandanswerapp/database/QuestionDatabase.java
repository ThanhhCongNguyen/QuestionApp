package com.example.questionsandanswerapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.questionsandanswerapp.dao.QuestionDao;
import com.example.questionsandanswerapp.entity.Question;

@Database(entities = Question.class, version = 1, exportSchema = false)
public abstract class QuestionDatabase extends RoomDatabase {
    public abstract QuestionDao questionDao();

    private static QuestionDatabase questionDatabase;

    public static QuestionDatabase questionDatabase(final Context context) {
        if (questionDatabase == null) {
            synchronized (QuestionDatabase.class) {
                if (questionDatabase == null) {
                    questionDatabase = Room.databaseBuilder(context.getApplicationContext(),
                            QuestionDatabase.class,
                            "question_table")
                            .build();
                }
            }
        }

        return questionDatabase;
    }
}
