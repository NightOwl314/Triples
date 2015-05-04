package ru.edu.vstu.www.triples.entities;

public class Card {
    private final CardColor color;           //цвет фигур на карте
    private final CardNumber number;         //количество фигур
    private final CardForm form;             //форма фигур
    private final CardFilling filling;       //заполнение фигур

    private final String picture;            //название изображения

    public Card (CardColor color, CardNumber number, CardForm form, CardFilling filling) {
        this.color = color;
        this.number = number;
        this.form = form;
        this.filling = filling;

        this.picture = this.color.getLabel() +
                       this.number.getLabel() +
                       this.form.getLabel() +
                       this.filling.getLabel();
    }

    public CardColor getColor() {
        return color;
    }

    public CardNumber getNumber() {
        return number;
    }

    public CardForm getForm() {
        return form;
    }

    public CardFilling getFilling() {
        return filling;
    }

    public String getPicture() {
        return picture;
    }
}
