package com.example.game_a;

import static android.os.SystemClock.sleep;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Toast;


import com.example.game_a.Logic.GameManager;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int life = 3;//sets the number of strikes
    private int errors = 0;// set the default current number of errors

    private MaterialButton[] main_BTN_arrows;
    private AppCompatImageView[] main_IMG_hearts;
    private AppCompatImageView[] main_IMG_player;
    private AppCompatImageView [][] main_IMG_obstacle;
    private final Handler handler = new Handler();

    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {
                handler.postDelayed(this, 1300); //Do it again as mentioned in menu
//                handler.postDelayed(this,750);
                newObstacle();
                nextStep();
                errorHandler();
        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        initViews();
        setArrowButtonListener();
        handler.postDelayed(runnable, 0);
    }

    private void findViews() {
        main_BTN_arrows = new MaterialButton[]{
                findViewById(R.id.left_button),
                findViewById(R.id.right_button)};
        main_IMG_hearts = new AppCompatImageView[]{
                findViewById(R.id.main_IMG_heart1),
                findViewById(R.id.main_IMG_heart2),
                findViewById(R.id.main_IMG_heart3)};
        main_IMG_player = new AppCompatImageView[]{
                findViewById(R.id.manSlot1),
                findViewById(R.id.manSlot2),
                findViewById(R.id.manSlot3)};
        main_IMG_obstacle = new AppCompatImageView[][]{
                {
                   findViewById(R.id.ballSlot1),
                   findViewById(R.id.ballSlot2) ,
                   findViewById(R.id.ballSlot3) ,
                },
                {
                   findViewById(R.id.ballSlot4),
                   findViewById(R.id.ballSlot5),
                   findViewById(R.id.ballSlot6),   
                },
                {
                   findViewById(R.id.ballSlot7),
                   findViewById(R.id.ballSlot8),
                   findViewById(R.id.ballSlot9),
                },
                {
                   findViewById(R.id.ballSlot10),
                   findViewById(R.id.ballSlot11),
                   findViewById(R.id.ballSlot12),  
                }
        };
    }

    private void initViews() {
        main_IMG_player[0].setVisibility(View.INVISIBLE);// hide left player icon
        main_IMG_player[2].setVisibility(View.INVISIBLE);// hide right player icon
        //hide obstacles
        for (int i = 0; i < main_IMG_obstacle.length; i++) {
            for (int j = 0; j < main_IMG_obstacle[i].length; j++) {
                main_IMG_obstacle[i][j].setVisibility(View.INVISIBLE);
            }
        }
    }

    private void setArrowButtonListener() {
        for (MaterialButton mb : main_BTN_arrows)
            mb.setOnClickListener(v -> clicked(mb.getId()));
    }

    //update visibility of player after clicking the arrow
    private void clicked(int selectedButton) {
        int index = 999;//default
        for (int i = 0; i < main_IMG_player.length; i++)
            if (main_IMG_player[i].getVisibility() == View.VISIBLE) {
                index = i;
            }
        if (selectedButton == 2131230955) {//id of left button
            if (index == 0) {
                main_IMG_player[0].setVisibility(View.INVISIBLE);
                main_IMG_player[2].setVisibility(View.VISIBLE);
            } else {
                main_IMG_player[index].setVisibility(View.INVISIBLE);
                main_IMG_player[index - 1].setVisibility(View.VISIBLE);
            }
        } else {
            if (index == 2) {
                main_IMG_player[2].setVisibility(View.INVISIBLE);
                main_IMG_player[0].setVisibility(View.VISIBLE);
            } else {
                main_IMG_player[index].setVisibility(View.INVISIBLE);
                main_IMG_player[index + 1].setVisibility(View.VISIBLE);
            }
        }
    }

    private void newObstacle() {
        int col = (int) (Math.random() * 3);;
        main_IMG_obstacle[0][col].setVisibility(View.VISIBLE);
    }

    //the movement of the obstacles icons to the next row
    private void nextStep() {
        for (int i = main_IMG_obstacle.length - 1; i > 0; i--) {
            for (int j = 0; j < main_IMG_obstacle[i].length; j++) { // iterate through the entire row
                if (main_IMG_obstacle[i - 1][j].getVisibility() == View.VISIBLE) {
                    main_IMG_obstacle[i][j].setVisibility(View.VISIBLE);
                    main_IMG_obstacle[i][j].setImageDrawable(main_IMG_obstacle[i - 1][j].getDrawable());
                    main_IMG_obstacle[i - 1][j].setVisibility(View.INVISIBLE);
                } else {
                    main_IMG_obstacle[i][j].setVisibility(View.INVISIBLE);
                }
            }
        }
    }

    private void errorHandler() {
        for (int i = 0; i < main_IMG_player.length; i++) {
            if (main_IMG_player[i].getVisibility() == View.VISIBLE) {
                if (main_IMG_player[i].getVisibility() == main_IMG_obstacle[main_IMG_obstacle.length - 1][i].getVisibility()) {
                        if (life != 0) {
                            errors++;
                            life--;
                            main_IMG_hearts[main_IMG_hearts.length - errors].setVisibility(View.INVISIBLE);
                            Toast.makeText(getApplicationContext(), "😵 Ouch!", Toast.LENGTH_LONG).show();
                        }
                }
            }
        }
    }


}