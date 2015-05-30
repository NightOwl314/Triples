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

public class RulesActivity extends AppCompatActivity implements View.OnClickListener {

    private final String RULES =
            "В игре необходимо находить правильные наборы из трёх фишек - тройки. "+
            "Каждая фишка имеет четыре признака:\n" +
            " - количество фигур (одна, две, три);\n" +
            " - тип символов (круг, треугольник, ромб);\n" +
            " - цвет (красный, синий, желтый);\n" +
            " - заполнение (пустое, заштрихованное, закрашенное).\n" +
            "Каждая из 81 фишки уникальна. Тройка состоит из трёх фишек, у которых каждый из признаков, " +
            "рассмотренных по отдельности, либо полностью совпадают, либо полностью различаются на всех " +
            "трёх фишках. Все признаки должны полностью соответствовать этому правилу.\n" +
            "Таким образом, количество фигур должно быть или одинаковым на всех трёх фишках, или разными " +
            "на всех трёх фишках, цвет должен быть или одинаковым на всех трёх фищках, или разными на всех " +
            "трёх фишках, и так далее…\n" +
            "За каждую правильную тройку начисляется 3 очка. Игра выиграна, если удалось набрать 333 очка.\n" +
            "В игре предусмотрены 2 уровня игры:\n" +
            " - простой (ошибки баллы не снимаются);\n" +
            " - сложный (ошибку снимается 6 баллов).";

    private boolean fromMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        Button back = (Button) findViewById(R.id.backFromRulesBtn);
        back.setOnClickListener(this);
        TextView text = (TextView) findViewById(R.id.rulesText);
        text.setText(RULES);

        Intent intent = getIntent();
        fromMenu = intent.getBooleanExtra(Constants.PARAM_FROM_MENU, true);
        if (fromMenu) {
            Log.d(Constants.LOG_TAG, "RulesActivity: пришли из меню");
        } else {
            Log.d(Constants.LOG_TAG, "RulesActivity: пришли из игры");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.backFromRulesBtn) {
            Log.d(Constants.LOG_TAG, "RulesActivity: Нажата кнопка Назад");
            gotoBack();
        }
    }

    @Override
    public void onBackPressed() {
        Log.d(Constants.LOG_TAG, "RulesActivity: onBackPressed()");
        gotoBack();
    }

    private void gotoBack() {
        Intent intent;
        if (fromMenu) {
            Log.d(Constants.LOG_TAG, "RulesActivity: возвращаемся в меню меню");
            intent = new Intent(this, MainMenuActivity.class);
        } else {
            Log.d(Constants.LOG_TAG, "RulesActivity: возвращаемся в игру");
            intent = new Intent(this, GameActivity.class);
        }
        startActivity(intent);
        this.finish();
    }
}
