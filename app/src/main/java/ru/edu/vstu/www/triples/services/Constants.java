package ru.edu.vstu.www.triples.services;

public class Constants {

    public static final String LOG_TAG = "GAME_LOG";          //тег логирования
    public static final int ROW_COUNT = 5;                    //количество строк игрового поля
    public static final int COLUMN_COUNT = 3;                 //количество столбцов игрового поля
    public static final int COUNT_DIBS = 15;                  //общее количество фишек игрового поля
    public static final int PLUS_SCORE = 3;                   //за каждую правильную тройку добавляем 3 очка
    public static final int MINUS_SCORE = 6;                  //за каждую неправильную тройку отнимаем 6 очков
    public static final int WIN_SCORE = 333;                   //партия выиграна, если набрали 333 очка
    public static final int COUNT_DIBS_IN_TRIPLES = 3;        //количество фишек в тройке
    public static final String PARAM_FROM_MENU = "fromMenu";  //признак откуда пришли: из меню или игры
    public static final String PARAM_SCORE = "score";         //набранные очки
    public static final String PARAM_TIME = "time";           //время
    public static final String FORMAT_DATE = "yyyy.MM.dd";    //формат даты
    public static final String FORMAT_TIME = "HH:mm:ss";      //формат времени
    public static final int MAX_STREAMS = 3;                  //количество одновременно проигрываемых потоков
}
