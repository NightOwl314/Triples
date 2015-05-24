package ru.edu.vstu.www.triples.entities;

public class Coordinate {
    private final int row;
    private final int column;

    public Coordinate(int i, int j) {
        row = i;
        column = j;
    }

    /**
     * @return номер строки
     */
    public int getRow() {
        return row;
    }

    /**
     * @return номер стобца
     */
    public int getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return "" + row + column;
    }
}
