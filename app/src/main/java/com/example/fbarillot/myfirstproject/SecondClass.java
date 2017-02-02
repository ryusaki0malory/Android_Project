package com.example.fbarillot.myfirstproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by fbarillot on 02/02/2017.
 */

public class SecondClass extends AppCompatActivity {


    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        textView = (TextView) findViewById(R.id.textView);
        textView.setText(getIntent().getStringExtra("ToggleButton"));
    }

    public void SendDataBack(View view) {
        Intent intent = new Intent();
        intent.putExtra("DataBack", "Florian " + textView.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}
