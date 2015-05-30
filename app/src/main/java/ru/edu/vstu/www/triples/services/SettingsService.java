package ru.edu.vstu.www.triples.services;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import ru.edu.vstu.www.triples.database.DataBaseHelper;
import ru.edu.vstu.www.triples.database.DataBaseService;

public class SettingsService {

    private DataBaseHelper dbHelper;
    SQLiteDatabase base;

    private boolean isEasyLevel;
    private boolean soundOn;

    public SettingsService (Context context) {
        dbHelper = new DataBaseHelper(context);
        base = dbHelper.getWritableDatabase();
        loadSettings();
    }

    /**
     * загрузить настройки из базы
     */
    public void loadSettings() {
        soundOn = DataBaseService.isSoundOn(base);
        isEasyLevel = DataBaseService.isEasyLevel(base);
    }

    /**
     * @return Простой уровень
     */
    public boolean isEasyLevel() {
        return isEasyLevel;
    }

    /**
     * @return Сложный уровень
     */
    public boolean isInvolvedLevel() {
        return !isEasyLevel;
    }

    /**
     * Установить уровень
     * @param isEasyLevel true = простой
     */
    public void setLevel(boolean isEasyLevel) {
        this.isEasyLevel = isEasyLevel;
        DataBaseService.saveLevelSettings(base, isEasyLevel);
    }

    /**
     * @return насройки звука
     */
    public boolean getSoundOn() {
        return soundOn;
    }

    /**
     * Сохранить настройки звука
     * @param soundOn настройка
     */
    public void setSoundOn(boolean soundOn) {
        this.soundOn = soundOn;
        DataBaseService.saveSoundSettings(base, soundOn);
    }

    /**
     * закрыть соединение с базой
     */
    public void close() {
        dbHelper.close();
    }
}
