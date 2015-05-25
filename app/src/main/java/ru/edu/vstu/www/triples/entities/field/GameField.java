package ru.edu.vstu.www.triples.entities.field;

import java.util.ArrayList;
import java.util.List;

import ru.edu.vstu.www.triples.services.Constants;
import ru.edu.vstu.www.triples.entities.coordinates.Coordinate;
import ru.edu.vstu.www.triples.entities.dibs.Dib;

public class GameField {
    private Dib[][] array;
    private List<Coordinate> coordinates;  //коордитаты выбранных фишек
    private int score;

    public GameField() {
        array = new Dib[Constants.ROW_COUNT][Constants.COLUMN_COUNT];
        coordinates = new ArrayList<>();
        score = 0;
    }

    /**
     * @return Массив из фишек игрового поля
     */
    public Dib[][] getArray() {
        return array;
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

    /**
     * @return список координат выделенных фишек
     */
    public List<Coordinate> getCoordinates() {
        return coordinates;
    }


    /**
     * Добавляем координаты выделенной фишки
     * @param iIn координата строки фишки
     * @param jIn координата столбца фишки
     */
    public void addCoordinate(int iIn, int jIn) {
        coordinates.add(new Coordinate(iIn, jIn));
    }

    /**
     * Удаляем координаты фишки из списка выбранных
     * @param iIn координата строки фишки
     * @param jIn координата столбца фишки
     */
    public void delCoordinate (int iIn, int jIn) {

        for(Coordinate coordinate: coordinates) {
            if (coordinate.getRow()== iIn && coordinate.getColumn() == jIn) {
                coordinates.remove(coordinate);
                return;
            }
        }
    }

    /**
     * очищаем список выбранных координат
     */
    public void clearCoordinates() {
        coordinates.clear();
    }

    /**
     * Выбранна ли уже данная фишка
     * @param iIn координата строки фишки
     * @param jIn координата стобца фишки
     * @return true, если выбрана
     */
    public boolean isSelectDib(int iIn, int jIn) {
        for (Coordinate coordinate: coordinates) {
            if (coordinate.getRow()== iIn && coordinate.getColumn() == jIn) {
                return true;
            }
        }

        return false;
    }

    /**
     * @return текущий счет
     */
    public String getScoreStr() {
        return "" + score;
    }

    /**
     * @return текущий счет
     */
    public int getScore() {
        return score;
    }

    /**
     * увеличить счет
     */
    public void incScore() {
        score += Constants.PLUS_SCORE;
    }

    /**
     * уменьшить счет
     */
    public void decScore() {
        score -= Constants.MINUS_SCORE;
    }
}
