package com.example.myapplication;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bitmap bg = Bitmap.createBitmap(720, 1280, Bitmap.Config.ARGB_8888);
        //Setting the Bitmap as background for the ImageView
        ImageView i = (ImageView) findViewById(R.id.imageView);
        i.setBackgroundDrawable(new BitmapDrawable(bg));
        //Creating the Canvas Object
        Canvas canvas = new Canvas(bg);
        //Creating the Paint Object and set its color & TextSize
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(50);
        Paint paint1 = new Paint();
        paint1.setColor(Color.WHITE);
        paint1.setTextSize(50);
        //To draw a Rectangle
        canvas.drawText(" AGE CALCULATOR  ", 170, 150, paint);
        canvas.drawRect(100, 200, 650, 700, paint);
        canvas.drawText("Name :", 170, 360, paint1);
        canvas.drawText("Enter date of birth :", 170, 450, paint1);
        //To draw a Circle
//        canvas.drawText("Circle", 120, 150, paint);
//        canvas.drawCircle(200, 350, 150, paint);
        //To draw a Square
        canvas.drawRect(550, 850, 220, 950, paint);
        canvas.drawText("CALCULATE", 250, 920, paint1);
        //To draw a Line
//        canvas.drawText("Line", 480, 800, paint);
    }
}


