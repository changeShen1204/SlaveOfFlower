package com.jet.slaveofflower.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jet.slaveofflower.R;
import com.jet.slaveofflower.base.BaseFragment;

import butterknife.ButterKnife;

/**
 * Created by shenqianqian on 2017/5/7.
 */
public class Sunflower_Fragment extends BaseFragment {
    public ImageButton mButton;
    public ImageView mSunflower;
    public TextView my_tree;
    public int day=0;
    public int nowaday =0;
    public int tree=0;
    public int messgaeId=R.string.sunflower;
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
        View view = inflater.inflate(R.layout.fragment_sun, container, false);
        mButton=(ImageButton)view.findViewById(R.id.water_Button);
        mSunflower=(ImageView)view.findViewById(R.id.sun_View);
        my_tree=(TextView)view.findViewById(R.id.my_tree);
        my_tree.setText("当前养成:"+Integer.valueOf(tree));
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day+=1;
                nowaday=day%10;
                if(nowaday==0){
                    mSunflower.setBackgroundResource(R.drawable.f_0);
                }else if(nowaday==1){
                    mSunflower.setBackgroundResource(R.drawable.f_1);
                }else if(nowaday==2){
                    mSunflower.setBackgroundResource(R.drawable.f_2);
                }else if(nowaday==3){
                    mSunflower.setBackgroundResource(R.drawable.f_3);
                }else if(nowaday==4){
                    mSunflower.setBackgroundResource(R.drawable.f_4);
                }else if(nowaday==5){
                    mSunflower.setBackgroundResource(R.drawable.f_5);
                }else if(nowaday==6){
                    mSunflower.setBackgroundResource(R.drawable.f_6);
                }else if(nowaday==7){
                    mSunflower.setBackgroundResource(R.drawable.f_7);
                }else if(nowaday==8){
                    mSunflower.setBackgroundResource(R.drawable.f_8);
                }else if (nowaday==9){
                    mSunflower.setBackgroundResource(R.drawable.f_9);
                    tree+=1;
                    my_tree.setText("当前养成:"+Integer.valueOf(tree));
                    Toast.makeText(getActivity(),messgaeId,Toast.LENGTH_SHORT).show();
                }
            }
        });

        ButterKnife.bind(this, view);
        return view;
    }
    public static Sunflower_Fragment newInstance(){
        Bundle args=new Bundle();
        Sunflower_Fragment fragment=new Sunflower_Fragment();
        fragment.setArguments(args);
        return fragment;
    }
}
