package ru.edu.vstu.www.triples.entities;

public enum CardFilling {
    FILLED("f"), //закрашенный
    SHADED("s"), //захтрихованный
    EMPTY("e");  //пустой

    private final String label;

    private CardFilling(String label) {
        this.label = label;
    }

    /**
     * @return Символьное обозначение признака
     */
    public String getLabel() {
        return label;
    }
}
