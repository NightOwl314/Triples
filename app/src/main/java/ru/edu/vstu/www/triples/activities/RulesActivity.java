package ru.edu.vstu.www.triples.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ru.edu.vstu.www.triples.R;

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

    private Button back;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        back = (Button) findViewById(R.id.backFromRulesBtn);
        back.setOnClickListener(this);

        text = (TextView) findViewById(R.id.rulesText);
        text.setText(RULES);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public void onClick(View v) {

    }
}
