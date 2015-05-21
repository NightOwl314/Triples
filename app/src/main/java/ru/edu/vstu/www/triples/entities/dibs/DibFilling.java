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
}
