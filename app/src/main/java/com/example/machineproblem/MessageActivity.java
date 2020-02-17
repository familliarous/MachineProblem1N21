package com.example.machineproblem;

import android.animation.ObjectAnimator;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.daasuu.ei.Ease;
import com.daasuu.ei.EasingInterpolator;

public class MessageActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    RatingBar ratingBar;
    Button button;
    ImageView miku;
    ImageView heart1;
    ImageView heart2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        ratingBar = findViewById(R.id.ratingBar);
        button = findViewById(R.id.button2);
        miku = findViewById(R.id.imageView);
        heart1 = findViewById(R.id.heart1);
        heart2 = findViewById(R.id.heart2);

        floatEffect(miku);
        floatEffect(heart1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bounce(miku);

                switch ((int) ratingBar.getRating()) {
                    case 0:
                        Toast.makeText(getApplicationContext(), "I guess you don't have any feelings for me... :'(", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(), "Aww, is my love not enough for you? :(", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(), "Can we at least be friends? :(", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(), "Did you like it? I can tell you more!", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(getApplicationContext(), "Thank you very much~! I wish I could express my feelings more... :)", Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(getApplicationContext(), "I-I don't know what to say... Thank you~! :D", Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.fivepm);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);

    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
        mediaPlayer.release();

    }

    public void floatEffect(View v) {

        TranslateAnimation flAnimation = new TranslateAnimation(TranslateAnimation.ABSOLUTE,0f,
                                                                 TranslateAnimation.ABSOLUTE,0f,
                                                                 TranslateAnimation.RELATIVE_TO_PARENT, 0f,
                                                                 TranslateAnimation.RELATIVE_TO_PARENT,.02f);
        flAnimation.setDuration(1500);
        flAnimation.setRepeatCount(-1);
        flAnimation.setRepeatMode(Animation.REVERSE);
        flAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        v.setAnimation(flAnimation);
    }

    private void bounce(View v) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(v, "translationX", 0, 25, 0);
        animator.setInterpolator(new EasingInterpolator(Ease.ELASTIC_IN_OUT));
        animator.setStartDelay(500);
        animator.setDuration(1500);
        animator.start();
    }

}


