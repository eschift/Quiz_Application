package com.erica.quizapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by schif_000 on 4/10/2016.
 */
public class GameOver extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

    }

    public void exitApp(){
        finish();
        System.exit(0);
    }

    public void returnHome(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
