package ru.edu.vstu.www.triples.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DataBaseService {

    private static final String TABLE_RECORDS = "records";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_TIME = "time";
    private static final String COLUMN_SCORE = "score";
    private static final String TABLE_SETTINGS = "settings";
    private static final String COLUMN_KEY = "key";
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
        Cursor cursor = base.query(TABLE_SETTINGS, columns, SELECTION_SETTINGS, arg, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                String value = cursor.getString(cursor.getColumnIndex(COLUMN_VALUE));
                if (VALUE_SOUND_OFF.equals(value)) {
                    soundOn = false;
                }
            }
            cursor.close();
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
        Cursor cursor = base.query(TABLE_SETTINGS, columns, SELECTION_SETTINGS, arg, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                String value = cursor.getString(cursor.getColumnIndex(COLUMN_VALUE));
                if (VALUE_LEVEL_INVOLVED.equals(value)) {
                    easyLevel = false;
                }
            }
            cursor.close();
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
}
