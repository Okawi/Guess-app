package com.example.testing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class easy extends AppCompatActivity {

    int n;
    int attempts = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.easy);
    }

    public void randomNumberGenerator(){
        Random rand = new  Random();
        n = rand.nextInt(10)+1;
    }

    public void guess(View view) {
        randomNumberGenerator();
        EditText guess = (EditText) findViewById(R.id.guess);
        int guessInt = Integer.parseInt(guess.getText().toString());


        if (n != guessInt) {

            attempts--;
            TextView result = (TextView) findViewById(R.id.result);
            result.setText("Try Again!");
            TextView attempView = (TextView) findViewById(R.id.AttemptsView);
            attempView.setText("Attempts: " + attempts);

        }
        if (attempts == 0) {
            Intent i = new Intent(this, StatsScreen.class);
            String score = Integer.toString(attempts);
            i.putExtra("Status", score);
            String name = getIntent().getStringExtra("Value");
            i.putExtra("Value", name);
            startActivity(i);

        }

        if (n == guessInt) {
            Intent z = new Intent(this, StatsScreen.class);
            String score = Integer.toString(attempts);
            z.putExtra("Status", score);
            String name = getIntent().getStringExtra("Value");
            z.putExtra("Value", name);
            startActivity(z);
        }

    }


}