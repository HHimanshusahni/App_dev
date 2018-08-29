package com.himanshu.a07braintrainerapp;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button startButton;
    TextView resultTextView;
    TextView pointsTextView;
    Button button0,button1,button2,button3;
    TextView sumTextView;
    TextView timerTextView;
    Button playAgainButton;
    RelativeLayout frameLayout;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationofCorrectAnswer;
    int score = 0;
    int numberOfQuestions = 0;


    public void playAgain(View view){
        generateQuestion();
        score = 0;
        numberOfQuestions = 0;

        timerTextView.setText("30s");
        pointsTextView.setText("0/0");
        resultTextView.setText("");

        playAgainButton.setVisibility(View.INVISIBLE);
        new CountDownTimer( 31000,1000){
            @Override
            public void onTick(long l) {
                timerTextView.setText(String.valueOf(l/1000)+"s");

            }

            @Override
            public void onFinish() {
                playAgainButton.setVisibility(View.VISIBLE);
                timerTextView.setText("0s");
                resultTextView.setText("Your Score"+Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));
            }
        }.start();

    }
    public  void generateQuestion(){

        Random rand  = new Random();
        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        sumTextView.setText(Integer.toString(a)+"+"+Integer.toString(b));

        locationofCorrectAnswer = rand.nextInt(4);
        answers.clear(); // deletes the contents of the previous called arraylist otherwise answer will not update for the question
        int incorrectAnswer ;
        for(int i = 0;i<4;i++){
            if(i==locationofCorrectAnswer){
                answers.add(a+b);
            }else {
                incorrectAnswer = rand.nextInt(41);
                while (incorrectAnswer == a+b){
                    incorrectAnswer = rand.nextInt();
                }

                answers.add(incorrectAnswer);

            }
        }
        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));

    }

    public void chooseAnswer(View view){

        if(view.getTag().toString().equals(Integer.toString(locationofCorrectAnswer))){

            //if the answer is correct
            score++;
            resultTextView.setText("Correct");

        }else{
            //incorrect
            resultTextView.setText("Wrong!");

        }

        numberOfQuestions++;
        pointsTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));
        generateQuestion();
    }

    public  void start(View view){
        startButton.setVisibility(View.INVISIBLE);
        frameLayout.setVisibility(frameLayout.VISIBLE);

        playAgain(playAgainButton.findViewById(R.id.playAgainButton));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button)findViewById(R.id.startButton);
         sumTextView = (TextView)findViewById(R.id.SumTextView);

         button0 = (Button)findViewById(R.id.button0);
         button1 = (Button)findViewById(R.id.button1);
         button2 = (Button)findViewById(R.id.button2);
         button3 = (Button)findViewById(R.id.button3);
        resultTextView = (TextView)findViewById(R.id.resultTextView);
        pointsTextView = (TextView)findViewById( R.id.pointsTextView);
        timerTextView = (TextView)findViewById(R.id.timerTextView);
        playAgainButton = (Button) findViewById(R.id.playAgainButton);
        frameLayout= (RelativeLayout)findViewById(R.id.frameLayout);



    }
}
