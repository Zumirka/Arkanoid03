package com.example.zumirka.arkanoid02;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;

import static android.R.attr.onClick;

/**
 * Created by Zumirka on 2016-10-20.
 */

public class GameView extends View {


    private SpriteObject character;
    private Context context;
    long startTime = 0;
    private int move=5;
    int szer = getResources().getDisplayMetrics().widthPixels;
    int wys = getResources().getDisplayMetrics().heightPixels;

    public GameView(Context context) {
        super(context);
        this.context = context;
        character = new SpriteObject(500,100);
        character.setMove_x(5);
        character.setMove_y(5);

        // this.setOnClickListener(this);

    }
    // public void onClick(View v) {
    //   invalidate();
    // character.update(5);
    //}

    public void onDraw(Canvas c) {
        try {
            Thread.sleep(40);
        } catch (InterruptedException e) {

        }
        long time_interim = System.currentTimeMillis();
        int adj_move = (int) (time_interim - startTime);
        startTime = time_interim;
        CheckColision();
        character.draw(c);
        invalidate();
        // character.draw(c);

    }
    public void CheckColision()
    {
        if(character.getX()-15<=0||character.getX()+25>=szer)
        {
            character.setMove_x(character.getMove_x()*(-1));
        }
        if(character.getY()-15<=0||character.getY()+25>=wys)
        {
            character.setMove_y(character.getMove_y()*(-1));
        }
        character.update();
    }


}
