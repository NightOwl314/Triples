package ru.edu.vstu.www.triples.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import ru.edu.vstu.www.triples.R;
import ru.edu.vstu.www.triples.entities.Constants;
import ru.edu.vstu.www.triples.entities.GameField;
import ru.edu.vstu.www.triples.entities.GameFieldService;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private GameFieldService fieldService = new GameFieldService();

    private GameField field;

    private RelativeLayout gameLayout;
    private Button menuBtn;
    private Button rulesBtn;
    private Button settingsBtn;

    private Button dib00;
    private Button dib01;
    private Button dib02;
    private Button dib10;
    private Button dib11;
    private Button dib12;
    private Button dib20;
    private Button dib21;
    private Button dib22;
    private Button dib30;
    private Button dib31;
    private Button dib32;
    private Button dib40;
    private Button dib41;
    private Button dib42;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(Constants.LOG_TAG, "GameActivity: onCreate()");
        setContentView(R.layout.activity_game);
        findViewElements();
        field = fieldService.generateNewGameField();
        fillGameField();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    /**
     * Обработка аппаратной кнопли BACK
     */
    @Override
    public void onBackPressed() {
        Log.d(Constants.LOG_TAG, "GameActivity: onBackPressed()");
    }

    @Override
    public void onClick(View v) {
        Log.d(Constants.LOG_TAG, "GameActivity: onClick()");
        switch (v.getId()) {
            case R.id.menuGameBtn:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка Menu");
                break;
            case R.id.rulesGameBtn:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка Правила");
                break;
            case R.id.settingsGameBtn:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка Настройки");
                break;
            case R.id.dib00:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib00");
                onClickDib(0, 0);
                break;
            case R.id.dib01:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib01");
                onClickDib(0, 1);
                break;
            case R.id.dib02:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib02");
                onClickDib(0, 2);
                break;
            case R.id.dib10:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib10");
                onClickDib(1, 0);
                break;
            case R.id.dib11:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib11");
                onClickDib(1, 1);
                break;
            case R.id.dib12:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib12");
                onClickDib(1, 2);
                break;
            case R.id.dib20:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib20");
                onClickDib(2, 0);
                break;
            case R.id.dib21:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib21");
                onClickDib(2, 1);
                break;
            case R.id.dib22:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib22");
                onClickDib(2, 2);
                break;
            case R.id.dib30:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib30");
                onClickDib(3, 0);
                break;
            case R.id.dib31:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib31");
                onClickDib(3, 1);
                break;
            case R.id.dib32:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib32");
                onClickDib(3, 2);
                break;
            case R.id.dib40:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib40");
                onClickDib(4, 0);
                break;
            case R.id.dib41:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib41");
                onClickDib(4, 1);
                break;
            case R.id.dib42:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib42");
                onClickDib(4, 2);
                break;
        }
    }

    private void onClickDib(int i, int j) {
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(Constants.LOG_TAG, "GameActivity: onStart()");
    }

    @Override
    protected void onRestart() {
        super.onStart();
        Log.d(Constants.LOG_TAG, "GameActivity: onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(Constants.LOG_TAG, "GameActivity: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(Constants.LOG_TAG, "GameActivity: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(Constants.LOG_TAG, "GameActivity: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(Constants.LOG_TAG, "GameActivity: onDestroy()");
    }

    private void findViewElements() {
        Log.d(Constants.LOG_TAG, "GameActivity: Находим кнопки меню и игрового поля");
        gameLayout = (RelativeLayout) findViewById(R.id.gameLayout);
        menuBtn = (Button) findViewById(R.id.menuGameBtn);
        rulesBtn = (Button) findViewById(R.id.rulesGameBtn);
        settingsBtn = (Button) findViewById(R.id.settingsGameBtn);
        menuBtn.setOnClickListener(this);
        rulesBtn.setOnClickListener(this);
        settingsBtn.setOnClickListener(this);

        dib00 = (Button) findViewById(R.id.dib00);
        dib01 = (Button) findViewById(R.id.dib01);
        dib02 = (Button) findViewById(R.id.dib02);
        dib10 = (Button) findViewById(R.id.dib10);
        dib11 = (Button) findViewById(R.id.dib11);
        dib12 = (Button) findViewById(R.id.dib12);
        dib20 = (Button) findViewById(R.id.dib20);
        dib21 = (Button) findViewById(R.id.dib21);
        dib22 = (Button) findViewById(R.id.dib22);
        dib30 = (Button) findViewById(R.id.dib30);
        dib31 = (Button) findViewById(R.id.dib31);
        dib32 = (Button) findViewById(R.id.dib32);
        dib40 = (Button) findViewById(R.id.dib40);
        dib41 = (Button) findViewById(R.id.dib41);
        dib42 = (Button) findViewById(R.id.dib42);
        dib00.setOnClickListener(this);
        dib01.setOnClickListener(this);
        dib02.setOnClickListener(this);
        dib10.setOnClickListener(this);
        dib11.setOnClickListener(this);
        dib12.setOnClickListener(this);
        dib20.setOnClickListener(this);
        dib21.setOnClickListener(this);
        dib22.setOnClickListener(this);
        dib30.setOnClickListener(this);
        dib31.setOnClickListener(this);
        dib32.setOnClickListener(this);
        dib40.setOnClickListener(this);
        dib41.setOnClickListener(this);
        dib42.setOnClickListener(this);
    }

    private void fillGameField() {
        Log.d(Constants.LOG_TAG, "GameActivity: Заполняем фишки");
    }
}
