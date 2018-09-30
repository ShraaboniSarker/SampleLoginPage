package com.example.shraboni.lifechordtestproject.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class CardHistorySource {

    public SQLiteDatabase sqLiteDatabase;
    public CardHistoryHelper cardHistoryHelper;
    public Context context;

    public CardHistorySource(Context context) {
        cardHistoryHelper = new CardHistoryHelper(context);
        this.context = context;
    }

    public void open(){
        sqLiteDatabase = cardHistoryHelper.getWritableDatabase();
    }
    public void close(){ sqLiteDatabase.close();}

    public boolean addMessage(String cardMessage){

        this.open();
        ContentValues contentValues= new ContentValues();
        contentValues.put(CardHistoryHelper.COL_MESSAGE,cardMessage);
        Long id = sqLiteDatabase.insert(CardHistoryHelper.TABLE_CARD,null,contentValues);
        this.close();
        if (id>0){return true; }else{return false;}
    }
    public ArrayList<String> getAllLMessage(){

        ArrayList<String> list = new ArrayList<>();
        this.open();
        Cursor cursor = sqLiteDatabase.query(CardHistoryHelper.TABLE_CARD,null,null,null,
                null,null,null);
        cursor.moveToFirst();
        if(cursor != null && cursor.getCount()>0){
            for (int i = 0; i<cursor.getCount();i++){
                String message = cursor.getString(cursor.getColumnIndex(CardHistoryHelper.COL_MESSAGE));

                list.add(message);
                cursor.moveToNext();
            }
        }
        cursor.close();
        this.close();
        return list;
    }

}
