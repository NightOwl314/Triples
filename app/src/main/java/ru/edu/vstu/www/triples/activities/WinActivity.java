package ru.edu.vstu.www.triples.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ru.edu.vstu.www.triples.R;
import ru.edu.vstu.www.triples.services.Constants;

public class WinActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        Button btnMenu = (Button) findViewById(R.id.homeFromWinBtn);
        Button btnRecords = (Button) findViewById(R.id.recordFromWinBtn);
        btnMenu.setOnClickListener(this);
        btnRecords.setOnClickListener(this);

        TextView tvScore = (TextView) findViewById(R.id.textScore);
        TextView tvTime = (TextView) findViewById(R.id.textTime);

        Intent intent = getIntent();
        String score = intent.getStringExtra(Constants.PARAM_SCORE);
        String time = intent.getStringExtra(Constants.PARAM_TIME);

        tvScore.setText(score);
        tvTime.setText(time);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.homeFromWinBtn:
                Log.d(Constants.LOG_TAG, "WinActivity: Нажата кнопка Menu");
                intent = new Intent(this, MainMenuActivity.class);
                startActivity(intent);
                this.finish();
                break;
            case R.id.recordFromWinBtn:
                Log.d(Constants.LOG_TAG, "WinActivity: Нажата кнопка Рекорды");
                intent = new Intent(this, RecordsActivity.class);
                startActivity(intent);
                this.finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Log.d(Constants.LOG_TAG, "WinActivity: onBackPressed()");
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
        this.finish();
    }
}
