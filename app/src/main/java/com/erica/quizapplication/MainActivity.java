package com.erica.quizapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;


public class MainActivity extends Activity {

    List<Question> questionsList;
    int score = 0;
    int round = 1;
    int ID;
    Question currentQuestion;
    TextView txtQuestion, times, scored, rounds;
    Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the view
        init();

        //Initialize the database
        final DbHelper dbHelper=new DbHelper(this);
        questionsList= dbHelper.getAllQuestions();
        currentQuestion=questionsList.get(ID);

        txtQuestion = (TextView) findViewById(R.id.questionText);

        btn1 = (Button) findViewById(R.id.ans1);
        btn2 = (Button) findViewById(R.id.ans2);
        btn3 = (Button) findViewById(R.id.ans3);
        btn4 = (Button) findViewById(R.id.ans4);

        scored = (TextView) findViewById(R.id.score); //the score
        rounds = (TextView) findViewById(R.id.round); //the score

        //Set question

        setQuestionView();

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getAnswer(btn1.getText().toString());
            }
        });

        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getAnswer(btn2.getText().toString());
            }
        });

        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getAnswer(btn3.getText().toString());
            }
        });

        btn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getAnswer(btn4.getText().toString());
            }
        });
    }

    private void init() {
    }

    private void getAnswer(String Answer) {
        if(currentQuestion.getAnswer().equals(Answer)){
            score++;
            scored.setText(String.valueOf(score));
        }

        if(round<4){
            currentQuestion=questionsList.get(ID);
            setQuestionView();
        }else{
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score); //Your score
            intent.putExtras(b); //Put your score to your next Intent
            startActivity(intent);
            finish();
        }

        round++;
        rounds.setText(String.valueOf(round));
    }


    private void setQuestionView() {

        txtQuestion.setText(currentQuestion.getQuestion());
        btn1.setText(currentQuestion.getOption1());
        btn2.setText(currentQuestion.getOption2());
        btn3.setText(currentQuestion.getOption3());
        btn4.setText(currentQuestion.getOption4());
        ID++;
    }
}
