package com.example.machineproblem;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.daasuu.ei.Ease;
import com.daasuu.ei.EasingInterpolator;

public class MainActivity extends AppCompatActivity {

    StringBuilder sb= new StringBuilder();

    InputMethodManager imm;

    Animation fadeIn;
    Animation fadeOut;

    String pc = "0214";

    ImageView pic;

    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    Button okButton;
    MediaPlayer ok;
    Vibrator vib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText6);
        editText2 = findViewById(R.id.editText10);
        editText3 = findViewById(R.id.editText11);
        editText4 = findViewById(R.id.editText12);
        pic = findViewById(R.id.padlock);
        fadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alpha_inc);
        fadeOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alpha_dec);

        ok = MediaPlayer.create(getApplicationContext(), R.raw.unlockapp);

        okButton = findViewById(R.id.button);
        vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
                if (sb.length() == 0 && editText1.length() == 1) {
                    sb.append(s);
                    editText1.clearFocus();
                    editText2.requestFocus();
                    editText2.setCursorVisible(true);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
                if(sb.length()==1)
                {
                    sb.deleteCharAt(0);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(sb.length()==0)
                {
                    editText1.requestFocus();
                }
            }
        });

        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
                if (sb.length() == 0 && editText2.length() == 1) {
                    sb.append(s);
                    editText2.clearFocus();
                    editText3.requestFocus();
                    editText3.setCursorVisible(true);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
                if(sb.length()==1)
                {
                    sb.deleteCharAt(0);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(sb.length()==0)
                {
                    editText1.requestFocus();
                }
            }
        });

        editText3.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
                if (sb.length() == 0 && editText3.length() == 1) {
                    sb.append(s);
                    editText3.clearFocus();
                    editText4.requestFocus();
                    editText4.setCursorVisible(true);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
                if(sb.length()==1)
                {
                    sb.deleteCharAt(0);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(sb.length()==0)
                {
                    editText2.requestFocus();
                }
            }
        });

        editText4.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
                if (sb.length() == 0 && editText4.length() == 1) {
                    sb.append(s);
                    editText4.clearFocus();
                    okButton.requestFocus();
                    imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editText4.getWindowToken(), 0);
                }

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
                if(sb.length()==1)
                {
                    sb.deleteCharAt(0);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(sb.length()==0)
                {
                    editText3.requestFocus();
                }
            }
        });


        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pc.equals(editText1.getText().toString()+editText2.getText().toString()+editText3.getText().toString()+editText4.getText().toString())){

                    ok.start();
                    vib.vibrate(1000);
                    fadeOut.setFillAfter(true);
                    pic.startAnimation(fadeOut);
                    Toast.makeText(getApplicationContext(), "Passcode Accepted.", Toast.LENGTH_SHORT).show();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "Welcome!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, MainMenuActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }, 2000);



                } else {
                    fadeIn.setFillAfter(true);
                    pic.startAnimation(fadeIn);
                    vib.vibrate(500);
                    Toast.makeText(getApplicationContext(), "Invalid Passcode.", Toast.LENGTH_SHORT).show();
                    editText1.setText("");
                    editText2.setText("");
                    editText3.setText("");
                    editText4.setText("");
                    editText1.requestFocus();
                    bounce(editText1);
                    bounce(editText2);
                    bounce(editText3);
                    bounce(editText4);
                }
                }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        ok.stop();
        ok.release();

    }

    private void bounce(View v) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(v, "translationX", 0, 50, 0);
        animator.setInterpolator(new EasingInterpolator(Ease.ELASTIC_IN_OUT));
        animator.setDuration(1000);
        animator.start();
    }
}
