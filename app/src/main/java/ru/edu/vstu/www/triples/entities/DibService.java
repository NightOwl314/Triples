package ru.edu.vstu.www.triples.entities;

import java.util.Random;

public class DibService {
    Random rand = new Random();

    /**
     * @return случайный цвет элементов на фишке
     */
    public DibColor getRandomColor() {
        DibColor color = DibColor.RED;
        int i = rand.nextInt(100);
        switch (i % 3) {
            case 0:
                color = DibColor.RED;
                break;
            case 1:
                color =  DibColor.BLUE;
                break;
            case 2:
                color = DibColor.YELLOW;
                break;
        }
        return color;
    }

    /**
     * @return случайное количество элементов на фишке
     */
    public DibNumber getRandomNumber() {
        DibNumber number = DibNumber.ONE;
        int i = rand.nextInt(100);
        switch (i % 3) {
            case 0:
                number = DibNumber.ONE;
                break;
            case 1:
                number = DibNumber.TWO;
                break;
            case 2:
                number = DibNumber.THREE;
                break;
        }
        return number;
    }

    /**
     * @return случайная форма элементов на фишке
     */
    public DibForm getRandomForm() {
        DibForm form = DibForm.CIRCLE;
        int i = rand.nextInt(100);
        switch (i % 3) {
            case 0:
                form = DibForm.CIRCLE;
                break;
            case 1:
                form =  DibForm.TRIANGLE;
                break;
            case 2:
                form = DibForm.RHOMBUS;
                break;
        }
        return form;
    }

    /**
     * @return случайное заполнение элементов на фишке
     */
    public DibFilling getRandomFilling() {
        DibFilling filling = DibFilling.FILLED;
        int i = rand.nextInt(100);
        switch (i % 3) {
            case 0:
                filling = DibFilling.FILLED;
                break;
            case 1:
                filling =  DibFilling.SHADED;
                break;
            case 2:
                filling = DibFilling.EMPTY;
                break;
        }
        return filling;
    }

    /**
     * @return новая фишка с рамдомными характеристиками
     */
    public Dib getRandomDib() {
        return new Dib(getRandomColor(), getRandomNumber(), getRandomForm(), getRandomFilling());
    }

    /**
     * Являются ли указанные цвета правильными для тройки
     * Или все одинаковы или все разные
     * @param c1 цвет первой фишки тройки
     * @param c2 цвет второй фишки тройки
     * @param c3 цвет третьей фишки тройки
     * @return правильно/ не правильно (true/false)
     */
    public boolean isRightColors(DibColor c1, DibColor c2, DibColor c3) {
        //c1 == c2 && c2 == c3 --> c1 == c3 указание всех трех - избыточное условие
        return c1 == c2 && c2 == c3 || c1 != c2 && c2 != c3 && c1 != c3;
    }

    /**
     * Являются ли указанные номера правильными для тройки
     * Или все одинаковы или все разные
     * @param n1 номер первой фишки тройки
     * @param n2 номер второй фишки тройки
     * @param n3 номер третьей фишки тройки
     * @return правильно/ не правильно (true/false)
     */
    public boolean isRightNumber(DibNumber n1, DibNumber n2, DibNumber n3) {
        return n1 == n2 && n2 == n3 || n1 != n2 && n2 != n3 && n1 != n3;
    }

    /**
     * Являются ли указанные формы правильными для тройки
     * Или все одинаковы или все разные
     * @param f1 форма первой фишки тройки
     * @param f2 форма второй фишки тройки
     * @param f3 форма третьей фишки тройки
     * @return правильно/ не правильно (true/false)
     */
    public boolean isRightForm(DibForm f1, DibForm f2, DibForm f3) {
        return f1 == f2 && f2 == f3 || f1 != f2 && f2 != f3 && f1 != f3;
    }

    /**
     * Являются ли указанные заполнения правильными для тройки
     * Или все одинаковы или все разные
     * @param f1 заполнение первой фишки тройки
     * @param f2 заполнение второй фишки тройки
     * @param f3 заполнение третьей фишки тройки
     * @return правильно/ не правильно (true/false)
     */
    public boolean isRightFilling(DibFilling f1, DibFilling f2, DibFilling f3) {
        return f1 == f2 && f2 == f3 || f1 != f2 && f2 != f3 && f1 != f3;
    }

    /**
     * Является ли указанные три фишки тройкой?
     * Каждый признак или одинаков на все фишках, или различается на всех фишках
     * @param dib1 первая фишка
     * @param dib2 вторая фишка
     * @param dib3 третья фишка
     * @return правильно/ не правильно (true/false)
     */
    public boolean isTriple(Dib dib1, Dib dib2, Dib dib3) {
        return isRightColors(dib1.getColor(), dib2.getColor(), dib3.getColor()) &&
                isRightNumber(dib1.getNumber(), dib2.getNumber(), dib3.getNumber()) &&
                isRightForm(dib1.getForm(), dib2.getForm(), dib3.getForm()) &&
                isRightFilling(dib1.getFilling(), dib2.getFilling(), dib3.getFilling());
    }
}
