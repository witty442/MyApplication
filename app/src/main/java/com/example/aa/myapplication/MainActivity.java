package com.example.aa.myapplication;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;


public class MainActivity extends Activity {
    private CanvasPositionView customCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.canvas_position_layout);

        customCanvas = (CanvasPositionView) findViewById(R.id.signature_canvas);
    }

    public void clearCanvas(View v){
    }


}
