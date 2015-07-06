package com.example.aa.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

public class CanvasPositionView extends View {

    public int width;
    public int height;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Path mPath;
    Context context;
    private Paint mPaint;
    private float mX, mY;
    private static final float TOLERANCE = 5;
    private int maxXWidth =10;
    private int maxYHeight =10;

    public CanvasPositionView(Context c, AttributeSet attrs) {
        super(c, attrs);
        context = c;

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        int width = display.getWidth();  // deprecated
        int height = display.getHeight();

        System.out.println("width:"+width);
        System.out.println("height:"+height);
        maxXWidth = Math.round(width/200);
        maxYHeight = Math.round(height/200);

        System.out.println("maxXWidth:"+maxXWidth);
        System.out.println("maxYHeight:"+maxYHeight);
        // we set a new Path
        mPath = new Path();

        // and we set a new Paint with the desired attributes
        mPaint = new Paint();
        //mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);
        //mPaint.setStyle(Paint.Style.STROKE);
        //mPaint.setStrokeJoin(Paint.Join.ROUND);
       // mPaint.setStrokeWidth(4f);
        mPaint.setTextSize(20);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int xx = 0;
        int yy =0;
        for(int x=0;x<maxXWidth;x++) {
            for(int y=0;y<maxYHeight;y++) {
                xx = x*200;
                yy = y*200;
                System.out.println("x["+xx+"]y["+yy+"]");
                canvas.drawText("("+xx+","+yy+")", xx, yy, mPaint);
            }
        }
        //canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), p);
    }
}