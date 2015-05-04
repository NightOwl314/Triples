package ru.edu.vstu.www.triples.entities;

public enum CardColor {
    RED("r"),    //красный
    BLUE("b"),   //синий
    YELLOW("y"); //желтый

    private final String label;

    private CardColor(String label) {
        this.label = label;
    }

    /**
     * @return Символьное обозначение признака
     */
    public String getLabel() {
        return label;
    }
}
