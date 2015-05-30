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


public class MainMenuActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Log.d(Constants.LOG_TAG, "MainMenuActivity: Находим пункты главного меню");
        Button playBtn = (Button) findViewById(R.id.playBtn);
        Button rulesBtn = (Button) findViewById(R.id.rulesBtn);
        Button settingsBtn = (Button) findViewById(R.id.settingsBtn);
        Button recordBtn = (Button) findViewById(R.id.recordBtn);
        Button infoBtn = (Button) findViewById(R.id.infoBtn);

        playBtn.setOnClickListener(this);
        rulesBtn.setOnClickListener(this);
        settingsBtn.setOnClickListener(this);
        recordBtn.setOnClickListener(this);
        infoBtn.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.playBtn:
                Log.d(Constants.LOG_TAG, "MainMenuActivity: Нажата кнопка Играть");
                intent = new Intent(this, GameActivity.class);
                startActivity(intent);
                this.finish();
                break;
            case R.id.rulesBtn:
                Log.d(Constants.LOG_TAG, "MainMenuActivity: Нажата кнопка Правила");
                intent = new Intent(this, RulesActivity.class);
                intent.putExtra(Constants.PARAM_FROM_MENU, true);
                startActivity(intent);
                this.finish();
                break;
            case R.id.settingsBtn:
                Log.d(Constants.LOG_TAG, "MainMenuActivity: Нажата кнопка Настройки");
                intent = new Intent(this, SettingsActivity.class);
                intent.putExtra(Constants.PARAM_FROM_MENU, true);
                startActivity(intent);
                this.finish();
                break;
            case R.id.recordBtn:
                Log.d(Constants.LOG_TAG, "MainMenuActivity: Нажата кнопка Рекорды");
                intent = new Intent(this, RecordsActivity.class);
                startActivity(intent);
                this.finish();
                break;
            case R.id.infoBtn:
                Log.d(Constants.LOG_TAG, "MainMenuActivity: Нажата кнопка Инфо");
                intent = new Intent(this, InfoActivity.class);
                startActivity(intent);
                this.finish();
                break;
        }
    }

    /**
     * Обработка аппаратной кнопли BACK
     */
    @Override
    public void onBackPressed() {
        Log.d(Constants.LOG_TAG, "MainMenuActivity: onBackPressed()");
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
