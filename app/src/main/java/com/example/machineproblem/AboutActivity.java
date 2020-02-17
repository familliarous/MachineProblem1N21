package com.example.machineproblem;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    RatingBar ratingBar;
    Button button;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        ratingBar = findViewById(R.id.ratingBar2);
        button = findViewById(R.id.buttonratemsg);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch ((int) ratingBar.getRating()) {
                    case 0:
                        Toast.makeText(getApplicationContext(), "Rating me a 0, eh? How about you go use another app!", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(), "1? Really? Alright then.", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(), "I guess I can do better. 2 is below average, after all.", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(), "Hmm... 3? How... average.", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(getApplicationContext(), "Oh, cool! A 4. Guess this app is good enough after all.", Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(getApplicationContext(), "Ok, a 5 is pushing it. This ain't the best app in the world, you know...", Toast.LENGTH_SHORT).show();
                        break;
                }

            }

        });
    }
}
