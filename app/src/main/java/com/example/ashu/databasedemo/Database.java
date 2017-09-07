package com.example.ashu.databasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ashu on 9/7/2017.
 */
public class Database extends SQLiteOpenHelper {
    Context context;

    public static final String Db_name="data";
    public static final String table1="contact";
    public static final String id="_id";
    public static final String name1="name";
    public static final String contact1="contact";
    public static final String address1="address";

    public Database(Context context) {
        super(context,Db_name , null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + table1 + "( _id integer primary key autoincrement, name text, contact text, address text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists" + table1);

        onCreate(db);
    }

   public void insertdata(String name,String contact,String address){
       SQLiteDatabase db=this.getWritableDatabase();
       ContentValues contentValues=new ContentValues();
       contentValues.put(name1,name);
       contentValues.put(contact1,contact);
       contentValues.put(address1,address);
       db.insert(table1,null,contentValues);
   }

    public Cursor getData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cr =  db.rawQuery( "select _id as _id, name,contact,address from contact",null);
        cr.getCount();
        return cr;
    }
}
