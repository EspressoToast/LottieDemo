package com.example.ljw.lottiedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.OnCompositionLoadedListener;

import org.json.JSONException;
import org.json.JSONObject;

public class NetworkActivity extends AppCompatActivity {
    private RelativeLayout mLayout;
    private LottieAnimationView mLottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);
        mLayout = (RelativeLayout) findViewById(R.id.layout_content);
        initView();

    }

    private void initView() {
        mLottieAnimationView = new LottieAnimationView(NetworkActivity.this);
        String response = "你从网络获取的json";
        try {
            JSONObject jsonObject = new JSONObject(response);
            LottieComposition.Factory.fromJson(getResources(), jsonObject, new OnCompositionLoadedListener() {
                @Override
                public void onCompositionLoaded(LottieComposition lottieComposition) {
                    setComposition(lottieComposition);
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mLayout.addView(mLottieAnimationView);
    }

    private void setComposition(LottieComposition lottieComposition) {
        mLottieAnimationView.setProgress(0);
        mLottieAnimationView.loop(true);
        mLottieAnimationView.setComposition(lottieComposition);
        mLottieAnimationView.playAnimation();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mLottieAnimationView.cancelAnimation();
    }
}
