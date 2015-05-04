package ru.edu.vstu.www.triples.entities;

public enum CardForm {
    CIRCLE("c"),   //круг
    TRIANGLE("t"), //треугольник
    RHOMBUS("r");  //ромб

    private final String label;

    private CardForm(String label) {
        this.label = label;
    }

    /**
     * @return Символьное обозначение признака
     */
    public String getLabel() {
        return label;
    }
}
