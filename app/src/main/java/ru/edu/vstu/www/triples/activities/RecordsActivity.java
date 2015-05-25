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

public class RecordsActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(Constants.LOG_TAG, "RecordsActivity: onCreate()");
        setContentView(R.layout.activity_records);
        Button backFromInfoBtn = (Button) findViewById(R.id.backFromRecordsBtn);
        backFromInfoBtn.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public void onBackPressed() {
        Log.d(Constants.LOG_TAG, "RecordsActivity: onBackPressed()");
        gotoBack();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.backFromRecordsBtn) {
            Log.d(Constants.LOG_TAG, "RecordsActivity: Нажата кнопка Назад");
            gotoBack();
        }
    }

    private void gotoBack() {
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }
}
