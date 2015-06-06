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

    /**
     * Значение признака по символьному обозначению
     * @param label Символьное обозначение признака
     * @return признак
     */
    public static DibForm valueOfLabel (String label) {
        switch (label) {
            case "c":
                return CIRCLE;
            case "t":
                return TRIANGLE;
            default:
                return RHOMBUS;
        }
    }
}
