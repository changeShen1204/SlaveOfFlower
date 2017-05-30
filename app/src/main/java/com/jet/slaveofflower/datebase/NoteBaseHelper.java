package com.jet.slaveofflower.datebase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.jet.slaveofflower.datebase.NoteDbSchema.NoteTable;
/**
 * Created by shenqianqian on 2017/5/13.
 */
public class NoteBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION=1;
    private static final String DATABASE_NAME="noteBase.db";
    public NoteBaseHelper(Context context){
        super(context,DATABASE_NAME,null,VERSION);

    }
    @Override
     public void onCreate(SQLiteDatabase db){
        db.execSQL("create table "+ NoteTable.NAME + "("+
                        " _id integer primary key autoincrement, " +
                        NoteTable.Cols.UUID+", "+
                        NoteTable.Cols.TITLE+", "+
                        NoteTable.Cols.DATE+")"
        );
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
