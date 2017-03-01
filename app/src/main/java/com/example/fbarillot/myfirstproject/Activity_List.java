package com.example.fbarillot.myfirstproject;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static com.example.fbarillot.myfirstproject.R.id.listView;

public class Activity_List extends ListActivity {

    String[]  name = {"Valentin", "Florian", "Quentin", "Jerome"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__list);
//        ListView listView = getListView();
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, name);
//        listView.setAdapter(adapter);
    }
}
