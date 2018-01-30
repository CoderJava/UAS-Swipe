package com.ysn.uas;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();
    private RelativeLayout relativeLayoutContainer;
    private float x1, y1;
    private float x2, y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayoutContainer = (RelativeLayout) findViewById(R.id.relative_layout_container_activity_main);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            x1 = event.getX();
            y1 = event.getY();
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            x2 = event.getX();
            y2 = event.getY();

            Log.d(TAG, "x1: " + x1);
            Log.d(TAG, "x2: " + x2);
            Log.d(TAG, "y1: " + y1);
            Log.d(TAG, "y2: " + y2);
            if (x1 < x2) {
                Log.d(TAG, "swipe ke kiri");
                Intent intentOtherActivity = new Intent(this, OtherActivity.class);
                startActivity(intentOtherActivity);
            } else if (x1 > x2 && y1 < y2) {
                Log.d(TAG, "swipe ke kanan atas");
                Random random = new Random();
                int red = random.nextInt(256);
                int green = random.nextInt(256);
                int blue = random.nextInt(256);
                int colorRandom = Color.argb(255, red, green, blue);
                relativeLayoutContainer.setBackgroundColor(colorRandom);
                Toast.makeText(this, "Kanan Atas", Toast.LENGTH_SHORT)
                        .show();
            }
        }
        return super.onTouchEvent(event);
    }
}
