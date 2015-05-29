package ru.edu.vstu.www.triples.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ru.edu.vstu.www.triples.entities.records.Record;

public class DataBaseService {

    private static final String TABLE_RECORDS = "records";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_TIME = "time";
    private static final String COLUMN_SCORE = "score";
    private static final String TABLE_SETTINGS = "settings";
    private static final String COLUMN_VALUE = "value";

    private static final String SELECTION_SETTINGS = "key like ?";
    private static final String KEY_SOUND = "sound";
    private static final String KEY_LEVEL = "level";
    private static final String VALUE_SOUND_ON = "on";
    private static final String VALUE_SOUND_OFF = "off";
    private static final String VALUE_LEVEL_EASY = "easy";
    private static final String VALUE_LEVEL_INVOLVED = "involved";


    /**
     * Возвращает настройку звука из базы
     * @param base соединение
     * @return true, звук включен
     */
    public static boolean isSoundOn (SQLiteDatabase base) {
        boolean soundOn = true;
        String[] columns = {COLUMN_VALUE};
        String[] arg = {KEY_SOUND};
        Cursor cursor = null;
        try {
            cursor = base.query(TABLE_SETTINGS, columns, SELECTION_SETTINGS, arg, null, null, null);
            if (cursor != null && cursor.moveToFirst()) {
                String value = cursor.getString(cursor.getColumnIndex(COLUMN_VALUE));
                if (VALUE_SOUND_OFF.equals(value)) {
                    soundOn = false;
                }
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return soundOn;
    }

    /**
     * Сохраняет настройки звука
     * @param base соединение к базе
     * @param soundOn если true, то звук включен
     */
    public static void saveSoundSettings(SQLiteDatabase base, boolean soundOn) {
        ContentValues cv = new ContentValues();
        if (soundOn) {
            cv.put(COLUMN_VALUE, VALUE_SOUND_ON);
        } else {
            cv.put(COLUMN_VALUE, VALUE_SOUND_OFF);
        }
        String[] arg = {KEY_SOUND};
        base.update(TABLE_SETTINGS, cv, SELECTION_SETTINGS, arg);
    }

    /**
     * Возвращает настройку звука из базы
     * @param base соединение
     * @return true. если уровень простой
     */
    public static boolean isEasyLevel(SQLiteDatabase base) {
        boolean easyLevel = true;
        String[] columns = {COLUMN_VALUE};
        String[] arg = {KEY_LEVEL};
        Cursor cursor = null;
        try {
            cursor = base.query(TABLE_SETTINGS, columns, SELECTION_SETTINGS, arg, null, null, null);
            if (cursor != null && cursor.moveToFirst()) {
                String value = cursor.getString(cursor.getColumnIndex(COLUMN_VALUE));
                if (VALUE_LEVEL_INVOLVED.equals(value)) {
                    easyLevel = false;
                }
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return easyLevel;
    }

    /**
     * Сохраняет настройки уровня
     * @param base соединение к базе
     * @param easyLevel если true,то уровень простой
     */
    public static void saveLevelSettings(SQLiteDatabase base, boolean easyLevel) {
        ContentValues cv = new ContentValues();
        if (easyLevel) {
            cv.put(COLUMN_VALUE, VALUE_LEVEL_EASY);
        } else {
            cv.put(COLUMN_VALUE, VALUE_LEVEL_INVOLVED);
        }
        String[] arg = {KEY_LEVEL};
        base.update(TABLE_SETTINGS, cv, SELECTION_SETTINGS, arg);
    }

    /**
     * Сохраняет рекорд в базу
     * @param base соединение к базе
     * @param record рекорд
     * @return id рекорда
     */
    public static long saveRecord(SQLiteDatabase base, Record record) {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_DATE, record.getDate());
        cv.put(COLUMN_TIME, record.getTime());
        cv.put(COLUMN_SCORE, record.getScore());
        return base.insert(TABLE_RECORDS, null, cv);
    }

    /**
     * Возвращает список всех рекордов в базе, отсортированных по очкам, времени и дате
     * @param base соединение к базе
     * @return список рекордов, может быть пустым
     */
    public static List<Record> getAllRecords(SQLiteDatabase base) {
        List<Record> list = new ArrayList<>();
        String orderBy = COLUMN_SCORE + " desc, " + COLUMN_TIME + ", " + COLUMN_DATE;
        Cursor cursor = null;
        try {
            cursor = base.query(TABLE_RECORDS, null, null, null, null, null, orderBy);
            if (cursor != null && cursor.moveToFirst()) {
                int idDateColumn = cursor.getColumnIndex(COLUMN_DATE);
                int idTimeColumn = cursor.getColumnIndex(COLUMN_TIME);
                int idScoreColumn = cursor.getColumnIndex(COLUMN_SCORE);
                do {
                    String date = cursor.getString(idDateColumn);
                    String time = cursor.getString(idTimeColumn);
                    int score = cursor.getInt(idScoreColumn);
                    Record record = new Record(date, time, score);
                    list.add(record);
                } while (cursor.moveToNext());
            }

        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return list;
    }
}
