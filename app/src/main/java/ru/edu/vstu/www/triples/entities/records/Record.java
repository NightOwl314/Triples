package ru.edu.vstu.www.triples.entities.records;

import java.util.Date;

public class Record {

    private Date date;      //дата установления рекорда
    private String time;    //время, которое игрок потратил на игру, в формате hh:mm:ss
    private int score;      //очки, которые игрок заработал за игру

    public Record (Date date, String time, int score) {
        this.date = date;
        this.time = time;
        this.score = score;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
