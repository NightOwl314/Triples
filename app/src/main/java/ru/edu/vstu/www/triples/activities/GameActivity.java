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

    private Button card00;
    private Button card01;
    private Button card02;
    private Button card10;
    private Button card11;
    private Button card12;
    private Button card20;
    private Button card21;
    private Button card22;
    private Button card30;
    private Button card31;
    private Button card32;
    private Button card40;
    private Button card41;
    private Button card42;

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
            case R.id.card00:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка card00");
                onClickCard(0, 0);
                break;
            case R.id.card01:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка card01");
                onClickCard(0, 1);
                break;
            case R.id.card02:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка card02");
                onClickCard(0, 2);
                break;
            case R.id.card10:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка card10");
                onClickCard(1, 0);
                break;
            case R.id.card11:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка card11");
                onClickCard(1, 1);
                break;
            case R.id.card12:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка card12");
                onClickCard(1, 2);
                break;
            case R.id.card20:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка card20");
                onClickCard(2, 0);
                break;
            case R.id.card21:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка card21");
                onClickCard(2, 1);
                break;
            case R.id.card22:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка card22");
                onClickCard(2, 2);
                break;
            case R.id.card30:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка card30");
                onClickCard(3, 0);
                break;
            case R.id.card31:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка card31");
                onClickCard(3, 1);
                break;
            case R.id.card32:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка card32");
                onClickCard(3, 2);
                break;
            case R.id.card40:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка card40");
                onClickCard(4, 0);
                break;
            case R.id.card41:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка card41");
                onClickCard(4, 1);
                break;
            case R.id.card42:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка card42");
                onClickCard(4, 2);
                break;
        }
    }

    private void onClickCard(int i, int j) {
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

        card00 = (Button) findViewById(R.id.card00);
        card01 = (Button) findViewById(R.id.card01);
        card02 = (Button) findViewById(R.id.card02);
        card10 = (Button) findViewById(R.id.card10);
        card11 = (Button) findViewById(R.id.card11);
        card12 = (Button) findViewById(R.id.card12);
        card20 = (Button) findViewById(R.id.card20);
        card21 = (Button) findViewById(R.id.card21);
        card22 = (Button) findViewById(R.id.card22);
        card30 = (Button) findViewById(R.id.card30);
        card31 = (Button) findViewById(R.id.card31);
        card32 = (Button) findViewById(R.id.card32);
        card40 = (Button) findViewById(R.id.card40);
        card41 = (Button) findViewById(R.id.card41);
        card42 = (Button) findViewById(R.id.card42);
        card00.setOnClickListener(this);
        card01.setOnClickListener(this);
        card02.setOnClickListener(this);
        card10.setOnClickListener(this);
        card11.setOnClickListener(this);
        card12.setOnClickListener(this);
        card20.setOnClickListener(this);
        card21.setOnClickListener(this);
        card22.setOnClickListener(this);
        card30.setOnClickListener(this);
        card31.setOnClickListener(this);
        card32.setOnClickListener(this);
        card40.setOnClickListener(this);
        card41.setOnClickListener(this);
        card42.setOnClickListener(this);
    }

    private void fillGameField() {
        Log.d(Constants.LOG_TAG, "GameActivity: Заполняем карты");
        gameLayout.setBackgroundResource(R.drawable.font_green);
    }
}
