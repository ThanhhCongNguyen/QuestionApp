package com.example.questionsandanswerapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.questionsandanswerapp.R;
import com.example.questionsandanswerapp.action.DeleteQuestion;
import com.example.questionsandanswerapp.activity.MainActivity;
import com.example.questionsandanswerapp.activity.UpdateActivity;
import com.example.questionsandanswerapp.entity.Question;

import java.util.ArrayList;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder> {

    ArrayList<Question> questionArrayList;
    DeleteQuestion deleteQuestion;

    public QuestionAdapter(ArrayList<Question> questionArrayList, DeleteQuestion deleteQuestion) {
        this.questionArrayList = questionArrayList;
        this.deleteQuestion = deleteQuestion;
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_item, parent, false);
        return new QuestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
        holder.bind(questionArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return questionArrayList.size();
    }

    public void setQuestion(ArrayList<Question> questionArrayList){
        this.questionArrayList = questionArrayList;
        notifyDataSetChanged();
    }

    class QuestionViewHolder extends RecyclerView.ViewHolder{

        TextView questionText, answerText;
        CardView cardView;
        ImageView deleteImg;

        public QuestionViewHolder(@NonNull View itemView) {
            super(itemView);
            questionText = itemView.findViewById(R.id.question_text);
            answerText = itemView.findViewById(R.id.answer_text);
            cardView = itemView.findViewById(R.id.cardView);
            deleteImg = itemView.findViewById(R.id.delete_button);




        }
        public void bind(Question question){
            questionText.setText(question.getQuestion());
            answerText.setText(question.getAnswer());
//            if(question.isExpand()){
//                answerText.setVisibility(View.VISIBLE);
//            }else {
//                answerText.setVisibility(View.GONE);
//            }
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Log.d("TAG", "click");
//                    question.setExpand(!question.isExpand());
//                    if(question.isExpand()){
//                        answerText.setVisibility(View.VISIBLE);
//                    }
                    Context context = view.getContext();
                    Intent intent = new Intent(context, UpdateActivity.class);
                    intent.putExtra(MainActivity.QUESTION_KEY, question);
                    context.startActivity(intent);


                }
            });

            deleteImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    deleteQuestion.deleteQuestion(question);
                }
            });
        }
    }
}
