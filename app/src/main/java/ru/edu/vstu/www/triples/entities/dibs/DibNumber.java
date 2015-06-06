package ru.edu.vstu.www.triples.entities.dibs;

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

    /**
     * Значение признака по символьному обозначению
     * @param label Символьное обозначение признака
     * @return признак
     */
    public static DibNumber valueOfLabel (String label) {
        switch (label) {
            case "1":
                return ONE;
            case "2":
                return TWO;
            default:
                return THREE;
        }
    }
}
