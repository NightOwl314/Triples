package ru.edu.vstu.www.triples.entities.dibs;

public enum DibColor {
    RED("r"),    //красный
    BLUE("b"),   //синий
    YELLOW("y"); //желтый

    private final String label;

    private DibColor(String label) {
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
    public static DibColor valueOfLabel (String label) {
        switch (label) {
            case "r":
                return RED;
            case "b":
                return BLUE;
            default:
                return YELLOW;
        }
    }
}
