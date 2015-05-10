package ru.edu.vstu.www.triples.entities;

public class GameFieldService {

    private CardService cardService = new CardService();

    /**
     * Генерируем новое игровое поле
     * @return поле
     */
    public GameField generateNewGameField() {
        GameField field = new GameField();
        Card[][] array = field.getArray();
        int len = 0;
        for (int i = 0; i < Constants.ROW_COUNT; i++) {
            for (int j = 0; j < Constants.COLUMN_COUNT; j++) {
                boolean add = false;
                do {
                    Card card = cardService.getRandomCard();
                    if(!containArrayLengthCard(array, len, card)) {
                        array[i][j] = card;
                        len++;
                        add = true;
                    }
                } while (!add);
            }
        }
        return field;
    }

    /**
     * Содержит ли массив указанной длины данную карту
     * @param arr массив
     * @param len длина
     * @param card карта
     * @return true, если содержит
     */
    private boolean containArrayLengthCard(Card[][] arr, int len, Card card) {
        if (len == 0) {
            return false;
        }

        int k = 0;
        while (k < len) {
            if (card.equals(arr[k/3][k%3])) {
                return true;
            }
            k++;
        }

        return false;
    }

    /**
     * Содержится ли на поле указанная карта
     * @param arr массив поля
     * @param card карта
     * @return true, если содержится
     */
    public boolean containArrayCard (Card[][] arr, Card card) {
        for (int i = 0; i < Constants.ROW_COUNT; i++) {
            for (int j = 0; j < Constants.COLUMN_COUNT; j++) {
                if (card.equals(arr[i][j])) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Есть ли в массиве хоть одна тройка
     * @param arr массив
     * @return true, если содержит
     */
    public boolean hasArrayOneTriple(Card[][] arr) {
        int n = 0;
        while (n < Constants.COUNT_CARDS - 2) {
            Card c1 = arr[n/3][n%3];
            if (c1 == null) {
                n++;
                continue;
            }
            int m = n + 1;
            while (m < Constants.COUNT_CARDS - 1) {
                Card c2 = arr[m/3][m%3];
                if (c2 == null) {
                    m++;
                    continue;
                }
                int k = m + 1;
                while (k < Constants.COUNT_CARDS) {
                    Card c3 = arr[k/3][k%3];
                    if (c3 == null) {
                        k++;
                        continue;
                    }

                    if (cardService.isTriple(c1, c2, c3)) {
                        return true;
                    }

                    k++;
                }
                m++;
            }
            n++;
        }
        return false;
    }
}
