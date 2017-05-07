package com.jet.slaveofflower;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.jet.slaveofflower.Fragment.FlowerFragment;
import com.jet.slaveofflower.Fragment.HospitalFragment;
import com.jet.slaveofflower.Fragment.KnowledgeFragment;
import com.jet.slaveofflower.Fragment.MyNoteFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.radiogroup)
    RadioGroup radioGroup;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    private FlowerFragment flowerFragment;
    private HospitalFragment hospitalFragment;
    private KnowledgeFragment knowledgeFragment;
    private MyNoteFragment mMyNoteFragment;
    private List<Fragment> listFragment;
    private int currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup=(RadioGroup)findViewById(R.id.radiogroup);
        viewpager=(ViewPager)findViewById(R.id.viewpager);
        ButterKnife.bind(this);
        initViewpagerAndFragment();
        initListener();
    }

    public void initListener(){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_cao:
                        currentFragment = 0;
                        break;
                    case R.id.rb_hospital:
                        currentFragment = 1;
                        break;
                    case R.id.rb_knowledge:
                        currentFragment = 2;
                        break;
                    case R.id.rb_note:
                        currentFragment = 3;
                        break;
                }
                viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
                    @Override
                    public int getCount() {
                        return listFragment.size();
                    }

                    @Override
                    public Fragment getItem(int arg0) {
                        return listFragment.get(arg0);
                    }

                    @Override
                    public void destroyItem(ViewGroup container, int position,
                                            Object object) {
                        super.destroyItem(container, position, object);
                    }
                });
            }
        });
    }
    public void initViewpagerAndFragment(){
        flowerFragment=FlowerFragment.newInstance();
        hospitalFragment=HospitalFragment.newInstance();
        knowledgeFragment=KnowledgeFragment.newInstance();
        mMyNoteFragment=MyNoteFragment.newInstance();
        listFragment=new ArrayList<>();
        listFragment.add(flowerFragment);
        listFragment.add(hospitalFragment);
        listFragment.add(knowledgeFragment);
        listFragment.add(mMyNoteFragment);
        viewpager.setOnPageChangeListener(onPageChangeListener);
    }
    private ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            switch(position){
                case 0:
                    radioGroup.check(R.id.rb_cao);
                    break;
                case 1:
                    radioGroup.check(R.id.rb_hospital);
                    break;
                case 2:
                    radioGroup.check(R.id.rb_knowledge);
                    break;
                case 3:
                    radioGroup.check(R.id.rb_note);
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };
}
