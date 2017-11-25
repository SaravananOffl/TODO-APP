package com.example.sgoff.tododemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sgoff on 25-11-2017.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper{


    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="tasks.db";
    public static final String TABLE_TASKS="Tasks";
    public static final String COLUMN_ID="_id";
    public static final String COLUMN_TASKNAME="taskname";


    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {

        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    String query=" CREATE TABLE "+TABLE_TASKS+"("+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COLUMN_TASKNAME+" TEXT"+");";
    sqLiteDatabase.execSQL(query);
    }
    public void addTasks(Tasks tasks){
        ContentValues values=new ContentValues();
        values.put(COLUMN_TASKNAME,tasks.get_taskname());
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        sqLiteDatabase.insert(TABLE_TASKS,null,values);
        sqLiteDatabase.close();
    }
    public void removeTasks(String tasks){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        sqLiteDatabase.execSQL("DELETE FROM "+TABLE_TASKS+" WHERE "+COLUMN_TASKNAME+ "=\""+ tasks+"\";");
    }

    public String databasetoString(){
        String dbString="";

        SQLiteDatabase sqLiteDatabase=getWritableDatabase();

        String query="SELECT * FROM "+TABLE_TASKS+" WHERE 1";
        Cursor c=sqLiteDatabase.rawQuery(query,null);
        c.moveToFirst();

        while(!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("taskname")) != null) {
                dbString += c.getString(c.getColumnIndex("taskname"));
                dbString += "\n";
            }
            c.moveToNext();
        }
        sqLiteDatabase.close();
        return dbString;
        }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_TASKS);
    }


}
