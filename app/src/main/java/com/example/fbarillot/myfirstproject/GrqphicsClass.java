package com.example.fbarillot.myfirstproject;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * Created by fbarillot on 13/02/2017.
 */

public class GrqphicsClass extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.graphics_activitie);


    }

    public void animation(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation_test);
        view.startAnimation(animation);
    }
}
