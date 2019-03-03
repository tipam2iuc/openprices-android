package com.nguegangbeth.openprices.tools;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteUser extends SQLiteOpenHelper {

    private String Creation= "Create table User ("
            + "dateEnregistrement DATE PRIMARY KEY,"
            +"adresse_mail TEXT NOT NULL,"
            +"motdepasse NOT NULL" +
            ")";
    /**
     * Constructeur
     * @param context
     * @param name
     * @param factory
     * @param version
     */
    public SQLiteUser(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Creation);
    }

    /**
     * le changement de version
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
