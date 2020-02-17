package com.example.machineproblem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenuActivity extends AppCompatActivity {

    Button buttonMem;
    Button buttonMes;
    Button buttonAbt;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_main);

        buttonMem = findViewById(R.id.button3);
        buttonMes = findViewById(R.id.button4);
        buttonAbt = findViewById(R.id.button5);

        buttonMem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Here are your memories...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainMenuActivity.this, MemoriesActivity.class);
                startActivity(intent);

            }
        });

        buttonMes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Oh, Miku wants to say something!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainMenuActivity.this, MessageActivity.class);
                startActivity(intent);
            }
        });

        buttonAbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Here's a little bit about me...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainMenuActivity.this, AboutActivity.class);
                startActivity(intent);

            }
        });

    }
}
