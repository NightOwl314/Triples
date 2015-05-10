package ru.edu.vstu.www.triples.entities;

public class GameField {
    private Card[][] array = new Card[Constants.ROW_COUNT][Constants.COLUMN_COUNT];

    /**
     * @return Массив из карт игрового поля
     */
    public Card[][] getArray() {
        return array;
    }

    /**
     * @param array Массив из карт игрового поля
     */
    public void setArray(Card[][] array) {
        this.array = array;
    }

    /**
     * Заменить карту игрового поля
     * @param row строка
     * @param column колонка
     * @param card карта
     */
    public void setCard(int row, int column, Card card) {
        array[row][column] = card;
    }

    /**
     * Возвращает карту по индексам
     * @param row строка
     * @param column столбец
     * @return карта
     */
    public Card getCard(int row, int column) {
        return array[row][column];
    }
}
