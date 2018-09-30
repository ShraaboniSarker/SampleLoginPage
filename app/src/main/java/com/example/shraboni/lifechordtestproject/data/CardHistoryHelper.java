package com.example.shraboni.lifechordtestproject.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CardHistoryHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Card Database";
    public static final int DATABASE_VERSION = 1 ;
    public static final String TABLE_CARD = "tbl_card";
    public static final String COL_ID = "tbl_id";
    public static final String COL_MESSAGE = "tbl_message";

    public static  final String CREATE_DATABASE_TABLE = " create table " + TABLE_CARD + "(" +
            COL_ID +" integer primary key, "+
            COL_MESSAGE + "  text);";

    public CardHistoryHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DATABASE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE_CARD);
        onCreate(db);
    }
}
