package com.cherish.practicalpractice.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.cherish.practicalpractice.R;

public class MyLovelyCustomView extends View {
    //circle and text colors
    private int shapeColor, textColor;
    //label text
    private String shapeText;
    //paint for drawing custom view
    private Paint paint;

    public MyLovelyCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint  = new Paint();
        TypedArray attribute = context.getTheme().obtainStyledAttributes(attrs,R.styleable.MyLovelyCustomView,0,0);
        try {
            //get the text and colors specified using the names in attrs.xml
            shapeText = attribute.getString(R.styleable.MyLovelyCustomView_shapeText);
            shapeColor = attribute.getInteger(R.styleable.MyLovelyCustomView_shapeColor, 0);//0 is default
            textColor = attribute.getInteger(R.styleable.MyLovelyCustomView_textColor, 0);
        } finally {
            attribute.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int viewWidthHalf = this.getMeasuredWidth()/2;
        int viewHeightHalf = this.getMeasuredHeight()/2;
        int radius = 0;
        if(viewWidthHalf>viewHeightHalf)
            radius=viewHeightHalf-10;
        else
            radius=viewWidthHalf-10;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(shapeColor);
        canvas.drawCircle(viewWidthHalf, viewHeightHalf, radius, paint);
        paint.setColor(textColor);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(50);
        canvas.drawText(shapeText, viewWidthHalf, viewHeightHalf, paint);
    }

    public int getShapeColor() {
        return shapeColor;
    }

    public void setShapeColor(int shapeColor) {

        this.shapeColor = shapeColor;
        invalidate();
        requestLayout();
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
        invalidate();
        requestLayout();
    }

    public String getShapeText() {
        return shapeText;
    }

    public void setShapeText(String shapeText) {
        this.shapeText = shapeText;
        invalidate();
        requestLayout();
    }
//
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        // Defines the extra padding for the shape name text
//        int textPadding = 10;
//        int contentWidth = getMeasuredWidth();
//
//        // Resolve the width based on our minimum and the measure spec
//        int minw = contentWidth + getPaddingLeft() + getPaddingRight();
//        int w = resolveSizeAndState(minw, widthMeasureSpec, 0);
//
//        // Ask for a height that would let the view get as big as it can
//        int minh = getMeasuredHeight() + getPaddingBottom() + getPaddingTop();
//        if (displayShapeName) {
//            minh += textYOffset + textPadding;
//        }
//        int h = resolveSizeAndState(minh, heightMeasureSpec, 0);
//
//        // Calling this method determines the measured width and height
//        // Retrieve with getMeasuredWidth or getMeasuredHeight methods later
//        setMeasuredDimension(w, h);
//    }

    //        ImageView image;
//        TextView text;
//        int textColor;
//
//
//    public MyLovelyCustomView(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
//        setUpAttribute(attrs);
//    }
//
//
//    public void setUpAttribute(AttributeSet attrs){
//        TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.BenefitView, 0, 0);
//        // Extract custom attributes into member variables
//        try {
//            image.setImageDrawable(a.getDrawable(R.styleable.BenefitView_image));
//           text
//        } finally {
//            // TypedArray objects are shared and must be recycled.
//            a.recycle();
//        }
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//    }
}
