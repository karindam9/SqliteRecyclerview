package com.web.arindam.sqliterecyclerview;

import android.app.DownloadManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class Sqlitedata extends SQLiteOpenHelper {

    public static final int database_version=1;
    public static final String database_name="User_id.db";
    public static final String table_name="User";
    public static final String col_name="Name";
    public static final String col_phn="Phone";
    public static final String col_add="Address";
    public static final String col_id="id";



    Context context;
    public Sqlitedata(Context context) {
        super(context,database_name,null,database_version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("create table "+table_name+" ("+col_id+" integer primary key autoincrement, "+
//                col_name+" text, "+col_ph+" varchar, "+col_add+" varchar)");
//        db.execSQL("create table "+table_name+" ("+col_id+" integer primary key autoincrement, "+col_name+" text, "+col_phn+" varchar, "+col_add+" varchar)");
        db.execSQL("create table "+table_name+" ("+col_id+" integer primary key autoincrement, "+col_name+" text, "+col_phn+" varchar, "+col_add+" varchar)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("Drop table if exists "+table_name);
        db.execSQL("Drop table if exists "+table_name);

    }

    public void insert(ModelDemo modelDemo) {
       SQLiteDatabase database=getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(col_name,modelDemo.getName());
        contentValues.put(col_phn,modelDemo.getPhn());
        contentValues.put(col_add,modelDemo.getAdd());

        long a=database.insert(table_name,null,contentValues);
        database.close();

        Toast.makeText(context,""+a,Toast.LENGTH_SHORT).show();
    }

    public ArrayList<ModelDemo> getAllUser() {
        ArrayList<ModelDemo>arrayList=new ArrayList<>();
        SQLiteDatabase database=getReadableDatabase();

        String query="SELECT * FROM " + table_name;
        Cursor cursor=database.rawQuery(query,null);


        if(cursor.moveToFirst()){
            do {
                ModelDemo modelDemo=new ModelDemo();
                modelDemo.setId(Integer.valueOf(cursor.getString(cursor.getColumnIndex(col_id))));
                modelDemo.setName(cursor.getString(cursor.getColumnIndex(col_name)));
                modelDemo.setAdd(cursor.getString(cursor.getColumnIndex(col_add)));
                modelDemo.setPhn(cursor.getString(cursor.getColumnIndex(col_phn)));

                arrayList.add(modelDemo);
            }
            while (cursor.moveToNext());

        }
        cursor.close();
        database.close();

        return arrayList;
    }
}
