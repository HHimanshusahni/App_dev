package com.himanshu.a05gameconnect3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 0 = yellow and 1 is red
    int activePlayer = 0;

    boolean gameIsActive  = true;
    //2 means uplayed
    int [] gameState= {2,2,2,2,2,2,2,2,2};
    int [][] winningPositions  = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};


    public void dropIn(View view){

        ImageView counter = (ImageView)view;


        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if(gameState[tappedCounter]==2&& gameIsActive) {

            gameState[tappedCounter] = activePlayer;
            counter.setTranslationY(-1000f);

            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellow_circle);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.red_circle);
                activePlayer = 0;
            }
            counter.animate()
                    .translationYBy(1000f)
                    .rotation(360)
                    .setDuration(300);
            for (int[] winningPositions : winningPositions  ){
                if(gameState[winningPositions[0]]==gameState[winningPositions[1]] &&
                        gameState[winningPositions[1]]==gameState[winningPositions[2]]&&
                            gameState[winningPositions[0]] !=2){

                    //Someone has won!

                    gameIsActive = false;
                    String winner = "Red";

                    if(gameState[winningPositions[0]]==0){
                        winner = "Yellow";
                    }


                    TextView winnerMessage  =(TextView) findViewById(R.id.winnerMessage);

                    winnerMessage.setText(winner + " has won!");

                    LinearLayout layout =(LinearLayout) findViewById(R.id.playAgainLayout);

                    layout.setVisibility(View.VISIBLE);


                }else{

                    boolean gameIsOver = true;
                    for(int counterState :gameState){

                                if(counterState ==2)gameIsOver =false;
                    }
                    if(gameIsOver){


                        TextView winnerMessage  =(TextView) findViewById(R.id.winnerMessage);

                        winnerMessage.setText("It's a draw");

                        LinearLayout layout =(LinearLayout) findViewById(R.id.playAgainLayout);

                        layout.setVisibility(View.VISIBLE);

                    }
                }
            }

        }


    }
    public void playAgain(View view){

        gameIsActive = true;
        LinearLayout layout =(LinearLayout) findViewById(R.id.playAgainLayout);

        layout.setVisibility(View.INVISIBLE);


         activePlayer = 0;


        for(int i =0;i<gameState.length;i++){
                gameState[i] = 2;
        }

        GridLayout gridLayout = (GridLayout)findViewById(R.id.gridLayout);


        for(int i =0;i<gridLayout.getChildCount();i++){

            ((ImageView)gridLayout.getChildAt(i)).setImageResource(0); // 0 to set it empyt image

        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
