package ru.edu.vstu.www.triples.entities;

import java.util.Random;

public class CardService {

    /**
     * @return случайный цвет элементов на карте
     */
    public static CardColor getRandomColor() {
        CardColor color = CardColor.RED;
        Random rand = new Random();
        int i = rand.nextInt(100);
        switch (i % 3) {
            case 0:
                color = CardColor.RED;
                break;
            case 1:
                color =  CardColor.BLUE;
                break;
            case 2:
                color = CardColor.YELLOW;
                break;
        }
        return color;
    }

    /**
     * @return случайное количество элементов на карте
     */
    public static CardNumber getRandomNumber() {
        CardNumber number = CardNumber.ONE;
        Random rand = new Random();
        int i = rand.nextInt(100);
        switch (i % 3) {
            case 0:
                number = CardNumber.ONE;
                break;
            case 1:
                number = CardNumber.TWO;
                break;
            case 2:
                number = CardNumber.THREE;
                break;
        }
        return number;
    }

    /**
     * @return случайная форма элементов на карте
     */
    public static CardForm getRandomForm() {
        CardForm form = CardForm.CIRCLE;
        Random rand = new Random();
        int i = rand.nextInt(100);
        switch (i % 3) {
            case 0:
                form = CardForm.CIRCLE;
                break;
            case 1:
                form =  CardForm.TRIANGLE;
                break;
            case 2:
                form = CardForm.RHOMBUS;
                break;
        }
        return form;
    }

    /**
     * @return случайное заполнение элементов на карте
     */
    public static CardFilling getRandomFilling() {
        CardFilling filling = CardFilling.FILLED;
        Random rand = new Random();
        int i = rand.nextInt(100);
        switch (i % 3) {
            case 0:
                filling = CardFilling.FILLED;
                break;
            case 1:
                filling =  CardFilling.SHADED;
                break;
            case 2:
                filling = CardFilling.EMPTY;
                break;
        }
        return filling;
    }

    /**
     * @return новая карта с рамдомными характеристиками
     */
    public static Card getRandomCard() {
        return new Card(getRandomColor(), getRandomNumber(), getRandomForm(), getRandomFilling());
    }

    /**
     * Являются ли указанные цвета правильными для тройки
     * Или все одинаковы или все разные
     * @param c1 цвет первой карты тройки
     * @param c2 цвет второй карты тройки
     * @param c3 цвет третьей карты тройки
     * @return правильно/ не правильно (true/false)
     */
    public static boolean isRightColors(CardColor c1, CardColor c2, CardColor c3) {
        //c1 == c2 && c2 == c3 --> c1 == c3 указание всех трех - избыточное условие
        return c1 == c2 && c2 == c3 || c1 != c2 && c2 != c3 && c1 != c3;
    }

    /**
     * Являются ли указанные номера правильными для тройки
     * Или все одинаковы или все разные
     * @param n1 номер первой карты тройки
     * @param n2 номер второй карты тройки
     * @param n3 номер третьей карты тройки
     * @return правильно/ не правильно (true/false)
     */
    public static boolean isRightNumber(CardNumber n1, CardNumber n2, CardNumber n3) {
        return n1 == n2 && n2 == n3 || n1 != n2 && n2 != n3 && n1 != n3;
    }

    /**
     * Являются ли указанные формы правильными для тройки
     * Или все одинаковы или все разные
     * @param f1 форма первой карты тройки
     * @param f2 форма второй карты тройки
     * @param f3 форма третьей карты тройки
     * @return правильно/ не правильно (true/false)
     */
    public static boolean isRightForm(CardForm f1, CardForm f2, CardForm f3) {
        return f1 == f2 && f2 == f3 || f1 != f2 && f2 != f3 && f1 != f3;
    }

    /**
     * Являются ли указанные заполнения правильными для тройки
     * Или все одинаковы или все разные
     * @param f1 заполнение первой карты тройки
     * @param f2 заполнение второй карты тройки
     * @param f3 заполнение третьей карты тройки
     * @return правильно/ не правильно (true/false)
     */
    public static boolean isRightFilling(CardFilling f1, CardFilling f2, CardFilling f3) {
        return f1 == f2 && f2 == f3 || f1 != f2 && f2 != f3 && f1 != f3;
    }

    /**
     * Является ли указанные три карты тройкой?
     * Каждый признак или одинаков на все картах, или различается на всех картах
     * @param card1 первая карта
     * @param card2 вторая карта
     * @param card3 третья карта
     * @return правильно/ не правильно (true/false)
     */
    public static boolean isTriple(Card card1, Card card2, Card card3) {
        return isRightColors(card1.getColor(), card2.getColor(), card3.getColor()) &&
                isRightNumber(card1.getNumber(), card2.getNumber(), card3.getNumber()) &&
                isRightForm(card1.getForm(), card2.getForm(), card3.getForm()) &&
                isRightFilling(card1.getFilling(), card2.getFilling(), card3.getFilling());
    }
}
