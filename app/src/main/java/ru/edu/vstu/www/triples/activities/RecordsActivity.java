package ru.edu.vstu.www.triples.activities;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import ru.edu.vstu.www.triples.R;
import ru.edu.vstu.www.triples.database.DataBaseHelper;
import ru.edu.vstu.www.triples.database.DataBaseService;
import ru.edu.vstu.www.triples.entities.records.Record;
import ru.edu.vstu.www.triples.services.Constants;

public class RecordsActivity extends AppCompatActivity implements View.OnClickListener {

    private DataBaseHelper dbHelper;
    int[] colors = new int[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        colors[0] = Color.parseColor("#F0FFFF");
        colors[1] = Color.parseColor("#98FB98");

        setContentView(R.layout.activity_records);
        Button backFromInfoBtn = (Button) findViewById(R.id.backFromRecordsBtn);
        backFromInfoBtn.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linLayout);
        dbHelper = new DataBaseHelper(this);
        SQLiteDatabase base = dbHelper.getWritableDatabase();
        List<Record> list = DataBaseService.getAllRecords(base);
        LayoutInflater ltInflater = getLayoutInflater();
        int i = 0;
        for (Record record: list) {
            i++;
            View item = ltInflater.inflate(R.layout.record, linearLayout, false);

            TextView tvOrderId = (TextView) item.findViewById(R.id.tvOrderId);
            tvOrderId.setText(i + "");

            TextView tvDate = (TextView) item.findViewById(R.id.tvDate);
            tvDate.setText(record.getDate());

            TextView tvTime = (TextView) item.findViewById(R.id.tvTime);
            tvTime.setText(record.getTime());

            TextView tvScore = (TextView) item.findViewById(R.id.tvScore);
            tvScore.setText(record.getScore() + "");

            item.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
            item.setBackgroundColor(colors[i % 2]);
            linearLayout.addView(item);
        }
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
        if (dbHelper != null) {
            dbHelper.close();
        }
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
        this.finish();
    }
}
