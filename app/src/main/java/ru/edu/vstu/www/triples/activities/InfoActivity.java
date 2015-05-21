package ru.edu.vstu.www.triples.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import ru.edu.vstu.www.triples.R;

public class InfoActivity extends AppCompatActivity implements View.OnClickListener {

    private final String INFO =
            "Данная игра разработана в качестве дипломной работы выпускницы\n" +
            " Вологодского Государственного Университета\n" +
            " Сахарновой Наталии.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ((TextView) findViewById(R.id.infoText)).setText(INFO);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public void onClick(View v) {

    }
}
