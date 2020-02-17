package com.example.machineproblem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MemoriesActivity extends AppCompatActivity {

    LinearLayout paff;
    LinearLayout neko;
    LinearLayout robo;
    LinearLayout ivy;
    LinearLayout cherry;
    LinearLayout xenon;
    LinearLayout conner;
    LinearLayout joe;
    LinearLayout nora;
    LinearLayout miku;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memories);

        paff = findViewById(R.id.paffsel);
        neko = findViewById(R.id.nekosel);
        robo = findViewById(R.id.robosel);
        ivy = findViewById(R.id.ivysel);
        cherry = findViewById(R.id.cherrysel);
        xenon = findViewById(R.id.xenonsel);
        conner = findViewById(R.id.connersel);
        joe = findViewById(R.id.joesel);
        nora = findViewById(R.id.norasel);
        miku = findViewById(R.id.mikusel);


        paff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MemoriesActivity.this, PopupActivity.class);
                intent.putExtra("CharPic",R.drawable.paff);
                intent.putExtra("CharFull", getString(R.string.paff_fullname));
                intent.putExtra("CharDesc", getString(R.string.paff_desc));
                startActivity(intent);
            }
        });

        neko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MemoriesActivity.this, PopupActivity.class);
                intent.putExtra("CharPic",R.drawable.neko);
                intent.putExtra("CharFull", getString(R.string.neko_fullname));
                intent.putExtra("CharDesc", getString(R.string.neko_desc));
                startActivity(intent);
            }
        });

        robo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MemoriesActivity.this, PopupActivity.class);
                intent.putExtra("CharPic",R.drawable.robo);
                intent.putExtra("CharFull", getString(R.string.robo_fullname));
                intent.putExtra("CharDesc", getString(R.string.robo_desc));
                startActivity(intent);
            }
        });

        ivy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MemoriesActivity.this, PopupActivity.class);
                intent.putExtra("CharPic",R.drawable.ivy);
                intent.putExtra("CharFull", getString(R.string.ivy_fullname));
                intent.putExtra("CharDesc", getString(R.string.ivy_desc));
                startActivity(intent);
            }
        });

        cherry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MemoriesActivity.this, PopupActivity.class);
                intent.putExtra("CharPic",R.drawable.cherry);
                intent.putExtra("CharFull", getString(R.string.cherry_fullname));
                intent.putExtra("CharDesc", getString(R.string.cherry_desc));
                startActivity(intent);
            }
        });

        xenon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MemoriesActivity.this, PopupActivity.class);
                intent.putExtra("CharPic",R.drawable.xenon);
                intent.putExtra("CharFull", getString(R.string.xenon_fullname));
                intent.putExtra("CharDesc", getString(R.string.xenon_desc));
                startActivity(intent);
            }
        });

        conner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MemoriesActivity.this, PopupActivity.class);
                intent.putExtra("CharPic",R.drawable.conner);
                intent.putExtra("CharFull", getString(R.string.conner_fullname));
                intent.putExtra("CharDesc", getString(R.string.conner_desc));
                startActivity(intent);
            }
        });

        joe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MemoriesActivity.this, PopupActivity.class);
                intent.putExtra("CharPic",R.drawable.joe);
                intent.putExtra("CharFull", getString(R.string.joe_fullname));
                intent.putExtra("CharDesc", getString(R.string.joe_desc));
                startActivity(intent);
            }
        });

        nora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MemoriesActivity.this, PopupActivity.class);
                intent.putExtra("CharPic",R.drawable.nora);
                intent.putExtra("CharFull", getString(R.string.nora_fullname));
                intent.putExtra("CharDesc", getString(R.string.nora_desc));
                startActivity(intent);
            }
        });

        miku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MemoriesActivity.this, PopupActivity.class);
                intent.putExtra("CharPic",R.drawable.mikumem);
                intent.putExtra("CharFull", getString(R.string.miku_fullname));
                intent.putExtra("CharDesc", getString(R.string.miku_desc));
                startActivity(intent);
            }
        });

    }
}
