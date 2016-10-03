package com.erica.quizapplication;

/**
 * Created by schif_000 on 2/10/2016.
 */
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends Activity {

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView textResult = (TextView) findViewById(R.id.textResult);
        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");
        textResult.setText("Your score is " + score + "/7");
    }

    public void restart(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}