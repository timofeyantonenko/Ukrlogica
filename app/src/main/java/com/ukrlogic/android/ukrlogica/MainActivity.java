package com.ukrlogic.android.ukrlogica;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;

import com.ukrlogic.android.ukrlogica.MaterialButton.FloatingActionButton;

/**
 * Created by root on 03.08.15.
 */
public class MainActivity extends Activity {

    // Material design buttons
    FloatingActionButton fabButtonAdd, fabButtonPresentation, fabButtonBrif, fabButtonWorks, fabButtonBrandBook;
    Canvas canvas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButtons();
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.right_in, R.anim.left_out);
    }


    private void initButtons(){
        fabButtonAdd = new FloatingActionButton.Builder(this)
                .withDrawable(getResources().getDrawable(R.drawable.ic_action_good))
                .withButtonColor(Color.RED)
                .withGravity(Gravity.BOTTOM | Gravity.RIGHT)
                .withMargins(0, 0, 16, 16)
                .create();
        fabButtonPresentation = new FloatingActionButton.Builder(this)
                .withDrawable(getResources().getDrawable(R.drawable.ic_action_good))
                .withButtonColor(Color.GRAY)
                .withGravity(Gravity.CENTER_HORIZONTAL)
                .withButtonSize(128)
                .withMargins(0, 64, 0, 0)
                .create();
        fabButtonBrif = new FloatingActionButton.Builder(this)
                .withDrawable(getResources().getDrawable(R.drawable.ic_action_good))
                .withButtonColor(Color.GRAY)
                .withGravity(Gravity.CENTER_HORIZONTAL)
                .withButtonSize(128)
                .withMargins(0, 172, 0, 0)
                .create();
        fabButtonWorks = new FloatingActionButton.Builder(this)
                .withDrawable(getResources().getDrawable(R.drawable.ic_action_good))
                .withButtonColor(Color.GRAY)
                .withGravity(Gravity.CENTER_HORIZONTAL)
                .withButtonSize(128)
                .withMargins(0, 280, 0, 0)
                .create();
        fabButtonBrandBook = new FloatingActionButton.Builder(this)
                .withDrawable(getResources().getDrawable(R.drawable.ic_action_good))
                .withButtonColor(Color.GRAY)
                .withGravity(Gravity.CENTER_HORIZONTAL)
                .withButtonSize(128)
                .withMargins(0, 388, 0, 0)
                .create();

        fabButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseFragment("table");
            }
        });
        fabButtonPresentation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseFragment("menu");
            }
        });
        fabButtonBrif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseFragment("table");
            }
        });
        fabButtonWorks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseFragment("projects");

            }
        });
        fabButtonBrandBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseFragment("brandbook");
            }
        });
    }

    //method that take name of fragment and set the listener for every Button
    private void chooseFragment(String fragmentName){
        Log.d("name", "we are young");
        Intent intent = new Intent(getApplicationContext(), NawigationActivity.class);
        intent.putExtra("fragment", fragmentName);
        startActivity(intent);
    }


}
