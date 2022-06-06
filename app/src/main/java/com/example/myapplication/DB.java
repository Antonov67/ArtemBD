package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DB {

    //выбрать всех юзеров из БД и вывести их в ЛОГ
    public static void getAllUsers(Context context){
        DataBaseHelper dataBaseHelper;
        SQLiteDatabase bd;
        dataBaseHelper = new DataBaseHelper(context);
        try {
            dataBaseHelper.updateDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        bd = dataBaseHelper.getReadableDatabase();
        Cursor cursor;
        String sql = "SELECT * FROM users";
        cursor = bd.rawQuery(sql,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Log.d("users777", cursor.getString(0) + " " + cursor.getString(1) + " " + cursor.getString(2) + " " + cursor.getString(3));
            cursor.moveToNext();
        }
        cursor.close();
    }

    //метод проверки существования юзера в БД по логину и паролю
    public static boolean isUserExist (String login, String pswrd, Context context){

        String sql = "SELECT * FROM users WHERE login = '" + login + "' AND pswrd = '" + pswrd + "'";
        Log.d("users777", sql);
        DataBaseHelper dataBaseHelper;
        SQLiteDatabase bd;
        dataBaseHelper = new DataBaseHelper(context);
        try {
            dataBaseHelper.updateDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        bd = dataBaseHelper.getReadableDatabase();
        Cursor cursor;
        cursor = bd.rawQuery(sql, null);

        cursor.moveToFirst();
        User.USER_ID = Integer.parseInt(cursor.getString(0));


        if (cursor.getCount() != 0){
            Log.d("users777", "есть");
             return true;

        }else {
            Log.d("users777", "нет");
              return false;
        }

    }

    public static boolean isUserUnique(String login, Context context){

        String sql = "SELECT * FROM users WHERE login = '" + login + "'";

        DataBaseHelper dataBaseHelper;
        SQLiteDatabase bd;
        dataBaseHelper = new DataBaseHelper(context);
        try {
            dataBaseHelper.updateDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        bd = dataBaseHelper.getReadableDatabase();
        Cursor cursor;
        cursor = bd.rawQuery(sql, null);
        if (cursor.getCount() == 0){
           return true;
        }else {
            return false;
        }

    }

    public static void addUser (User user, Context context){

        DataBaseHelper dataBaseHelper;
        SQLiteDatabase bd;
        dataBaseHelper = new DataBaseHelper(context);
        try {
            dataBaseHelper.updateDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        bd = dataBaseHelper.getReadableDatabase();

        ContentValues newValues = new ContentValues();
        newValues.put("login", user.getLogin());
        newValues.put("pswrd" , user.getPswrd());
        newValues.put("fio", user.getFio());
        bd.insert("users", null, newValues);

    }

    // все расходы авторизованного юзера
    public static ArrayList<Expence> allExpence(Context context){
        DataBaseHelper dataBaseHelper;
        SQLiteDatabase bd;
        dataBaseHelper = new DataBaseHelper(context);
        try {
            dataBaseHelper.updateDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        bd = dataBaseHelper.getReadableDatabase();
        Cursor cursor;
        String sql = "SELECT users.id, expence.value, expence.data, expence.text FROM users INNER JOIN expence ON users.id = expence.id WHERE users.id = "  + User.USER_ID + " ORDER BY users.id DESC";
        cursor = bd.rawQuery(sql,null);
        cursor.moveToFirst();
        List<Expence> list = new ArrayList<>();
        while (!cursor.isAfterLast()){
           // String str = cursor.getString(0) + " " + cursor.getString(1) + " " + cursor.getString(2) + " " + cursor.getString(3) + " " + cursor.getString(4);
           // Log.d("users777", str);
            Expence expence = new Expence(Integer.parseInt(cursor.getString(0)),
                                          Double.parseDouble(cursor.getString(1)),
                                          cursor.getString(2),
                                          cursor.getString(3));
            list.add(expence);

            cursor.moveToNext();
        }
        cursor.close();
        Log.d("users777", list.toString());
        return (ArrayList<Expence>) list;
    }

    //добавление расхода в БД
    public static void addExpence(Expence expence, Context context){
        DataBaseHelper dataBaseHelper;
        SQLiteDatabase bd;
        dataBaseHelper = new DataBaseHelper(context);
        try {
            dataBaseHelper.updateDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        bd = dataBaseHelper.getReadableDatabase();

       ContentValues values = new ContentValues();
       values.put("id", expence.getId());
       values.put("value", expence.getValue());
       values.put("data", expence.getDate());
       values.put("text", expence.getText());
       bd.insert("expence", null, values);
    }

}
