package com.example.machineproblem;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PopupActivity extends AppCompatActivity {

    ImageView charImage;
    TextView charDesc;
    TextView charName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_characters);

        charImage = (ImageView) findViewById(R.id.charView);
        charName = (TextView) findViewById(R.id.charFull);
        charDesc = (TextView) findViewById(R.id.charDesc);

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
        }

    }

}
