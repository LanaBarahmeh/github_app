package com.example.assignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

public class AbsPage extends AppCompatActivity {
    private Spinner quotes2;
    private ListView listView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_page);
        quotes2 = findViewById(R.id.quotes2);
        listView2 = findViewById(R.id.abex);
        addtospinner();
        addtolist();
    }
   public void addtospinner(){
        ArrayList<Motivation> motivations= new ArrayList<>();
       motivations.add(new Motivation("Quotes"));
       motivations.add(new Motivation("You can do it!"));
       motivations.add(new Motivation("Staying Consistent is hard, But starting again is harder."));
       motivations.add(new Motivation("3 months from now, You will thank yourself"));
        ArrayAdapter<Motivation> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,motivations);
        quotes2.setAdapter(adapter);
    }
    private void addtolist() {
        ArrayList<String> ex= new ArrayList<>();
        ex.add("Crunches");
        ex.add("Mountain Climber");
        ex.add("Russian Twists");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,ex);
        listView2.setAdapter(adapter);
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0) {
                    Intent intent = new Intent(AbsPage.this, Crunches.class);
                    startActivity(intent);
                }
                else if(i == 1) {
                    Intent intent = new Intent(AbsPage.this, MountainClimbers.class);
                    startActivity(intent);
                }
                else if(i == 2) {
                    Intent intent = new Intent(AbsPage.this, RussianTwists.class);
                    startActivity(intent);
                }

            }
        });
    }

    public void savedataabs(View view) {
        final Handler handler= new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {


            }
        });
        State[] state= new State[2];
        state[0]= new State("Abs");

        SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor= prefs.edit();
        Gson gson= new Gson();
        String statestring= gson.toJson(state);

        editor.putString("y",statestring);
        editor.commit();
        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
    }
}