package com.pial.mvvm.utils.customFonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;


public class TextViewLight extends AppCompatTextView {
    public TextViewLight(Context context) {
        super(context);
        applyCustomFont(context);
    }

    public TextViewLight(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context);
    }

    public TextViewLight(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyCustomFont(context);
    }


    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("fonts/Poppins-Light.ttf", context);
        setTypeface(customFont);
    }
}
