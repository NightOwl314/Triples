package ru.edu.vstu.www.triples.activities;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import ru.edu.vstu.www.triples.R;
import ru.edu.vstu.www.triples.database.DataBaseHelper;
import ru.edu.vstu.www.triples.database.DataBaseService;
import ru.edu.vstu.www.triples.services.Constants;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean fromMenu;
    private DataBaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(Constants.LOG_TAG, "SettingsActivity: onCreate()");
        setContentView(R.layout.activity_settings);
        Button back = (Button) findViewById(R.id.backFromSettingsBtn);
        RadioButton easyLevel = (RadioButton) findViewById(R.id.radioLevelEasy);
        RadioButton involvedLevel = (RadioButton) findViewById(R.id.radioLevelInvolved);
        RadioButton soundOn = (RadioButton) findViewById(R.id.radioSoundOn);
        RadioButton soundOff = (RadioButton) findViewById(R.id.radioSoundOff);
        back.setOnClickListener(this);
        easyLevel.setOnClickListener(this);
        involvedLevel.setOnClickListener(this);
        soundOn.setOnClickListener(this);
        soundOff.setOnClickListener(this);

        dbHelper = new DataBaseHelper(this);
        SQLiteDatabase base = dbHelper.getWritableDatabase();

        if(DataBaseService.isEasyLevel(base)) {
            easyLevel.setChecked(true);
        } else {
            involvedLevel.setChecked(true);
        }

        if(DataBaseService.isSoundOn(base)) {
            soundOn.setChecked(true);
        } else {
            soundOff.setChecked(true);
        }

        Intent intent = getIntent();
        fromMenu = intent.getBooleanExtra(Constants.PARAM_FROM_MENU, true);
        if (fromMenu) {
            Log.d(Constants.LOG_TAG, "SettingsActivity: пришли из меню");
        } else {
            Log.d(Constants.LOG_TAG, "SettingsActivity: пришли из игры");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(Constants.LOG_TAG, "SettingsActivity: onDestroy()");
        if (dbHelper != null) {
            dbHelper.close();
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
            case R.id.radioLevelEasy:
                Log.d(Constants.LOG_TAG, "SettingsActivity: выбран простой уровень");
                saveLevel(true);
                break;
            case R.id.radioLevelInvolved:
                Log.d(Constants.LOG_TAG, "SettingsActivity: выбран сложный уровень");
                saveLevel(false);
                break;
            case R.id.radioSoundOn:
                Log.d(Constants.LOG_TAG, "SettingsActivity: звук включен");
                saveSound(true);
                break;
            case R.id.radioSoundOff:
                Log.d(Constants.LOG_TAG, "SettingsActivity: звук выключен");
                saveSound(false);
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

    private void saveLevel(boolean isEasy) {
        SQLiteDatabase base = dbHelper.getWritableDatabase();
        DataBaseService.saveLevelSettings(base, isEasy);
    }

    private void saveSound(boolean soundOn) {
        SQLiteDatabase base = dbHelper.getWritableDatabase();
        DataBaseService.saveSoundSettings(base, soundOn);
    }
}
