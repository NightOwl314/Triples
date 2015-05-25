package ru.edu.vstu.www.triples.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.edu.vstu.www.triples.R;
import ru.edu.vstu.www.triples.services.Constants;
import ru.edu.vstu.www.triples.entities.coordinates.Coordinate;
import ru.edu.vstu.www.triples.services.SettingsService;
import ru.edu.vstu.www.triples.entities.field.GameField;
import ru.edu.vstu.www.triples.entities.field.GameFieldService;
import ru.edu.vstu.www.triples.entities.dibs.Dib;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private GameFieldService fs = new GameFieldService();
    private SettingsService ss = new SettingsService();

    private GameField field;

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

    private Map<String, Button> synonymBtn;

    private TextView score;

    private void refreshBtn() {
        Map<String, Button> map = new HashMap<>();
        map.put("00", dib00);
        map.put("01", dib01);
        map.put("02", dib02);
        map.put("10", dib10);
        map.put("11", dib11);
        map.put("12", dib12);
        map.put("20", dib20);
        map.put("21", dib21);
        map.put("22", dib22);
        map.put("30", dib30);
        map.put("31", dib31);
        map.put("32", dib32);
        map.put("40", dib40);
        map.put("41", dib41);
        map.put("42", dib42);
        synonymBtn = map;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(Constants.LOG_TAG, "GameActivity: onCreate()");
        setContentView(R.layout.activity_game);
        findViewElements();
        field = fs.generateNewGameField();
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
        fs.saveResultGame();
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        Log.d(Constants.LOG_TAG, "GameActivity: onClick()");
        Intent intent;
        switch (v.getId()) {
            case R.id.menuGameBtn:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка Menu");
                fs.saveResultGame();
                intent = new Intent(this, MainMenuActivity.class);
                startActivity(intent);
                break;
            case R.id.rulesGameBtn:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка Правила");
                //TODO
                intent = new Intent(this, RulesActivity.class);
                startActivity(intent);
                break;
            case R.id.settingsGameBtn:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка Настройки");
                //TODO
                intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                break;
            case R.id.dib00:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib00");
                onClickDib(0, 0, dib00);
                break;
            case R.id.dib01:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib01");
                onClickDib(0, 1, dib01);
                break;
            case R.id.dib02:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib02");
                onClickDib(0, 2, dib02);
                break;
            case R.id.dib10:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib10");
                onClickDib(1, 0, dib10);
                break;
            case R.id.dib11:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib11");
                onClickDib(1, 1, dib11);
                break;
            case R.id.dib12:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib12");
                onClickDib(1, 2, dib12);
                break;
            case R.id.dib20:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib20");
                onClickDib(2, 0, dib20);
                break;
            case R.id.dib21:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib21");
                onClickDib(2, 1, dib21);
                break;
            case R.id.dib22:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib22");
                onClickDib(2, 2, dib22);
                break;
            case R.id.dib30:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib30");
                onClickDib(3, 0, dib30);
                break;
            case R.id.dib31:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib31");
                onClickDib(3, 1, dib31);
                break;
            case R.id.dib32:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib32");
                onClickDib(3, 2, dib32);
                break;
            case R.id.dib40:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib40");
                onClickDib(4, 0, dib40);
                break;
            case R.id.dib41:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib41");
                onClickDib(4, 1, dib41);
                break;
            case R.id.dib42:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib42");
                onClickDib(4, 2, dib42);
                break;
        }
    }

    private void onClickDib(int iIn, int jIn, Button button) {
        if (field.isSelectDib(iIn, jIn)) {
            //если данная фишка выбрана, то убираем выделение
            field.delCoordinate(iIn, jIn);
            button.setBackgroundResource(fs.getBackgroundForDib(field.getDib(iIn, jIn).getName()));
            return;
        }

        button.setBackgroundResource(fs.getBackgroundForDib("s_" + field.getDib(iIn, jIn).getName()));
        field.addCoordinate(iIn, jIn);
        if (field.getCoordinates().size() < Constants.COUNT_DIBS_IN_TRIPLES) {
            //если еще не выбраны три карты, то пока ничего проверять не надо
            return;
        }

        //если выбраны три карты
        if (fs.validateTriples(field.getArray(), field.getCoordinates())) {
            //это правильная тройка
            List<Dib> dibs = new ArrayList<>();
            for (Coordinate coordinate: field.getCoordinates()) {
                int i = coordinate.getRow();
                int j = coordinate.getColumn();
                dibs.add(field.getDib(i, j));
            }
            fs.generateTriples(field.getArray(), field.getCoordinates(), dibs);
            field.incScore();
        } else if (ss.isInvolvedLevel()) {
            field.decScore();
        }

        for (Coordinate coordinate: field.getCoordinates()) {
            Button btn = synonymBtn.get(coordinate.toString());
            if (btn == null) {
                refreshBtn();
                btn = synonymBtn.get(coordinate.toString());
            }
            int i = coordinate.getRow();
            int j = coordinate.getColumn();
            btn.setBackgroundResource(fs.getBackgroundForDib(field.getDib(i, j).getName()));
        }

        score.setText(field.getScoreStr());
        field.clearCoordinates();

        if (field.getScore() >= Constants.WIN_SCORE) {
            Intent intent = new Intent(this, WinActivity.class);
            startActivity(intent);
        }
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
        Button menuBtn = (Button) findViewById(R.id.menuGameBtn);
        Button rulesBtn = (Button) findViewById(R.id.rulesGameBtn);
        Button settingsBtn = (Button) findViewById(R.id.settingsGameBtn);
        menuBtn.setOnClickListener(this);
        rulesBtn.setOnClickListener(this);
        settingsBtn.setOnClickListener(this);
        score = (TextView) findViewById(R.id.score);

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

        refreshBtn();
    }

    private void fillGameField() {
        Log.d(Constants.LOG_TAG, "GameActivity: Заполняем фишки и счет");
        dib00.setBackgroundResource(fs.getBackgroundForDib(field.getDib(0, 0).getName()));
        dib01.setBackgroundResource(fs.getBackgroundForDib(field.getDib(0,1).getName()));
        dib02.setBackgroundResource(fs.getBackgroundForDib(field.getDib(0,2).getName()));
        dib10.setBackgroundResource(fs.getBackgroundForDib(field.getDib(1,0).getName()));
        dib11.setBackgroundResource(fs.getBackgroundForDib(field.getDib(1,1).getName()));
        dib12.setBackgroundResource(fs.getBackgroundForDib(field.getDib(1,2).getName()));
        dib20.setBackgroundResource(fs.getBackgroundForDib(field.getDib(2,0).getName()));
        dib21.setBackgroundResource(fs.getBackgroundForDib(field.getDib(2,1).getName()));
        dib22.setBackgroundResource(fs.getBackgroundForDib(field.getDib(2,2).getName()));
        dib30.setBackgroundResource(fs.getBackgroundForDib(field.getDib(3,0).getName()));
        dib31.setBackgroundResource(fs.getBackgroundForDib(field.getDib(3,1).getName()));
        dib32.setBackgroundResource(fs.getBackgroundForDib(field.getDib(3,2).getName()));
        dib40.setBackgroundResource(fs.getBackgroundForDib(field.getDib(4,0).getName()));
        dib41.setBackgroundResource(fs.getBackgroundForDib(field.getDib(4,1).getName()));
        dib42.setBackgroundResource(fs.getBackgroundForDib(field.getDib(4,2).getName()));

        score.setText(field.getScoreStr());
    }
}
