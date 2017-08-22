package com.example.numberplate.numberplate;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Vadim on 2017.
 */

public class CustomNumberPiker extends android.widget.NumberPicker {

    public CustomNumberPiker(Context context) {
        super(context);
    }

    @Override
    public void addView(View child) {
        super.addView(child, R.style.NumberPikerDividerColor);
        updateView(child);
    }

    @Override
    public void addView(View child, int index, android.view.ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        updateView(child);
    }

    @Override
    public void addView(View child, android.view.ViewGroup.LayoutParams params) {
        super.addView(child, params);
        updateView(child);
    }

    private void updateView(View view) {
        if(view instanceof EditText){
            ((EditText) view).setTextSize(15);
            ((EditText) view).setTextColor(Color.parseColor("#000000"));
            (view).setPadding(0,10,0,10);
        }
    }

}