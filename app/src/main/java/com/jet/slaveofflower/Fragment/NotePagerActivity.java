package com.jet.slaveofflower.Fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.jet.slaveofflower.Note;
import com.jet.slaveofflower.NoteLab;
import com.jet.slaveofflower.R;

import java.util.List;
import java.util.UUID;

/**
 * Created by shenqianqian on 2017/5/14.
 */
public class NotePagerActivity extends AppCompatActivity {
    private static final String EXTRA_NOTE_ID="com.jet.slaveofflower.note_id";
    private List<Note> mNotes;
    private ViewPager mViewPager;
    public static Intent newIntent(Context packageContext,UUID noteId){
        Intent intent=new Intent(packageContext,NotePagerActivity.class);
        intent.putExtra(EXTRA_NOTE_ID,noteId);
        return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_pager_activity);
        UUID noteId=(UUID)getIntent().getSerializableExtra(EXTRA_NOTE_ID);
        mViewPager=(ViewPager)findViewById(R.id.activity_note_pager_view_pager);
        mNotes= NoteLab.get(this).getNotes();
        FragmentManager fm=getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm){
            @Override
            public Fragment getItem(int position){
                Note note=mNotes.get(position);
                return NoteFragment.newInstance(note.getId());
            }
            @Override
            public int getCount(){
                return mNotes.size();
            }
        });

        for(int i=0;i<mNotes.size();i++){
            if(mNotes.get(i).getId().equals(noteId)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
