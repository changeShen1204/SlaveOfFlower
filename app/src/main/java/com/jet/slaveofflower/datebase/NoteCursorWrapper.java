package com.jet.slaveofflower.datebase;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.jet.slaveofflower.Note;
import com.jet.slaveofflower.datebase.NoteDbSchema.NoteTable;

import java.util.Date;
import java.util.UUID;

/**
 * Created by shenqianqian on 2017/5/13.
 */
public class NoteCursorWrapper extends CursorWrapper {
    public NoteCursorWrapper(Cursor cursor){
        super(cursor);
    }
    public Note getNote(){
        String uuidString=getString(getColumnIndex(NoteTable.Cols.UUID));
        String title=getString(getColumnIndex(NoteTable.Cols.TITLE));
        long date=getLong(getColumnIndex(NoteTable.Cols.DATE));
        Note note=new Note(UUID.fromString(uuidString));
        note.setTitle(title);
        note.setDate(new Date(date));
        return note;
    }

}
