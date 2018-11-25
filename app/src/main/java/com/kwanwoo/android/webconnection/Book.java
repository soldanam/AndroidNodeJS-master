package com.kwanwoo.android.webconnection;

/**
 * Created by kwanwoo on 2017. 10. 17..
 */

public class Book {
    String id;
    String ID;
    String PASSWORD;


    public Book(String id, String ID, String PASSWORD) {
        this.id = id;
        this.ID = ID;
        this.PASSWORD = PASSWORD;

    }

    public String toString() {
        return String.format("id = %s \n ID = %s \n PASSWORD = %s ",id,ID,PASSWORD);
    }
}
