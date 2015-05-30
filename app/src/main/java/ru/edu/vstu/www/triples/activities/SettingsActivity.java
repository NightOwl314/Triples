package ru.edu.vstu.www.triples.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import ru.edu.vstu.www.triples.R;
import ru.edu.vstu.www.triples.services.Constants;
import ru.edu.vstu.www.triples.services.SettingsService;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean fromMenu;
    private SettingsService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        service = new SettingsService(this);

        if(service.isEasyLevel()) {
            easyLevel.setChecked(true);
        } else {
            involvedLevel.setChecked(true);
        }

        if(service.getSoundOn()) {
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
                service.setLevel(true);
                break;
            case R.id.radioLevelInvolved:
                Log.d(Constants.LOG_TAG, "SettingsActivity: выбран сложный уровень");
                service.setLevel(false);
                break;
            case R.id.radioSoundOn:
                Log.d(Constants.LOG_TAG, "SettingsActivity: звук включен");
                service.setSoundOn(true);
                break;
            case R.id.radioSoundOff:
                Log.d(Constants.LOG_TAG, "SettingsActivity: звук выключен");
                service.setSoundOn(false);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Log.d(Constants.LOG_TAG, "SettingsActivity: onBackPressed()");
        gotoBack();
    }

    private void gotoBack() {
        service.close();
        Intent intent;
        if (fromMenu) {
            Log.d(Constants.LOG_TAG, "SettingsActivity: возвращаемся в меню");
            intent = new Intent(this, MainMenuActivity.class);
        } else {
            Log.d(Constants.LOG_TAG, "SettingsActivity: возвращаемся в игру");
            intent = new Intent(this, GameActivity.class);
        }
        startActivity(intent);
        this.finish();
    }
}
