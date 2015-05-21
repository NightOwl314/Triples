package ru.edu.vstu.www.triples.entities;

import ru.edu.vstu.www.triples.entities.dibs.Dib;

public class GameField {
    private Dib[][] array;

    public GameField() {
        array = new Dib[Constants.ROW_COUNT][Constants.COLUMN_COUNT];
    }

    /**
     * @return Массив из фишек игрового поля
     */
    public Dib[][] getArray() {
        return array;
    }

    /**
     * @param array Массив из фишек игрового поля
     */
    public void setArray(Dib[][] array) {
        this.array = array;
    }

    /**
     * Заменить фишку игрового поля
     * @param row строка
     * @param column колонка
     * @param dib фишка
     */
    public void setDib(int row, int column, Dib dib) {
        array[row][column] = dib;
    }

    /**
     * Возвращает фишку по индексам
     * @param row строка
     * @param column столбец
     * @return фишка
     */
    public Dib getDib(int row, int column) {
        return array[row][column];
    }
}
