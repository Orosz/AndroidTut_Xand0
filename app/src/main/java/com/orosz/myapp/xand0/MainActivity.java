package com.orosz.myapp.xand0;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int activePlayer = 0; //0 -..zero/verde 1- x

    boolean gameActive = true; //Sa nu pui 0 sau X dupa terminarea jocului

    //2 - unplayed
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                        {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                        {0, 4, 8}, {2, 4, 6}};

    public void dropIn(View view) {

        ImageView counter = (ImageView)view;
        TextView winnerMessage = (TextView)findViewById(R.id.winnerMessage);
        LinearLayout layout = (LinearLayout)findViewById(R.id.playAgainLayout);

        int tapppedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[tapppedCounter] == 2 && gameActive) {

            gameState[tapppedCounter] = activePlayer;
            counter.setTranslationY(-1000f);

            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.zero);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.x);
                activePlayer = 0;
            }

            counter.animate().translationYBy(1000f).setDuration(300);
        }

        for(int[] winningPosition : winningPositions) {

            if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                    gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                    gameState[winningPosition[0]] != 2) {

                String winner = "X";

                //Someone has won!
                gameActive = false;

                if (gameState[winningPosition[0]] == 0) {
                    winner = "0";
                }

                winnerMessage.setText(winner + " has won! \nHoray!");

                layout.setVisibility(View.VISIBLE);

            } else {
                boolean gameOver = true;

                for (int counterState: gameState) {

                    if (counterState == 2) { gameOver = false;

                    }
                }
                if (gameOver) {
                    winnerMessage.setText("It's a draw!");
                    layout.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    public void playAgain(View view) {

        LinearLayout layout = (LinearLayout)findViewById(R.id.playAgainLayout);
        layout.setVisibility(View.INVISIBLE);

        activePlayer = 0; //0 -..zero/verde 1- x
        gameActive = true;

       for (int i = 0; i < gameState.length; i++) {
           gameState[i] = 2;
       }

       //Asa nu ii place
       /*TableLayout board = (TableLayout)findViewById(R.id.tableBoard);
       for (int i = 0; i < board.getChildCount(); i++) {

           ((ImageView) board.getChildAt(i)).setImageResource(0);
       }*/

       //Incercam asa -> Nici asa
        /*ImageView image;
        String imageID;
        for (int i = 0; i < 9; i++) {
            imageID = "R.id.imageView" + i;
            image = findViewById(Integer.parseInt(imageID));
            image.setImageResource(0);
        }*/

        //taraneste mod
        ImageView imageView = (ImageView)findViewById(R.id.imageView0);
        imageView.setImageResource(0);
        imageView = (ImageView)findViewById(R.id.imageView1);
        imageView.setImageResource(0);
        imageView = (ImageView)findViewById(R.id.imageView2);
        imageView.setImageResource(0);
        imageView = (ImageView)findViewById(R.id.imageView3);
        imageView.setImageResource(0);
        imageView = (ImageView)findViewById(R.id.imageView4);
        imageView.setImageResource(0);
        imageView = (ImageView)findViewById(R.id.imageView5);
        imageView.setImageResource(0);
        imageView = (ImageView)findViewById(R.id.imageView6);
        imageView.setImageResource(0);
        imageView = (ImageView)findViewById(R.id.imageView7);
        imageView.setImageResource(0);
        imageView = (ImageView)findViewById(R.id.imageView8);
        imageView.setImageResource(0);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
