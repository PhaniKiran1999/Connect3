package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int[][] winningStates = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    static int currentPlayer = 0;
    static String player = "Yellow";
    public void dropIn(View view){
        ImageView counter = (ImageView) view;
        if (currentPlayer == 0)
            player = "Yellow";
        else
            player = "Red";

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedCounter] == 2) {

            gameState[tappedCounter] = currentPlayer;

            counter.setTranslationY(-1000f);

            if (currentPlayer == 0) {
                counter.setImageResource(R.drawable.yellow);
                currentPlayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                currentPlayer = 0;

            }

            counter.animate().translationYBy(1000f).rotation(360).setDuration(700);

        }
        for(int[] winningState:winningStates){
            if (gameState[winningState[0]]==gameState[winningState[1]]&&
                gameState[winningState[1]]==gameState[winningState[2]]&&
                gameState[winningState[0]]!=2){
                Toast.makeText(getApplicationContext(),player+" is the Winner",Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
