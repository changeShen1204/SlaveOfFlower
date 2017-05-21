package com.jet.slaveofflower.Fragment;

import android.support.v4.app.Fragment;

import java.util.UUID;

/**
 * Created by shenqianqian on 2017/5/14.
 */
public class NoteActivity extends SingleFragmentActivity{
    private static final String EXTRA_CRIME_ID="com.jet.slaveofflower.note_id";
    @Override
    protected Fragment createFragment(){
        UUID noteId=(UUID)getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        return NoteFragment.newInstance(noteId);
    }
}
