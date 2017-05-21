package com.jet.slaveofflower.Fragment;

import android.support.v4.app.Fragment;

/**
 * Created by shenqianqian on 2017/5/14.
 */
public class NoteListActivity extends SingleFragmentActivity{
    @Override
    protected Fragment createFragment(){
        return new NoteListFragment();
    }
}
