package com.erica.quizapplication;

/**
 * Created by schif_000 on 2/10/2016.
 */
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;


public class ResultActivity extends Activity {

    public static final String filename = "LEVEL_DATA";
    SharedPreferences levelData;

    Button nextLevel;
    Button restart;
    int level;
    int thisLevel;
    int passedLevels;

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView textResult = (TextView) findViewById(R.id.textResult);

        levelData = getSharedPreferences(filename, 0);
        thisLevel = levelData.getInt("currentLevel", 0);
        passedLevels = levelData.getInt("unlockedLevels", 0);


        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");
        level = b.getInt("level");
        textResult.setText("Your score is " + score + "/7");
        level++;

        if(score == 7){
            nextLevel = (Button) findViewById(R.id.btn2);
            nextLevel.setVisibility(View.VISIBLE);
            restart = (Button) findViewById(R.id.btn);

            thisLevel++;
            passedLevels++;

            SharedPreferences.Editor editor = levelData.edit();
            editor.putInt("currentLevel", thisLevel);
            editor.putInt("unlockedLevels", passedLevels);
            editor.commit();
        }

    }

    public void nextLevel(View view){

        Intent intent2 = new Intent(this, LevelTwoActivity.class);
        Bundle b = new Bundle();
        // b.putInt("level", (level)); //Your score
        intent2.putExtras(b); //Put your score to your next Intent
        startActivity(intent2);
        finish();

    }

    public void restart(View view){
        Intent intent = new Intent(this, LevelTwoActivity.class);
        startActivity(intent);
    }

}