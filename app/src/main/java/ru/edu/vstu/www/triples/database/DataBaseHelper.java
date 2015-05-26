package ru.edu.vstu.www.triples.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import ru.edu.vstu.www.triples.services.Constants;

public class DataBaseHelper extends SQLiteOpenHelper {

    public DataBaseHelper(Context context) {
        super(context, "triplesDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(Constants.LOG_TAG, "Создание базы данных");
        db.execSQL("create table records ("
                + "id integer primary key autoincrement not null,"
                + "date text not null,"
                + "time text not null,"
                + "score integer not null" + ");");

        db.execSQL("create table settings ("
                + "id integer primary key autoincrement not null,"
                + "key text not null,"
                + "value text" + ");");

        db.execSQL("insert into settings (key, value) values ('sound', 'on');");
        db.execSQL("insert into settings (key, value) values ('level', 'easy');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
