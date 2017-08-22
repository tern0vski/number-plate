package com.example.numberplate.numberplate;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String[] arraySeries = {"A", "B", "C", "D", "E", "H", "K", "M", "O", "P", "T", "X", "Y"};
    private int[] arrayTextViews = {R.id.series1, R.id.registration_number, R.id.series2, R.id.series3, R.id.region_number};
    private LinearLayout pickerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pickerLayout = (LinearLayout) findViewById(R.id.pickers_layout);
        findViewById(R.id.container).setOnClickListener(this);

        for (int i = 0; i < 5; i++) {
            String[] pickerDisplayedValues;
            if (i == 0 || i == 2 || i == 3) {
                pickerDisplayedValues = arraySeries;
                createPickers(pickerDisplayedValues, i);
            } else if (i == 1)
                createPickers(makeRegistrationArray(), i);
            else if (i == 4)
                createPickers(makeRegionArray(), i);
        }
    }

    private void createPickers(String[] pickerDisplayedValues, int position) {
        LinearLayout pickerLayout = (LinearLayout) findViewById(R.id.pickers_layout);
        CustomNumberPiker numberPicker = new CustomNumberPiker(this);
        numberPicker.setLayoutParams(new ActionBar.LayoutParams(
                (int) getResources().getDimension(R.dimen.picker_height),
                (int) getResources().getDimension(R.dimen.picker_height)));
//        numberPicker.setScaleX(1);
//        numberPicker.setScaleY(1);
        // numberPicker.setWeightSum(1);
        numberPicker.setFocusable(false);
        numberPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        numberPicker.setDisplayedValues(pickerDisplayedValues);
        numberPicker.setMaxValue(pickerDisplayedValues.length - 1);
        numberPicker.setMinValue(0);
        numberPicker.setTag(position);
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {
                int pickerPosition = Integer.valueOf(numberPicker.getTag().toString());
                TextView textView = (TextView) findViewById(arrayTextViews[pickerPosition]);
                String[] displayedValues = numberPicker.getDisplayedValues();
                String textViewText = displayedValues[newVal];
                textView.setText(textViewText);
            }
        });
        pickerLayout.addView(numberPicker);
    }

    private String[] makeRegistrationArray() {
        String[] registrationArray = new String[1000];
        for (int i = 0; i <= 999; i++) {
            if (i <= 9)
                registrationArray[i] = "00" + String.valueOf(i);
            else if (i >= 10 && i <= 99)
                registrationArray[i] = "0" + String.valueOf(i);
            else
                registrationArray[i] = String.valueOf(i);
        }
        return registrationArray;
    }

    private String[] makeRegionArray() {
        String[] regionArray = new String[100];
        for (int i = 0; i <= 99; i++)
            regionArray[i] = String.valueOf(i);
        return regionArray;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.container) {
            if (pickerLayout.getVisibility() == View.VISIBLE)
                pickerLayout.setVisibility(View.GONE);
            else pickerLayout.setVisibility(View.VISIBLE);
        }
    }
}
