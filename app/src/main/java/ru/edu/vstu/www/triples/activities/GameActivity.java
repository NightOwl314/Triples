package ru.edu.vstu.www.triples.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.edu.vstu.www.triples.R;
import ru.edu.vstu.www.triples.entities.coordinates.Coordinate;
import ru.edu.vstu.www.triples.entities.dibs.Dib;
import ru.edu.vstu.www.triples.entities.field.GameField;
import ru.edu.vstu.www.triples.entities.field.GameFieldService;
import ru.edu.vstu.www.triples.services.Constants;
import ru.edu.vstu.www.triples.services.SettingsService;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private GameFieldService fs = new GameFieldService();
    private SettingsService ss;
    private SharedPreferences sPref;
    private Map<String, Button> synonymBtn;

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
    private TextView score;

    private SoundPool sp;
    private int sPin;
    private int sUnpin;
    private int sRight;
    private int sWrong;
    private int sWin;

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
        setContentView(R.layout.activity_game);
        ss = new SettingsService(this);
        ss.loadSettings();
        sp = new SoundPool(Constants.MAX_STREAMS, AudioManager.STREAM_MUSIC, 0);
        sPref = getSharedPreferences("TriplesPreferences", MODE_PRIVATE);
        findViewElements();
        loadGame();
    }

    private void play(int sound) {
        if (sound > 0)
            sp.play(sound, 1, 1, 1, 0, 1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public void onBackPressed() {
        Log.d(Constants.LOG_TAG, "GameActivity: onBackPressed()");
        gotoBack();
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.menuGameBtn:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка Menu");
                gotoBack();
                break;
            case R.id.rulesGameBtn:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка Правила");
                saveGame(true);
                intent = new Intent(this, RulesActivity.class);
                intent.putExtra(Constants.PARAM_FROM_MENU, false);
                startActivity(intent);
                break;
            case R.id.settingsGameBtn:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка Настройки");
                saveGame(true);
                intent = new Intent(this, SettingsActivity.class);
                intent.putExtra(Constants.PARAM_FROM_MENU, false);
                startActivity(intent);
                break;
            case R.id.dib00:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib00 с фишкой " + field.getDib(0, 0).toString());
                onClickDib(0, 0, dib00);
                break;
            case R.id.dib01:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib01 с фишкой " + field.getDib(0, 1).toString());
                onClickDib(0, 1, dib01);
                break;
            case R.id.dib02:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib02 с фишкой " + field.getDib(0, 2).toString());
                onClickDib(0, 2, dib02);
                break;
            case R.id.dib10:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib10 с фишкой " + field.getDib(1, 0).toString());
                onClickDib(1, 0, dib10);
                break;
            case R.id.dib11:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib11 с фишкой " + field.getDib(1, 1).toString());
                onClickDib(1, 1, dib11);
                break;
            case R.id.dib12:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib12 с фишкой " + field.getDib(1, 2).toString());
                onClickDib(1, 2, dib12);
                break;
            case R.id.dib20:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib20 с фишкой " + field.getDib(2, 0).toString());
                onClickDib(2, 0, dib20);
                break;
            case R.id.dib21:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib21 с фишкой " + field.getDib(2, 1).toString());
                onClickDib(2, 1, dib21);
                break;
            case R.id.dib22:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib22 с фишкой " + field.getDib(2, 2).toString());
                onClickDib(2, 2, dib22);
                break;
            case R.id.dib30:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib30 с фишкой " + field.getDib(3, 0).toString());
                onClickDib(3, 0, dib30);
                break;
            case R.id.dib31:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib31 с фишкой " + field.getDib(3, 1).toString());
                onClickDib(3, 1, dib31);
                break;
            case R.id.dib32:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib32 с фишкой " + field.getDib(3, 2).toString());
                onClickDib(3, 2, dib32);
                break;
            case R.id.dib40:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib40 с фишкой " + field.getDib(4, 0).toString());
                onClickDib(4, 0, dib40);
                break;
            case R.id.dib41:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib41 с фишкой " + field.getDib(4, 1).toString());
                onClickDib(4, 1, dib41);
                break;
            case R.id.dib42:
                Log.d(Constants.LOG_TAG, "GameActivity: Нажата кнопка dib42 с фишкой " + field.getDib(4, 2).toString());
                onClickDib(4, 2, dib42);
                break;
        }
    }

    private void onClickDib(int iIn, int jIn, Button button) {
        if (field.isSelectDib(iIn, jIn)) {
            if (ss.getSoundOn()) {
                play(sUnpin);
            }
            //если данная фишка выбрана, то убираем выделение
            field.delCoordinate(iIn, jIn);
            button.setBackgroundResource(fs.getBackgroundForDib(field.getDib(iIn, jIn).getName()));
            return;
        }

        field.addCoordinate(iIn, jIn);
        if (field.getCoordinates().size() < Constants.COUNT_DIBS_IN_TRIPLES) {
            if (ss.getSoundOn()) {
                play(sPin);
            }
            //если еще не выбраны три карты, то просто выделяем фишку
            button.setBackgroundResource(fs.getBackgroundForDib("s_" + field.getDib(iIn, jIn).getName()));
            return;
        }

        //если выбраны три карты
        if (fs.validateTriples(field.getArray(), field.getCoordinates())) {
            //это правильная тройка
            field.incScore();

            if (field.getScore() >= Constants.WIN_SCORE) {
                if (ss.getSoundOn()) {
                    play(sWin);
                }

                Date time = new Date(Calendar.getInstance().getTimeInMillis() - field.getStartTime().getTimeInMillis());
                fs.saveResultGame(this, time, field.getScore());
                SimpleDateFormat formatTime = new SimpleDateFormat(Constants.FORMAT_TIME);
                Intent intent = new Intent(this, WinActivity.class);
                intent.putExtra(Constants.PARAM_SCORE, field.getScoreStr());
                intent.putExtra(Constants.PARAM_TIME, formatTime.format(time));
                startActivity(intent);
                this.finish();
                return;
            }

            if (ss.getSoundOn()) {
                play(sRight);
            }
            List<Dib> dibs = new ArrayList<>();
            for (Coordinate coordinate: field.getCoordinates()) {
                int i = coordinate.getRow();
                int j = coordinate.getColumn();
                dibs.add(field.getDib(i, j));
            }
            fs.generateTriples(field.getArray(), field.getCoordinates(), dibs);
            drawAgainField(true);
        } else {
            if (ss.getSoundOn()) {
                play(sWrong);
            }
            if (ss.isInvolvedLevel()) {
                field.decScore();
            }
            drawAgainField(false);
        }
    }

    private void drawAgainField(boolean needAnim) {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.scale);
        for (Coordinate coordinate: field.getCoordinates()) {
            Button btn = synonymBtn.get(coordinate.toString());
            if (btn == null) {
                refreshBtn();
                btn = synonymBtn.get(coordinate.toString());
            }
            int i = coordinate.getRow();
            int j = coordinate.getColumn();
            btn.setBackgroundResource(fs.getBackgroundForDib(field.getDib(i, j).getName()));
            if (needAnim) {
                btn.startAnimation(anim);
            }
        }

        score.setText(field.getScoreStr());
        field.clearCoordinates();
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

        sPin = sp.load(this, R.raw.pin, 1);
        sUnpin = sp.load(this, R.raw.unpin, 1);
        sRight = sp.load(this, R.raw.right, 1);
        sWrong = sp.load(this, R.raw.wrong, 1);
        sWin = sp.load(this, R.raw.win, 1);
    }

    private void fillGameField() {
        Log.d(Constants.LOG_TAG, "GameActivity: Заполняем фишки и счет");
        dib00.setBackgroundResource(fs.getBackgroundForDib(field.getDib(0,0).getName()));
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

    private void gotoBack() {
        Date time = new Date(Calendar.getInstance().getTimeInMillis() - field.getStartTime().getTimeInMillis());
        fs.saveResultGame(this, time, field.getScore());
        saveGame(false);
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
        this.finish();
    }

    private void loadGame() {
        boolean save = sPref.getBoolean(Constants.SAVE, false);
        if (save) {
            field = new GameField();

            field.setScore(sPref.getInt(Constants.SAVE_SCORE, 0));

            Calendar time = Calendar.getInstance();
            time.setTimeInMillis(sPref.getLong(Constants.SAVE_TIME, Calendar.getInstance().getTimeInMillis()));
            field.setStartTime(time);

            field.setDib(0, 0, new Dib(sPref.getString(Constants.SAVE_DIB00, "")));
            field.setDib(0, 1, new Dib(sPref.getString(Constants.SAVE_DIB01, "")));
            field.setDib(0, 2, new Dib(sPref.getString(Constants.SAVE_DIB02, "")));
            field.setDib(1, 0, new Dib(sPref.getString(Constants.SAVE_DIB10, "")));
            field.setDib(1, 1, new Dib(sPref.getString(Constants.SAVE_DIB11, "")));
            field.setDib(1, 2, new Dib(sPref.getString(Constants.SAVE_DIB12, "")));
            field.setDib(2, 0, new Dib(sPref.getString(Constants.SAVE_DIB20, "")));
            field.setDib(2, 1, new Dib(sPref.getString(Constants.SAVE_DIB21, "")));
            field.setDib(2, 2, new Dib(sPref.getString(Constants.SAVE_DIB22, "")));
            field.setDib(3, 0, new Dib(sPref.getString(Constants.SAVE_DIB30, "")));
            field.setDib(3, 1, new Dib(sPref.getString(Constants.SAVE_DIB31, "")));
            field.setDib(3, 2, new Dib(sPref.getString(Constants.SAVE_DIB32, "")));
            field.setDib(4, 0, new Dib(sPref.getString(Constants.SAVE_DIB40, "")));
            field.setDib(4, 1, new Dib(sPref.getString(Constants.SAVE_DIB41, "")));
            field.setDib(4, 2, new Dib(sPref.getString(Constants.SAVE_DIB42, "")));

            SharedPreferences.Editor editor = sPref.edit();
            editor.putBoolean(Constants.SAVE, false);
            editor.commit();
        } else {
            field = fs.generateNewGameField();
        }
        fillGameField();
    }

    private void saveGame(boolean save) {
        SharedPreferences.Editor editor = sPref.edit();
        editor.putBoolean(Constants.SAVE, save);
        if (save) {
            editor.putString(Constants.SAVE_DIB00, field.getDib(0, 0).getName());
            editor.putString(Constants.SAVE_DIB01, field.getDib(0, 1).getName());
            editor.putString(Constants.SAVE_DIB02, field.getDib(0, 2).getName());
            editor.putString(Constants.SAVE_DIB10, field.getDib(1, 0).getName());
            editor.putString(Constants.SAVE_DIB11, field.getDib(1, 1).getName());
            editor.putString(Constants.SAVE_DIB12, field.getDib(1, 2).getName());
            editor.putString(Constants.SAVE_DIB20, field.getDib(2, 0).getName());
            editor.putString(Constants.SAVE_DIB21, field.getDib(2, 1).getName());
            editor.putString(Constants.SAVE_DIB22, field.getDib(2, 2).getName());
            editor.putString(Constants.SAVE_DIB30, field.getDib(3, 0).getName());
            editor.putString(Constants.SAVE_DIB31, field.getDib(3, 1).getName());
            editor.putString(Constants.SAVE_DIB32, field.getDib(3, 2).getName());
            editor.putString(Constants.SAVE_DIB40, field.getDib(4, 0).getName());
            editor.putString(Constants.SAVE_DIB41, field.getDib(4, 1).getName());
            editor.putString(Constants.SAVE_DIB42, field.getDib(4, 2).getName());
            editor.putInt(Constants.SAVE_SCORE, field.getScore());
            editor.putLong(Constants.SAVE_TIME, field.getStartTime().getTimeInMillis());
        }
        editor.commit();
    }
}
