package com.example.gamebet.Activity;// HwatuActivity.java
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gamebet.R;

public class HwatuActivity extends AppCompatActivity {

    private LinearLayout topLayout, bottomLayout;
    private float startY;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hwatu);

        topLayout = findViewById(R.id.topLayout);
        bottomLayout = findViewById(R.id.bottomLayout);

        View.OnTouchListener touchListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startY = event.getY();
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        float deltaY = event.getY() - startY;
                        adjustLayout(deltaY);
                        return true;
                    case MotionEvent.ACTION_UP:
                        float endY = event.getY();
                        if (startY - endY > 100) { // 상단으로 드래그
                            expandLayout(false);
                        } else if (endY - startY > 100) { // 하단으로 드래그
                            expandLayout(true);
                        }
                        return true;
                }
                return false;
            }
        };

        topLayout.setOnTouchListener(touchListener);
        bottomLayout.setOnTouchListener(touchListener);
    }

    private void adjustLayout(float deltaY) {
        float weightTop = topLayout.getHeight() + deltaY > 0 ? topLayout.getHeight() + deltaY : 0;
        float weightBottom = bottomLayout.getHeight() - deltaY > 0 ? bottomLayout.getHeight() - deltaY : 0;
        topLayout.getLayoutParams().height = (int) weightTop;
        bottomLayout.getLayoutParams().height = (int) weightBottom;
        topLayout.requestLayout();
        bottomLayout.requestLayout();
    }

    private void expandLayout(boolean expandTop) {
        LinearLayout expandingLayout = expandTop ? topLayout : bottomLayout;
        LinearLayout collapsingLayout = expandTop ? bottomLayout : topLayout;
        expandingLayout.getLayoutParams().height = FrameLayout.LayoutParams.MATCH_PARENT;
        collapsingLayout.getLayoutParams().height = 0;
        expandingLayout.requestLayout();
        collapsingLayout.requestLayout();

        new Handler().postDelayed(() -> {
            fadeTransition(expandTop);
        }, 300);
    }

    private void fadeTransition(boolean toWin) {
        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setDuration(900);
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(900);

        Intent intent = toWin ? new Intent(HwatuActivity.this, WinActivity.class)
                : new Intent(HwatuActivity.this, LoseActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        //findViewById(android.R.id.content).startAnimation(fadeOut);
        /*
        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) { }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = toWin ? new Intent(HwatuActivity.this, WinActivity.class)
                        : new Intent(HwatuActivity.this, LoseActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }

            @Override
            public void onAnimationRepeat(Animation animation) { }
        });*/
    }
}
