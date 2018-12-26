package com.web.arindam.sqliterecyclerview.CreateContactUse;

import android.app.DownloadManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.ArrayList;

public class SqliteDemo extends SQLiteOpenHelper {
    public static final int database_version=1;
    public static final String database_name="user_id.db";
    public static final String table_name="user";

    public static final String col_id="id";
    public static final String col_name="name";
    public static final String col_phone="phone";
    Context context;

    public SqliteDemo( Context context) {
        super(context, table_name, null, database_version);
        this.context=context;
    }
//    public static final int database_version=1;
//    public static final String database_name="User_id.db";
//    public static final String table_name="User";
//
//    public static final String col_id="id";
//    public static final String col_name="name";
//    public static final String col_phone="phone";

//    Context context;

//    public SqliteDemo(Context context) {
//        super(context, database_name, null, database_version);
//        this.context=context;
//    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("create table "+table_name+" ("+col_id+" integer primary key autoincrement, "+col_name+" text, "+col_phn+" varchar, "+col_add+" varchar)");

//       db.execSQL("create table "+table_name+" ("+col_id+" integer primary key autoincrement, "+col_name+" text, "+col_phone+" varchar)");
        db.execSQL("create table "+table_name+" ("+col_id+" integer primary key autoincrement, "+col_name+" text, "+col_phone+" varchar)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

//        db.execSQL("Drop table if exists "+table_name);
        db.execSQL("Drop table if exists "+table_name);
    }

    public void insert(Modelrow modelrow) {

//        SQLiteDatabase database=getWritableDatabase();
//        ContentValues contentValues=new ContentValues();
//        contentValues.put(col_name,modelrow.getName());
//        contentValues.put(col_phone,modelrow.getPhone());
//       Long a= database.insert(table_name,null,contentValues);
////        Toast.makeText(context,""+a,Toast.LENGTH_SHORT).show();
//        database.close();
        SQLiteDatabase database=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col_name,modelrow.getName());
        contentValues.put(col_phone,modelrow.getPhone());
        database.insert(table_name,null,contentValues);
        database.close();

    }

    public ArrayList<Modelrow> getAlUser() {

//        SQLiteDatabase database=getReadableDatabase();
//        ArrayList<Modelrow>arrayList=new ArrayList<>();
//
//        String query="SELECT * FROM "+ table_name;
//        Cursor cursor=database.rawQuery(query,null);
//
//        if(cursor.moveToFirst()){
//            do{
//                Modelrow modelrow=new Modelrow();
//                modelrow.setName(cursor.getString(cursor.getColumnIndex(col_name)));
//                modelrow.setPhone(cursor.getString(cursor.getColumnIndex(col_phone)));
//                modelrow.setId(Integer.valueOf(cursor.getString(cursor.getColumnIndex(col_id))));
//                arrayList.add(modelrow);
//            }
//            while (cursor.moveToNext());
//        }
//        cursor.close();
//        database.close();
//        return arrayList;
        ArrayList<Modelrow>arrayList=new ArrayList<>();
        SQLiteDatabase database=getReadableDatabase();
        String query="SELECT * FROM "+ table_name;
        Cursor cursor=database.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do {
                Modelrow modelrow=new Modelrow();
                modelrow.setName(cursor.getString(cursor.getColumnIndex(col_name)));
                modelrow.setPhone(cursor.getString(cursor.getColumnIndex(col_phone)));
                modelrow.setId(Integer.valueOf(cursor.getString(cursor.getColumnIndex(col_id))));
                arrayList.add(modelrow);
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        database.close();
        return arrayList;
    }
}
