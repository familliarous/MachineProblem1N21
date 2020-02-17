package com.example.machineproblem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    StringBuilder sb= new StringBuilder();

    InputMethodManager imm;

    String pc = "0214";

    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    Button okButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText6);
        editText2 = findViewById(R.id.editText10);
        editText3 = findViewById(R.id.editText11);
        editText4 = findViewById(R.id.editText12);

        okButton = findViewById(R.id.button);

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
                Toast.makeText(getApplicationContext(), "Welcome!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainMenuActivity.class);
                startActivity(intent);
                finish();
            } else {

                Toast.makeText(getApplicationContext(), "Invalid Passcode.", Toast.LENGTH_SHORT).show();
            }
            }
        });

    }
}
