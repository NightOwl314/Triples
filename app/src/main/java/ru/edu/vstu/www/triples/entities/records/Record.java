package ru.edu.vstu.www.triples.entities.records;

public class Record {

    private String date;      //дата установления рекорда
    private String time;    //время, которое игрок потратил на игру, в формате hh:mm:ss
    private int score;      //очки, которые игрок заработал за игру

    public Record (String date, String time, int score) {
        this.date = date;
        this.time = time;
        this.score = score;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getScore() {
        return score;
    }
}
