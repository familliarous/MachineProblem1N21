package com.example.machineproblem;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PopupActivity extends AppCompatActivity {

    MediaPlayer select;
    ImageView charImage;
    TextView charDesc;
    TextView charName;
    RatingBar ratingBar;
    Button button;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_characters);

        charImage = (ImageView) findViewById(R.id.charView);
        charName = (TextView) findViewById(R.id.charFull);
        charDesc = (TextView) findViewById(R.id.charDesc);

        button = findViewById(R.id.buttonrate);
        ratingBar = findViewById(R.id.ratingBarMem);

        select = MediaPlayer.create(getApplicationContext(), R.raw.select);
        select.start();

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*0.8),(int) (height*0.7));

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null) {

            int charPic = bundle.getInt("CharPic");
            String fullName = bundle.getString("CharFull");
            String fullDesc = bundle.getString("CharDesc");

            charImage.setImageResource(charPic);
            charName.setText(fullName);
            charDesc.setText(fullDesc);

            floatEffect(charImage);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch ((int) ratingBar.getRating()) {
                    case 0:
                        Toast.makeText(getApplicationContext(), "You have rated this memory a 0...", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(), "You have rated this memory a 1.", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(), "You have rated this memory a 2.", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(), "You have rated this memory a 3.", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(getApplicationContext(), "That's a 4... Incredible.", Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(getApplicationContext(), "An extraordinary memory...", Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });

    }
    @Override
    public void onPause(){
        super.onPause();
        select.stop();
        select.release();
    }

    public void floatEffect(View v) {

        TranslateAnimation flAnimation = new TranslateAnimation(TranslateAnimation.ABSOLUTE,0f,
                TranslateAnimation.ABSOLUTE,0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT,.015f);
        flAnimation.setDuration(1500);
        flAnimation.setRepeatCount(-1);
        flAnimation.setRepeatMode(Animation.REVERSE);
        flAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        v.setAnimation(flAnimation);
    }

}
