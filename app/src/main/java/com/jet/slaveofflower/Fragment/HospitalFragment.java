package com.jet.slaveofflower.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jet.slaveofflower.R;
import com.jet.slaveofflower.base.BaseFragment;
import com.jet.slaveofflower.webview.WebviewActivity;

import butterknife.ButterKnife;

/**
 * Created by shenqianqian on 2017/5/7.
 */
public class HospitalFragment extends BaseFragment{
    public TextView problem_1;
    public TextView problem_2;
    public TextView problem_3;
    public TextView problem_4;
    public TextView problem_5;
    public TextView problem_6;
    public TextView problem_7;
    public TextView problem_8;
    public TextView problem_9;
    public TextView problem_10;
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
        View v = inflater.inflate(R.layout.fragment_hospital, container, false);
        problem_1=(TextView)v.findViewById(R.id.problem_1);
        problem_1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent=new Intent(getActivity(), WebviewActivity.class);
                intent.putExtra(WebviewActivity.EXTRA_URL,"http://www.huabaike.com/yzfh/7809.html");
                startThActivityByIntent(intent);
            }
        });
        problem_2=(TextView)v.findViewById(R.id.problem_2);
        problem_2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent=new Intent(getActivity(), WebviewActivity.class);
                intent.putExtra(WebviewActivity.EXTRA_URL,"http://www.huabaike.com/langen/6340.html");
                startThActivityByIntent(intent);
            }
        });
        problem_3=(TextView)v.findViewById(R.id.problem_3);
        problem_3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent=new Intent(getActivity(), WebviewActivity.class);
                intent.putExtra(WebviewActivity.EXTRA_URL,"http://www.huabaike.com/chonghai/6622.html");
                startThActivityByIntent(intent);
            }
        });
        problem_4=(TextView)v.findViewById(R.id.problem_4);
        problem_4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent=new Intent(getActivity(), WebviewActivity.class);
                intent.putExtra(WebviewActivity.EXTRA_URL,"http://www.huabaike.com/binghai/7701.html");
                startThActivityByIntent(intent);
            }
        });
        problem_5=(TextView)v.findViewById(R.id.problem_5);
        problem_5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent=new Intent(getActivity(), WebviewActivity.class);
                intent.putExtra(WebviewActivity.EXTRA_URL,"http://www.huabaike.com/qita/7904.html");
                startThActivityByIntent(intent);
            }
        });
        problem_6=(TextView)v.findViewById(R.id.problem_6);
        problem_6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent=new Intent(getActivity(), WebviewActivity.class);
                intent.putExtra(WebviewActivity.EXTRA_URL,"http://www.huabaike.com/qita/7837.html");
                startThActivityByIntent(intent);
            }
        });
        problem_7=(TextView)v.findViewById(R.id.problem_7);
        problem_7.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent=new Intent(getActivity(), WebviewActivity.class);
                intent.putExtra(WebviewActivity.EXTRA_URL,"http://www.huabaike.com/qita/7849.html");
                startThActivityByIntent(intent);
            }
        });
        problem_8=(TextView)v.findViewById(R.id.problem_8);
        problem_8.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent=new Intent(getActivity(), WebviewActivity.class);
                intent.putExtra(WebviewActivity.EXTRA_URL,"http://www.huabaike.com/qita/7815.html");
                startThActivityByIntent(intent);
            }
        });
        problem_9=(TextView)v.findViewById(R.id.problem_9);
        problem_9.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent=new Intent(getActivity(), WebviewActivity.class);
                intent.putExtra(WebviewActivity.EXTRA_URL,"http://www.huabaike.com/qita/8659.html");
                startThActivityByIntent(intent);
            }
        });
        problem_10=(TextView)v.findViewById(R.id.problem_10);
        problem_10.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent=new Intent(getActivity(), WebviewActivity.class);
                intent.putExtra(WebviewActivity.EXTRA_URL,"http://www.huabaike.com/qita/8532.html");
                startThActivityByIntent(intent);
            }
        });
        ButterKnife.bind(this, v);
        return v;
    }
    public static HospitalFragment newInstance(){
        Bundle args =new Bundle();
        HospitalFragment fragment=new HospitalFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
