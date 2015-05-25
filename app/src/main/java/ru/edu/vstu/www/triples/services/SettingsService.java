package ru.edu.vstu.www.triples.services;

public class SettingsService {
    private boolean isEasyLevel = true;

    /**
     * @return Простой уровень
     */
    public boolean isEasyLevel() {
        return isEasyLevel;
    }

    /**
     * Установить уровень простым
     * @param isEasyLevel true = простой
     */
    public void setEasyLevel(boolean isEasyLevel) {
        this.isEasyLevel = isEasyLevel;
    }

    /**
     * @return Сложный уровень
     */
    public boolean isInvolvedLevel() {
        return !isEasyLevel();
    }

    /**
     * Установить уровень сложным
     * @param isInvolvedLevel true = сложный
     */
    public void setInvolvedLevel(boolean isInvolvedLevel) {
        setEasyLevel(!isInvolvedLevel);
    }

}
