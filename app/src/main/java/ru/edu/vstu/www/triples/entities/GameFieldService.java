package ru.edu.vstu.www.triples.entities;

public class GameFieldService {

    private DibService dibService = new DibService();

    /**
     * Генерируем новое игровое поле
     * @return поле
     */
    public GameField generateNewGameField() {
        GameField field = new GameField();
        Dib[][] array = field.getArray();
        int len = 0;
        for (int i = 0; i < Constants.ROW_COUNT; i++) {
            for (int j = 0; j < Constants.COLUMN_COUNT; j++) {
                boolean add = false;
                do {
                    Dib dib = dibService.getRandomDib();
                    if(!containArrayLengthDib(array, len, dib)) {
                        array[i][j] = dib;
                        len++;
                        add = true;
                    }
                } while (!add);
            }
        }
        return field;
    }

    /**
     * Содержит ли массив указанной длины данную фишку
     * @param arr массив
     * @param len длина
     * @param dib фишка
     * @return true, если содержит
     */
    private boolean containArrayLengthDib(Dib[][] arr, int len, Dib dib) {
        if (len == 0) {
            return false;
        }

        int k = 0;
        while (k < len) {
            if (dib.equals(arr[k/3][k%3])) {
                return true;
            }
            k++;
        }

        return false;
    }

    /**
     * Содержится ли на поле указанная фишка
     * @param arr массив поля
     * @param dib фишка
     * @return true, если содержится
     */
    public boolean containArrayDib (Dib[][] arr, Dib dib) {
        for (int i = 0; i < Constants.ROW_COUNT; i++) {
            for (int j = 0; j < Constants.COLUMN_COUNT; j++) {
                if (dib.equals(arr[i][j])) {
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
    public boolean hasArrayOneTriple(Dib[][] arr) {
        int n = 0;
        while (n < Constants.COUNT_DIBS - 2) {
            Dib c1 = arr[n/3][n%3];
            if (c1 == null) {
                n++;
                continue;
            }
            int m = n + 1;
            while (m < Constants.COUNT_DIBS - 1) {
                Dib c2 = arr[m/3][m%3];
                if (c2 == null) {
                    m++;
                    continue;
                }
                int k = m + 1;
                while (k < Constants.COUNT_DIBS) {
                    Dib c3 = arr[k/3][k%3];
                    if (c3 == null) {
                        k++;
                        continue;
                    }

                    if (dibService.isTriple(c1, c2, c3)) {
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
