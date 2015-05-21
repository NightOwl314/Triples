package ru.edu.vstu.www.triples.entities.dibs;

public enum DibForm {
    CIRCLE("c"),   //круг
    TRIANGLE("t"), //треугольник
    RHOMBUS("r");  //ромб

    private final String label;

    private DibForm(String label) {
        this.label = label;
    }

    /**
     * @return Символьное обозначение признака
     */
    public String getLabel() {
        return label;
    }
}
