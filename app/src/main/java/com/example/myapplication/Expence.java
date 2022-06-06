package com.example.myapplication;

public class Expence {

    private int id;
    private double value;
    private String date;
    private String text;

    public Expence(int id, double value, String date, String text) {
        this.id = id;
        this.value = value;
        this.date = date;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public double getValue() {
        return value;
    }

    public String getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Expence{" +
                "id=" + id +
                ", value=" + value +
                ", date='" + date + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
