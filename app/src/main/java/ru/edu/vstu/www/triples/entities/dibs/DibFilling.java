package ru.edu.vstu.www.triples.entities.dibs;

public enum DibFilling {
    FILLED("f"), //закрашенный
    SHADED("s"), //заштрихованный
    EMPTY("e");  //пустой

    private final String label;

    private DibFilling(String label) {
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
    public static DibFilling valueOfLabel (String label) {
        switch (label) {
            case "f":
                return FILLED;
            case "s":
                return SHADED;
            default:
                return EMPTY;
        }
    }
}
