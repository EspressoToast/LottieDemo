package com.example.ljw.lottiedemo;

import android.animation.Animator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    private LottieAnimationView mLottieAnimationView;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.btn_skip);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        setAnimations();


    }

    private void setAnimations() {
        //实例化
        mLottieAnimationView = (LottieAnimationView) findViewById(R.id.animation_view);
        //设置是否循环播放:true为循环.false为播放一次
        mLottieAnimationView.loop(true);
//        //暂停
//        mLottieAnimationView.pauseAnimation();
//        //开始播放
//        mLottieAnimationView.playAnimation();
        mLottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                //动画开始监听
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                //动画结束
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                //动画取消
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                //动画重复
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        mLottieAnimationView.cancelAnimation();
    }
}

