package com.example.fbarillot.myfirstproject;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
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

        SharedPreferences preferences = getSharedPreferences("Pref", MODE_PRIVATE);
        textView.setText(preferences.getString("usernam", ""));
//        Fragment fragmentA = new FragmentA();
//        getFragmentManager().beginTransaction().add(R.id.activity_main, fragmentA, "MyFragment").commit();
        Button button = (Button) findViewById(R.id.button);
        registerForContextMenu(button);

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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId() == R.id.button) {
            getMenuInflater().inflate(R.menu.main_menu, menu);
        }
    }

    public void Try(View view) {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle("Alert Dialog");
        builder.setMessage("Do you want");
        builder.setCancelable(false);
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        SharedPreferences preferences = getSharedPreferences("Pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("usernam", "pomme");
        editor.commit();
//        Intent intent = new Intent(this, GrqphicsClass.class);
//        startActivity(intent);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_setting: {

                break;
            }
            case R.id.action_second: {

                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public void progressButton(View view) {

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMessage("I'm working");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(true);
        progressDialog.show();
        progressDialog.setProgress(30);
    }

    public void SettingsON(View view) {
        Intent intent = new Intent(this, Preferences.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        if (settings.getBoolean("red", false)){
            this.relativeLayout.setBackgroundColor(Color.RED);
        }
        if (settings.getBoolean("blue", false)){
            this.relativeLayout.setBackgroundColor(Color.BLUE);
        }
        if (settings.getBoolean("green", false)){
            this.relativeLayout.setBackgroundColor(Color.GREEN);
        }
    }

    public void GoToWeb(View view) {
        SQLiteDatabase db = openOrCreateDatabase("MyDB", MODE_PRIVATE, null);

        db.execSQL("CREATE TABLE IF NOT EXISTS Person (LastName TEXT, FIrstName TEXT)");
        db.execSQL("INSERT INTO Person VALUES ('POMME', 'table'");
        db.close();

        db = openOrCreateDatabase("MyDB", MODE_PRIVATE, null);
        Cursor cursor = db.rawQuery("SELECT * FROM Person", null);
        cursor.moveToFirst();
        int Ci = cursor.getColumnIndex("LastName");
        db.close();

        String url = "https://translate.google.com/?hl=fr#auto/en/florian";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
