package ru.edu.vstu.www.triples.entities.dibs;

public class Dib {
    private final DibColor color;           //цвет фигур на фишке
    private final DibNumber number;         //количество фигур
    private final DibForm form;             //форма фигур
    private final DibFilling filling;       //заполнение фигур

    private final String name;            //название изображения: цвет+количество+форма+заполнение

    public Dib(DibColor color, DibNumber number, DibForm form, DibFilling filling) {
        this.color = color;
        this.number = number;
        this.form = form;
        this.filling = filling;

        this.name = this.color.getLabel() +
                       this.number.getLabel() +
                       this.form.getLabel() +
                       this.filling.getLabel();
    }

    public DibColor getColor() {
        return color;
    }

    public DibNumber getNumber() {
        return number;
    }

    public DibForm getForm() {
        return form;
    }

    public DibFilling getFilling() {
        return filling;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (!(o instanceof Dib)) {
            return false;
        }
        Dib dib = (Dib) o;
        return this.color == dib.getColor() &&
                this.number == dib.getNumber() &&
                this.form == dib.getForm() &&
                this.filling == dib.getFilling();
    }

    @Override
    public String toString() {
        return name;
    }
}
