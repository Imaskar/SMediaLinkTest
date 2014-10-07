package ru.ima.smedialinktest1.myitems;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;

import java.util.Map;
import java.util.TreeMap;

/**
 * A factory to reuse identical bitmaps, especially the default one.
 * Created by Imaskar on 07 Oct 2014.
 */
public class BitmapFactory {
    private static int bmWidth = 100;
    private static int bmHeight = 10;
    private static int bgColor = Color.BLACK;
    private static int fgColor = Color.GREEN;
    private static Map<Float,BitmapDrawable> bitmaps = new TreeMap<Float, BitmapDrawable>();
    static {
        Bitmap bmResult = Bitmap.createBitmap(bmWidth, bmHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmResult);
        Paint paint = new Paint();
        paint.setColor(bgColor);
        canvas.drawRect(0,0,bmWidth,bmHeight,paint);
        bitmaps.put(0.0f,new BitmapDrawable(bmResult));
    }
    private  BitmapFactory(){}
    public static BitmapDrawable get(Float key){
        if (bitmaps.containsKey(key)){
            return bitmaps.get(key);
        } else {
            Bitmap bmResult = Bitmap.createBitmap(bmWidth, bmHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bmResult);
            Paint paint = new Paint();
            //paint.setColor(Color.rgb(0, 0, 0));
            paint.setColor(bgColor);
            canvas.drawRect(0,0,bmWidth,bmHeight,paint);
            //paint.setColor(Color.rgb(0, 255, 0));
            paint.setColor(fgColor);
            canvas.drawRect(0, 0, bmWidth*key, bmHeight, paint);
            BitmapDrawable bmDrawable = new BitmapDrawable(bmResult);
            bitmaps.put(key,bmDrawable);
            return bmDrawable;
        }
    }
}
