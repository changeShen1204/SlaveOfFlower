package com.jet.slaveofflower.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jet.slaveofflower.R;
import com.jet.slaveofflower.base.BaseFragment;
import com.jet.slaveofflower.webview.WebviewActivity;

import butterknife.ButterKnife;

/**
 * Created by shenqianqian on 2017/5/7.
 */
public class FlowerFragment extends BaseFragment {
    public Button know_more_caoben;
    public Button know_more_lan;
    public Button know_more_muben;
    public Button know_more_qiugen;
    public Button know_more_shuisheng;
    public Button know_more_tengben;
    public Button know_more_sugen;
    public static FlowerFragment newInstance(){
        Bundle args=new Bundle();
        FlowerFragment fragment=new FlowerFragment();
        fragment.setArguments(args);
        return fragment;
    }
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
        View view = inflater.inflate(R.layout.fragment_flower, container, false);
        know_more_caoben=(Button)view.findViewById(R.id.know_more_caoben);
        know_more_caoben.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(getActivity(), WebviewActivity.class);
                intent.putExtra(WebviewActivity.EXTRA_URL,"http://www.huabaike.com/cbzw");
                startThActivityByIntent(intent);
            }
        });
        know_more_lan=(Button)view.findViewById(R.id.know_more_lan);
        know_more_lan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(getActivity(), WebviewActivity.class);
                intent.putExtra(WebviewActivity.EXTRA_URL,"http://www.huabaike.com/lkzw");
                startThActivityByIntent(intent);
            }
        });
        know_more_muben=(Button)view.findViewById(R.id.know_more_muben);
        know_more_muben.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(getActivity(),WebviewActivity.class);
                intent.putExtra(WebviewActivity.EXTRA_URL,"http://www.huabaike.com/mbzw");
                startThActivityByIntent(intent);
            }
        });
        know_more_qiugen=(Button)view.findViewById(R.id.know_more_qiugen);
        know_more_qiugen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(getActivity(),WebviewActivity.class);
                intent.putExtra(WebviewActivity.EXTRA_URL,"http://www.huabaike.com/qgzw");
                startThActivityByIntent(intent);
            }
        });
        know_more_shuisheng=(Button)view.findViewById(R.id.know_more_shuisheng);
        know_more_shuisheng.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(getActivity(),WebviewActivity.class);
                intent.putExtra(WebviewActivity.EXTRA_URL,"http://www.huabaike.com/sszw");
                startThActivityByIntent(intent);
            }
        });
        know_more_sugen=(Button)view.findViewById(R.id.know_more_sugen);
        know_more_sugen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(getActivity(),WebviewActivity.class);
                intent.putExtra(WebviewActivity.EXTRA_URL,"http://www.huabaike.com/sgzw");
                startThActivityByIntent(intent);
            }
        });
        know_more_tengben=(Button)view.findViewById(R.id.know_more_tengben);
        know_more_tengben.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(getActivity(),WebviewActivity.class);
                intent.putExtra(WebviewActivity.EXTRA_URL,"http://www.huabaike.com/tbzw");
                startThActivityByIntent(intent);
            }
        });
        ButterKnife.bind(this, view);
        return view;
    }

}
