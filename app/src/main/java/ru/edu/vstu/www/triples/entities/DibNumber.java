package ru.edu.vstu.www.triples.entities;

public enum DibNumber {
    ONE("1"),   //одна фигура
    TWO("2"),   //две фигуры
    THREE("3"); //три фигуры

    private final String label;

    private DibNumber(String label) {
        this.label = label;
    }

    /**
     * @return Символьное обозначение признака
     */
    public String getLabel() {
        return label;
    }
}
