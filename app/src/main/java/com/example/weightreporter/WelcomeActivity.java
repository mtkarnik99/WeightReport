package com.example.weightreporter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class WelcomeActivity extends AppCompatActivity {

    ImageView ivRun;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        ivRun = findViewById(R.id.ivRun);
        animation = AnimationUtils.loadAnimation(WelcomeActivity.this,R.anim.a1);
        ivRun.startAnimation(animation);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try
                {
                    Thread.sleep(2000);
                    Intent a = new Intent(WelcomeActivity.this,MainActivity.class);
                    startActivity(a);
                    finish();
                }
                catch (Exception e )
                {
                    e.printStackTrace();
                }
            }
        });
    }
}
