package com.jet.slaveofflower;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.jet.slaveofflower.datebase.NoteBaseHelper;
import com.jet.slaveofflower.datebase.NoteCursorWrapper;
import com.jet.slaveofflower.datebase.NoteDbSchema.NoteTable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by shenqianqian on 2017/5/13.
 */
public class NoteLab {
    private static NoteLab sNoteLab;
    private Context mContext;
    private SQLiteDatabase mDatabase;
    public static NoteLab get(Context context){
        if(sNoteLab ==null){
            sNoteLab =new NoteLab(context);
        }
        return sNoteLab;
    }
    private NoteLab(Context context){
        mContext=context.getApplicationContext();
        mDatabase=new NoteBaseHelper(mContext).getWritableDatabase();
    }
    public void addNote(Note n){
        ContentValues values=getContentValues(n);
        mDatabase.insert(NoteTable.NAME,null,values);
    }
    public List<Note> getNotes(){
        List<Note> notes=new ArrayList<>();
        NoteCursorWrapper cursor= queryNotes(null, null);
        try{
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                notes.add(cursor.getNote());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return notes;
    }
    public Note getNote(UUID id){
        NoteCursorWrapper cursor= queryNotes(NoteTable.Cols.UUID + " = ?", new String[]{id.toString()});
        try{
            if (cursor.getCount()==0){
                return null;
            }
            cursor.moveToFirst();
            return cursor.getNote();
        } finally {
            cursor.close();
        }
    }
    public File getPhotoFile(Note note){
        File externalFilesDir=mContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (externalFilesDir==null){
            return null;
        }
        return new File(externalFilesDir,note.getPhotoFilename());
    }
    public void updateNote(Note note){
        String uuidString=note.getId().toString();
        ContentValues values=getContentValues(note);
        mDatabase.update(NoteTable.NAME,values, NoteTable.Cols.UUID+" = ?",new String[]{uuidString});
    }
    private static ContentValues getContentValues(Note note){
        ContentValues values=new ContentValues();
        values.put(NoteTable.Cols.UUID, note.getId().toString());
        values.put(NoteTable.Cols.TITLE, note.getTitle());
        values.put(NoteTable.Cols.DATE, note.getDate().getTime());
        return values;
    }
    private NoteCursorWrapper queryNotes(String whereClause, String[] whereArgs){
        Cursor cursor=mDatabase.query(
                NoteTable.NAME,
                null,//Columns-null selects all columns
                whereClause,whereArgs,
                null,//groupBy
                null,//having
                null //orderBy
        );
        return new NoteCursorWrapper(cursor);
    }
}
