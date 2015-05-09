package ru.edu.vstu.www.triples.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import ru.edu.vstu.www.triples.R;
import ru.edu.vstu.www.triples.entities.Constants;


public class MainMenuActivity extends AppCompatActivity implements View.OnClickListener {

    private Button playBtn;
    private Button rulesBtn;
    private Button settingsBtn;
    private Button recordBtn;
    private Button storeBtn;
    private Button exitBtn;
    private Button infoBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(Constants.LOG_TAG, "MainMenuActivity: onCreate()");
        setContentView(R.layout.activity_main_menu);

        Log.d(Constants.LOG_TAG, "MainMenuActivity: Находим пункты главного меню");
        playBtn = (Button) findViewById(R.id.playBtn);
        rulesBtn = (Button) findViewById(R.id.rulesBtn);
        settingsBtn = (Button) findViewById(R.id.settingsBtn);
        recordBtn = (Button) findViewById(R.id.recordBtn);
        storeBtn = (Button) findViewById(R.id.storeBtn);
        exitBtn = (Button) findViewById(R.id.exitBtn);
        infoBtn = (Button) findViewById(R.id.infoBtn);

        playBtn.setOnClickListener(this);
        rulesBtn.setOnClickListener(this);
        settingsBtn.setOnClickListener(this);
        recordBtn.setOnClickListener(this);
        storeBtn.setOnClickListener(this);
        exitBtn.setOnClickListener(this);
        infoBtn.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d(Constants.LOG_TAG, "MainMenuActivity: onCreateOptionsMenu()");
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(Constants.LOG_TAG, "MainMenuActivity: onOptionsItemSelected()");
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Log.d(Constants.LOG_TAG, "MainMenuActivity: onClick()");
        Intent intent;
        switch (v.getId()) {
            case R.id.playBtn:
                Log.d(Constants.LOG_TAG, "MainMenuActivity: Нажата кнопка Играть");
                intent = new Intent(this, GameActivity.class);
                startActivity(intent);
                break;
            case R.id.rulesBtn:
                Log.d(Constants.LOG_TAG, "MainMenuActivity: Нажата кнопка Правила");
                intent = new Intent(this, RulesActivity.class);
                startActivity(intent);
                break;
            case R.id.settingsBtn:
                Log.d(Constants.LOG_TAG, "MainMenuActivity: Нажата кнопка Настройки");
                intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                break;
            case R.id.recordBtn:
                Log.d(Constants.LOG_TAG, "MainMenuActivity: Нажата кнопка Рекорды");
                intent = new Intent(this, RecordsActivity.class);
                startActivity(intent);
                break;
            case R.id.storeBtn:
                Log.d(Constants.LOG_TAG, "MainMenuActivity: Нажата кнопка Магазин");
                intent = new Intent(this, StoreActivity.class);
                startActivity(intent);
                break;
            case R.id.exitBtn:
                Log.d(Constants.LOG_TAG, "MainMenuActivity: Нажата кнопка Выход");
                break;
            case R.id.infoBtn:
                Log.d(Constants.LOG_TAG, "MainMenuActivity: Нажата кнопка Инфо");
                intent = new Intent(this, InfoActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(Constants.LOG_TAG, "MainMenuActivity: onStart()");
    }

    @Override
    protected void onRestart() {
        super.onStart();
        Log.d(Constants.LOG_TAG, "MainMenuActivity: onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(Constants.LOG_TAG, "MainMenuActivity: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(Constants.LOG_TAG, "MainMenuActivity: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(Constants.LOG_TAG, "MainMenuActivity: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(Constants.LOG_TAG, "MainMenuActivity: onDestroy()");
    }
}
