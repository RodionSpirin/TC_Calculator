package com.example.timecodecalculator;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextHoursFirst;
    private EditText editTextHoursSecond;
    private EditText editTextMinutesFirst;
    private EditText editTextMinutesSecond;
    private EditText editTextSecondsFirst;
    private EditText editTextSecondsSecond;
    private EditText editTextFramesFirst;
    private EditText editTextFramesSecond;

    private Button buttonPlus;
    private Button buttonMinus;
    private Button buttonReset;

    private TextView textViewResult;

    private String hoursFirst;
    private String hoursSecond;
    private int hoursResult;
    private String minutesFirst;
    private String minutesSecond;
    private int minutesResult;
    private String secondsFirst;
    private String secondsSecond;
    private int secondsResult;
    private String framesFirst;
    private String framesSecond;
    private int framesResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setTextWatchers();
        setClickListeners();
    }

    private void initViews() {
        editTextHoursFirst = findViewById(R.id.editTextHoursFirst);
        editTextHoursSecond = findViewById(R.id.editTextHoursSecond);
        editTextMinutesFirst = findViewById(R.id.editTextMinutesFirst);
        editTextMinutesSecond = findViewById(R.id.editTextMinutesSecond);
        editTextSecondsFirst = findViewById(R.id.editTextSecondsFirst);
        editTextSecondsSecond = findViewById(R.id.editTextSecondsSecond);
        editTextFramesFirst = findViewById(R.id.editTextFramesFirst);
        editTextFramesSecond = findViewById(R.id.editTextFramesSecond);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonReset = findViewById(R.id.buttonReset);
        textViewResult = findViewById(R.id.textViewResult);
    }

    private void setTextWatchers() {
        editTextHoursFirst.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                hoursFirst = s.toString();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        editTextHoursSecond.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                hoursSecond = s.toString();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        editTextMinutesFirst.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                minutesFirst = s.toString();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        editTextMinutesSecond.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                minutesSecond = s.toString();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        editTextSecondsFirst.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                secondsFirst = s.toString();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        editTextSecondsSecond.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                secondsSecond = s.toString();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        editTextFramesFirst.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                framesFirst = s.toString();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        editTextFramesSecond.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                framesSecond = s.toString();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void setClickListeners() {
        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonReset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonPlus:
                sumFrames();
                sumSeconds();
                minutesResult = (Integer.parseInt(minutesFirst) + Integer.parseInt(minutesSecond));
                hoursResult = (Integer.parseInt(hoursFirst) + Integer.parseInt(hoursSecond));
                textViewResult.setText(hoursResult + ":" + minutesResult + ":" + secondsResult + ":" + framesResult);
                break;

            case R.id.buttonMinus:
                subtractFrames();
                subtractSeconds();
                hoursResult = (Integer.parseInt(hoursFirst) - Integer.parseInt(hoursSecond));
                minutesResult = (Integer.parseInt(minutesFirst) - Integer.parseInt(minutesSecond));
                textViewResult.setText(hoursResult + ":" + minutesResult + ":" + secondsResult + ":" + framesResult);
                break;
            case R.id.buttonReset:
                textViewResult.setText("");
                break;
        }
    }

    private void sumFrames() {
        int firstFrames = Integer.parseInt(framesFirst);
        int secondFrames = Integer.parseInt(framesSecond);
        if (firstFrames + secondFrames > 25) {
            framesResult = firstFrames + secondFrames - 25;
            secondsResult++;
        } else framesResult = firstFrames + secondFrames;
    }

    private void sumSeconds() {
        int firstSeconds = Integer.parseInt(secondsFirst);
        int secondSeconds = Integer.parseInt(secondsSecond);
        if (firstSeconds + secondSeconds > 59) {
            secondsResult = secondsResult + firstSeconds + secondSeconds - 60;
            minutesResult++;
        } else secondsResult = secondsResult + firstSeconds + secondSeconds;
    }

    private void subtractFrames() {
        int firstFrames = Integer.parseInt(framesFirst);
        int secondFrames = Integer.parseInt(framesSecond);
        if (firstFrames - secondFrames < 0) {
            firstFrames += 25;
            framesResult = firstFrames - secondFrames;
            secondsResult--;
        } else framesResult = firstFrames - secondFrames;
    }

    private void subtractSeconds() {
        int firstSeconds = Integer.parseInt(secondsFirst);
        int secondSeconds = Integer.parseInt(secondsSecond);
        if (firstSeconds - secondSeconds < 0) {
            firstSeconds += 60;
            secondsResult = firstSeconds - secondSeconds;
            minutesResult--;
        } else secondsResult = secondsResult + firstSeconds - secondSeconds;
    }
}