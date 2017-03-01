package com.example.fbarillot.myfirstproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by fbarillot on 02/02/2017.
 */

public class SecondClass extends AppCompatActivity implements AdapterView.OnItemClickListener {


    TextView textView;
    ListView listView;
    String[]  name = {"Valentin", "Florian", "Quentin", "Jerome"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        textView = (TextView) findViewById(R.id.textView);
        textView.setText(getIntent().getStringExtra("ToggleButton"));

        this.listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, name);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }

    public void SendDataBack(View view) {
        Intent intent = new Intent();
        intent.putExtra("DataBack", "Florian " + textView.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TextView tv = (TextView) view;
        Toast.makeText(this, "Clicked :" + tv.getText() + " at " + i,Toast.LENGTH_LONG).show();
    }

    public void goToSegond(View view) {
        Intent intent = new Intent(this, Activity_List.class);
        startActivity(intent);
    }
}
