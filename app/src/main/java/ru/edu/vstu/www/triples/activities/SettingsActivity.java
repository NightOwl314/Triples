package ru.edu.vstu.www.triples.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import ru.edu.vstu.www.triples.R;
import ru.edu.vstu.www.triples.services.Constants;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean fromMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(Constants.LOG_TAG, "SettingsActivity: onCreate()");
        setContentView(R.layout.activity_settings);
        Button back = (Button) findViewById(R.id.backFromSettingsBtn);
        back.setOnClickListener(this);

        Intent intent = getIntent();
        fromMenu = intent.getBooleanExtra(Constants.PARAM_FROM_MENU, true);
        if (fromMenu) {
            Log.d(Constants.LOG_TAG, "SettingsActivity: пришли из меню");
        } else {
            Log.d(Constants.LOG_TAG, "SettingsActivity: пришли из игры");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backFromSettingsBtn:
                Log.d(Constants.LOG_TAG, "SettingsActivity: Нажата кнопка Назад");
                gotoBack();
                break;

        }
    }

    @Override
    public void onBackPressed() {
        Log.d(Constants.LOG_TAG, "SettingsActivity: onBackPressed()");
        gotoBack();
    }

    private void gotoBack() {
        if (fromMenu) {
            Log.d(Constants.LOG_TAG, "SettingsActivity: возвращаемся в меню меню");
            Intent intent = new Intent(this, MainMenuActivity.class);
            startActivity(intent);
        } else {
            Log.d(Constants.LOG_TAG, "SettingsActivity: возвращаемся в игру");
            Intent intent = new Intent(this, GameActivity.class);
            startActivity(intent);
        }
    }
}
