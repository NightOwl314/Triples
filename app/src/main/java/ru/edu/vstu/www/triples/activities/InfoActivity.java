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

public class InfoActivity extends AppCompatActivity implements View.OnClickListener {

    private final String INFO =
            "Данная игра разработана в качестве дипломной работы выпускницы\n" +
            " Вологодского Государственного Университета\n" +
            " Сахарновой Наталии.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Log.d(Constants.LOG_TAG, "InfoActivity: Находим кнопку и устанавливаем текст");
        ((TextView) findViewById(R.id.infoText)).setText(INFO);

        Button backFromInfoBtn = (Button) findViewById(R.id.backFromInfoBtn);
        backFromInfoBtn.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public void onBackPressed() {
        Log.d(Constants.LOG_TAG, "InfoActivity: onBackPressed()");
        gotoBack();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.backFromInfoBtn) {
            Log.d(Constants.LOG_TAG, "InfoActivity: Нажата кнопка Назад");
            gotoBack();
        }
    }

    private void gotoBack() {
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
        this.finish();
    }
}
