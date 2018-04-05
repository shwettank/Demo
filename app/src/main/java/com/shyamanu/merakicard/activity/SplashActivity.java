package com.shyamanu.merakicard.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.shyamanu.merakicard.R;

/**
 * Created by shwettank.ramteke on 3/26/2018.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        // initialize components
        initViews();
        // splash countdown timer will start
        showSplash();
    }

    /**
     * initialize components
     **/
    private void initViews() {
        TextView tvSplashScreenAppName = (TextView) findViewById (R.id.tvSplashScreenAppName);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        if (animation != null && tvSplashScreenAppName != null) {
            tvSplashScreenAppName.setAnimation(animation);
        }
    }

    /**
     * A splash screen will appear before user for <code>3000</code> milliseconds.
     */
    private void showSplash() {
        long SPLASH_SCREEN_MILLIS = 1500;
        long SPLASH_SCREEN_MILLIS_INTERVAL = 1000;
        CountDownTimer splashScreenTimer = new CountDownTimer(SPLASH_SCREEN_MILLIS,
                SPLASH_SCREEN_MILLIS_INTERVAL) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {

                    startAppNormally();
            }
        };
        splashScreenTimer.start();
    }

    private void startAppNormally(){
        Intent loginIntent = new Intent(SplashActivity.this, MerakiCardRegistrationActivity.class);
        startActivity(loginIntent);
        finish();
    }
}
