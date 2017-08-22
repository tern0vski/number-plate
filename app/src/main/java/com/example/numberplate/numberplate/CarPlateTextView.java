package com.example.numberplate.numberplate;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by Vadim on 2017.
 */

public class CarPlateTextView extends android.support.v7.widget.AppCompatTextView {
    public CarPlateTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public CarPlateTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CarPlateTextView(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "carplate.otf");
        setTypeface(tf);
    }

}
