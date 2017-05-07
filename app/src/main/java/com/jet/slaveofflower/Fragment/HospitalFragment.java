package com.jet.slaveofflower.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jet.slaveofflower.R;
import com.jet.slaveofflower.base.BaseFragment;

import butterknife.ButterKnife;

/**
 * Created by shenqianqian on 2017/5/7.
 */
public class HospitalFragment extends BaseFragment{
    @Override
    public boolean hasMultiFragment() {
        return true;
    }
    @Override
    protected String setFragmentName() {
        return null;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hospital, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
    public static HospitalFragment newInstance(){
        Bundle args =new Bundle();
        HospitalFragment fragment=new HospitalFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
