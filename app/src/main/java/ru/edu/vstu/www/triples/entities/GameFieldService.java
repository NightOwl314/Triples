package ru.edu.vstu.www.triples.entities;

import java.util.HashMap;
import java.util.Map;

import ru.edu.vstu.www.triples.R;
import ru.edu.vstu.www.triples.entities.dibs.Dib;
import ru.edu.vstu.www.triples.entities.dibs.DibService;

public class GameFieldService {

    private DibService dibService = new DibService();
    private final Map<String, Integer> backgrounds = fillDibsMap();


    private Map<String, Integer> fillDibsMap() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("r1ce", R.drawable.r1ce);
        map.put("r1cf", R.drawable.r1cf);
        map.put("r1cs", R.drawable.r1cs);
        map.put("r1te", R.drawable.r1te);
        map.put("r1tf", R.drawable.r1tf);
        map.put("r1ts", R.drawable.r1ts);
        map.put("r1re", R.drawable.r1re);
        map.put("r1rf", R.drawable.r1rf);
        map.put("r1rs", R.drawable.r1rs);
        map.put("r2ce", R.drawable.r2ce);
        map.put("r2cf", R.drawable.r2cf);
        map.put("r2cs", R.drawable.r2cs);
        map.put("r2te", R.drawable.r2te);
        map.put("r2tf", R.drawable.r2tf);
        map.put("r2ts", R.drawable.r2ts);
        map.put("r2re", R.drawable.r2re);
        map.put("r2rf", R.drawable.r2rf);
        map.put("r2rs", R.drawable.r2rs);
        map.put("r3ce", R.drawable.r3ce);
        map.put("r3cf", R.drawable.r3cf);
        map.put("r3cs", R.drawable.r3cs);
        map.put("r3te", R.drawable.r3te);
        map.put("r3tf", R.drawable.r3tf);
        map.put("r3ts", R.drawable.r3ts);
        map.put("r3re", R.drawable.r3re);
        map.put("r3rf", R.drawable.r3rf);
        map.put("r3rs", R.drawable.r3rs);
        map.put("b1ce", R.drawable.b1ce);
        map.put("b1cf", R.drawable.b1cf);
        map.put("b1cs", R.drawable.b1cs);
        map.put("b1te", R.drawable.b1te);
        map.put("b1tf", R.drawable.b1tf);
        map.put("b1ts", R.drawable.b1ts);
        map.put("b1re", R.drawable.b1re);
        map.put("b1rf", R.drawable.b1rf);
        map.put("b1rs", R.drawable.b1rs);
        map.put("b2ce", R.drawable.b2ce);
        map.put("b2cf", R.drawable.b2cf);
        map.put("b2cs", R.drawable.b2cs);
        map.put("b2te", R.drawable.b2te);
        map.put("b2tf", R.drawable.b2tf);
        map.put("b2ts", R.drawable.b2ts);
        map.put("b2re", R.drawable.b2re);
        map.put("b2rf", R.drawable.b2rf);
        map.put("b2rs", R.drawable.b2rs);
        map.put("b3ce", R.drawable.b3ce);
        map.put("b3cf", R.drawable.b3cf);
        map.put("b3cs", R.drawable.b3cs);
        map.put("b3te", R.drawable.b3te);
        map.put("b3tf", R.drawable.b3tf);
        map.put("b3ts", R.drawable.b3ts);
        map.put("b3re", R.drawable.b3re);
        map.put("b3rf", R.drawable.b3rf);
        map.put("b3rs", R.drawable.b3rs);
        map.put("y1ce", R.drawable.y1ce);
        map.put("y1cf", R.drawable.y1cf);
        map.put("y1cs", R.drawable.y1cs);
        map.put("y1te", R.drawable.y1te);
        map.put("y1tf", R.drawable.y1tf);
        map.put("y1ts", R.drawable.y1ts);
        map.put("y1re", R.drawable.y1re);
        map.put("y1rf", R.drawable.y1rf);
        map.put("y1rs", R.drawable.y1rs);
        map.put("y2ce", R.drawable.y2ce);
        map.put("y2cf", R.drawable.y2cf);
        map.put("y2cs", R.drawable.y2cs);
        map.put("y2te", R.drawable.y2te);
        map.put("y2tf", R.drawable.y2tf);
        map.put("y2ts", R.drawable.y2ts);
        map.put("y2re", R.drawable.y2re);
        map.put("y2rf", R.drawable.y2rf);
        map.put("y2rs", R.drawable.y2rs);
        map.put("y3ce", R.drawable.y3ce);
        map.put("y3cf", R.drawable.y3cf);
        map.put("y3cs", R.drawable.y3cs);
        map.put("y3te", R.drawable.y3te);
        map.put("y3tf", R.drawable.y3tf);
        map.put("y3ts", R.drawable.y3ts);
        map.put("y3re", R.drawable.y3re);
        map.put("y3rf", R.drawable.y3rf);
        map.put("y3rs", R.drawable.y3rs);
        return map;
    }


    /**
     * По названию фишки возвращает id соответствующего фона drawable
     * @param name название изображения
     * @return id drawable
     */
    public int getBackgroundForDib(String name) {
        return backgrounds.get(name);
    }

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
