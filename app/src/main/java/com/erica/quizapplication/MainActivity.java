package com.erica.quizapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    public static final String filename = "LEVEL_DATA";
    SharedPreferences levelData;
    // int level;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        levelData = getSharedPreferences(filename, 0);

        btn1 = (Button) findViewById(R.id.startButton);

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, LevelTwoActivity.class);
                Bundle intent2 = new Bundle();
                //intent2.putInt("level", level); //Your score
                intent.putExtras(intent2); //Put your score to your next Intent
                startActivity(intent);
                finish();

                SharedPreferences.Editor editor = levelData.edit();
                editor.putInt("currentLevel", 1);
                editor.putInt("unlockedLevels", 1);
                editor.commit();
            }
        });


    }

}
