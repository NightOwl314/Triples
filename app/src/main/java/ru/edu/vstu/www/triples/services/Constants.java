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
    public static final String SAVE = "save_game";            //ключи для сохранения игры
    public static final String SAVE_DIB00 = "dib00";
    public static final String SAVE_DIB01 = "dib01";
    public static final String SAVE_DIB02 = "dib02";
    public static final String SAVE_DIB10 = "dib10";
    public static final String SAVE_DIB11 = "dib11";
    public static final String SAVE_DIB12 = "dib12";
    public static final String SAVE_DIB20 = "dib20";
    public static final String SAVE_DIB21 = "dib21";
    public static final String SAVE_DIB22 = "dib22";
    public static final String SAVE_DIB30 = "dib30";
    public static final String SAVE_DIB31 = "dib31";
    public static final String SAVE_DIB32 = "dib32";
    public static final String SAVE_DIB40 = "dib40";
    public static final String SAVE_DIB41 = "dib41";
    public static final String SAVE_DIB42 = "dib42";
    public static final String SAVE_SCORE = "save_score";
    public static final String SAVE_TIME = "save_time";
}
