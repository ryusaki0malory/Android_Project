package com.example.fbarillot.myfirstproject;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity{

    TextView textView;
    SeekBar seekBar;
    RelativeLayout relativeLayout;
    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.textView = (TextView) findViewById(R.id.textView2);
        this.seekBar = (SeekBar) findViewById(R.id.seekBar);
        this.relativeLayout = (RelativeLayout) findViewById(R.id.activity_main);
        this.toggleButton = (ToggleButton) findViewById(R.id.toggleButton);

        Fragment fragmentA = new FragmentA();
//        FragmentManager fragmentManager = getFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.add(R.id.activity_main,fragmentA, "MyFragment");
//        fragmentTransaction.commit();
        getFragmentManager().beginTransaction().add(R.id.activity_main, fragmentA, "MyFragment").commit();


        this.toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                   relativeLayout.setBackgroundColor(Color.GREEN);
                } else {
                    relativeLayout.setBackgroundColor(Color.RED);
                }
            }
        });


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                textView.setText("Value: " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    public void Try(View view) {
        Toast.makeText(this, textView.getText().toString(),Toast.LENGTH_LONG).show();
    }

    public void GoToSecond(View view) {
        Intent intent = new Intent(this, SecondClass.class);
        intent.putExtra("ToggleButton",textView.getText().toString());
        startActivityForResult(intent, 123);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123) {
           Toast.makeText(this, data.getStringExtra("DataBack"),Toast.LENGTH_LONG).show();
        }
    }
}
