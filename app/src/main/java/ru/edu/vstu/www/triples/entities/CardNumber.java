package ru.edu.vstu.www.triples.entities;

public enum CardNumber {
    ONE("1"),   //одна фигур
    TWO("2"),   //две финуры
    THREE("3"); //три фигуры

    private final String label;

    private CardNumber(String label) {
        this.label = label;
    }

    /**
     * @return Символьное обозначение признака
     */
    public String getLabel() {
        return label;
    }
}
