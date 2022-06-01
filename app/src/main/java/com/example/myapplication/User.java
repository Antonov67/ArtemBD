package com.example.myapplication;

public class User {

    private int id;
    private String login;
    private String pswrd;
    private String fio;
    public static int USER_ID = -1;



    public User(String login, String pswrd) {
        this.login = login;
        this.pswrd = pswrd;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPswrd() {
        return pswrd;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", pswrd='" + pswrd + '\'' +
                ", fio='" + fio + '\'' +
                '}';
    }
}
