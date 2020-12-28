package com.cherish.practicalpractice.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.cherish.practicalpractice.R;

public class MyCompoundView extends LinearLayout {
    public MyCompoundView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.simple_compound_view, this);
        ImageView imageView = findViewById(R.id.image);
        TextView textView = findViewById(R.id.caption);

        TypedArray attribute = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MyCompoundView, 0, 0);
        imageView.setImageDrawable(attribute.getDrawable(R.styleable.MyCompoundView_image));
        textView.setText(attribute.getString(R.styleable.MyCompoundView_text));
        attribute.recycle();
    }
}
