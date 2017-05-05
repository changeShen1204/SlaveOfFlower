package com.jet.slaveofflower;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.ImageView;

import com.jet.slaveofflower.base.BaseActivity;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
/**
 * Created by shenqianqian on 2017/5/4.
 */
public class EntryActivity extends BaseActivity{
    @BindView(R.id.iv_entry)
    ImageView mSplashImage;
    private static final int ANIMATION_TIME = 2000;

    private static final float SCALE_END = 1.13F;
    private static final int[] IMAGES={
            R.drawable.hua1,
            R.drawable.hua2,
            R.drawable.hua3,
            R.drawable.hua4,
            R.drawable.hua5,
            R.drawable.hua6,
            R.drawable.hua7,
            R.drawable.hua8,
            R.drawable.hua9,
            R.drawable.hua10,
            R.drawable.hua11,
            R.drawable.hua12,
            R.drawable.hua13,
            R.drawable.hua14,
            R.drawable.hua15,
            R.drawable.hua16,
            R.drawable.hua17,
            R.drawable.hua18,
            R.drawable.hua19,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
        ButterKnife.bind(this);
        setTranslucentStatus(true);
        Random random = new Random(SystemClock.elapsedRealtime());
        mSplashImage=(ImageView)findViewById(R.id.iv_entry);
        mSplashImage.setImageResource(IMAGES[random.nextInt(IMAGES.length)]);

        Observable.timer(1000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>()
                {

                    @Override
                    public void call(Long aLong)
                    {

                        startAnim();
                    }
                });
    }

    @Override
    public String setActName() {
        return null;
    }

    private void startAnim()
    {

        ObjectAnimator animatorX = ObjectAnimator.ofFloat(mSplashImage, "scaleX", 1f, SCALE_END);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(mSplashImage, "scaleY", 1f, SCALE_END);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(ANIMATION_TIME).play(animatorX).with(animatorY);
        set.start();

        set.addListener(new AnimatorListenerAdapter()
        {

            @Override
            public void onAnimationEnd(Animator animation)
            {

                startActivity(new Intent(EntryActivity.this, MainActivity.class));
                EntryActivity.this.finish();
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }
}
