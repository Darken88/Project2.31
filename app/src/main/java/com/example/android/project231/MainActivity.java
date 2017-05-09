package com.example.android.project231;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.project231.R;

import java.util.Set;

import static android.R.attr.duration;
import static com.example.android.project231.R.id.addOneMe;
import static com.example.android.project231.R.id.addOneYou;
import static com.example.android.project231.R.id.iLoose;
import static com.example.android.project231.R.id.iWin;
import static com.example.android.project231.R.id.loseOneMe;
import static com.example.android.project231.R.id.loseOneYou;
import static com.example.android.project231.R.id.tick1me;
import static com.example.android.project231.R.id.tick1you;
import static com.example.android.project231.R.id.tick2me;
import static com.example.android.project231.R.id.tick2you;
import static com.example.android.project231.R.id.youLoose;
import static com.example.android.project231.R.id.youWin;

public class MainActivity extends AppCompatActivity {
    int meScore = 20;
    int youScore = 20;
    int meRound = 0;
    int youRound = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayMeScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.meScore);
        scoreView.setText(String.valueOf(score));
    }


    public void displayYouScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.youScore);
        scoreView.setText(String.valueOf(score));
    }

    public void addOneMe(View v) {
        meScore = meScore + 1;
        displayMeScore(meScore);
    }

    public void loseOneMe(View v) {
        if (meScore == 0) {
            return;
        }
        meScore = meScore - 1;
        displayMeScore(meScore);
        if (meScore == 0) {
            youRound = youRound + 1;
            findViewById(addOneMe).setVisibility(View.INVISIBLE);
            findViewById(addOneYou).setVisibility(View.INVISIBLE);
            findViewById(loseOneMe).setVisibility(View.INVISIBLE);
            findViewById(loseOneYou).setVisibility(View.INVISIBLE);
            Toast.makeText(getApplicationContext(), "He won a round", Toast.LENGTH_SHORT).show();
        }
        if (youRound == 1) {
            findViewById(tick1you).setVisibility(View.VISIBLE);
        }
        if (youRound == 2) {
            findViewById(tick2you).setVisibility(View.VISIBLE);
            Toast.makeText(getApplicationContext(), "you won the match...", Toast.LENGTH_SHORT).show();
            findViewById(youWin).setVisibility(View.VISIBLE);
            findViewById(iLoose).setVisibility(View.VISIBLE);
        }
    }

    public void addOneYou(View v) {
        youScore = youScore + 1;
        displayYouScore(youScore);
    }

    public void loseOneYou(View v) {
        if (youScore == 0) {
            return;
        }
        youScore = youScore - 1;
        displayYouScore(youScore);
        if (youScore == 0) {
            meRound = meRound + 1;
            findViewById(addOneMe).setVisibility(View.INVISIBLE);
            findViewById(addOneYou).setVisibility(View.INVISIBLE);
            findViewById(loseOneMe).setVisibility(View.INVISIBLE);
            findViewById(loseOneYou).setVisibility(View.INVISIBLE);
            Toast.makeText(getApplicationContext(), "I won a round!", Toast.LENGTH_SHORT).show();
        }
        if (meRound == 1) {
            findViewById(tick1me).setVisibility(View.VISIBLE);
        }
        if (meRound == 2) {
            findViewById(tick2me).setVisibility(View.VISIBLE);
            Toast.makeText(getApplicationContext(), "I WON THE MATCH!!!", Toast.LENGTH_SHORT).show();
            findViewById(iWin).setVisibility(View.VISIBLE);
            findViewById(youLoose).setVisibility(View.VISIBLE);
        }
    }

    public void resetMe(View v) {
        findViewById(addOneMe).setVisibility(View.VISIBLE);
        findViewById(addOneYou).setVisibility(View.VISIBLE);
        findViewById(loseOneMe).setVisibility(View.VISIBLE);
        findViewById(loseOneYou).setVisibility(View.VISIBLE);
        meScore = 20;
        displayMeScore(meScore);
    }

    public void resetYou(View v) {
        findViewById(addOneMe).setVisibility(View.VISIBLE);
        findViewById(addOneYou).setVisibility(View.VISIBLE);
        findViewById(loseOneMe).setVisibility(View.VISIBLE);
        findViewById(loseOneYou).setVisibility(View.VISIBLE);
        youScore = 20;
        displayYouScore(youScore);
    }

    public void resetAll(View v) {
        meScore = 20;
        youScore = 20;
        meRound = 0;
        youRound = 0;
        displayMeScore(meScore);
        displayYouScore(youScore);
        findViewById(addOneMe).setVisibility(View.VISIBLE);
        findViewById(addOneYou).setVisibility(View.VISIBLE);
        findViewById(loseOneMe).setVisibility(View.VISIBLE);
        findViewById(loseOneYou).setVisibility(View.VISIBLE);
        findViewById(tick1me).setVisibility(View.INVISIBLE);
        findViewById(tick2me).setVisibility(View.INVISIBLE);
        findViewById(tick1you).setVisibility(View.INVISIBLE);
        findViewById(tick2you).setVisibility(View.INVISIBLE);
        findViewById(iWin).setVisibility(View.INVISIBLE);
        findViewById(iLoose).setVisibility(View.INVISIBLE);
        findViewById(youWin).setVisibility(View.INVISIBLE);
        findViewById(youLoose).setVisibility(View.INVISIBLE);
    }
}