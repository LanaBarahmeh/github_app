package com.example.assignment_1;

import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class FullbodyPage extends AppCompatActivity {
    private Spinner quotes;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullbody_page);
        quotes = findViewById(R.id.quotes);
        listView = findViewById(R.id.fullex);
       addtospinner();
       addtolist();

    }

   private void addtolist() {
       ArrayList<String> ex= new ArrayList<>();
        ex.add("Jumping Jacks");
        ex.add("Push Ups");
        ex.add("Squats");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,ex);
        listView.setAdapter(adapter);
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               if(i == 0) {
                   Intent intent = new Intent(FullbodyPage.this, JumpingJacks.class);
                   startActivity(intent);
               }
               else if(i == 1) {
                   Intent intent = new Intent(FullbodyPage.this, PushUps.class);
                   startActivity(intent);
               }
              else if(i == 2) {
                   Intent intent = new Intent(FullbodyPage.this, Squats.class);
                   startActivity(intent);
               }

           }
       });
    }

    public void addtospinner(){

        ArrayList<Motivation> motivations= new ArrayList<>();
        motivations.add(new Motivation("Quotes"));
        motivations.add(new Motivation("You can do it!"));
        motivations.add(new Motivation("Staying Consistent is hard, But starting again is harder."));
        motivations.add(new Motivation("3 months from now, You will thank yourself"));


       ArrayAdapter<Motivation> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,motivations);
        quotes.setAdapter(adapter);
    }

    public void savedatafullbody(View view) {

        State[] state= new State[2];
        state[0]= new State("Full Body");

        SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor= prefs.edit();
        Gson gson= new Gson();
        String statestring= gson.toJson(state);

        editor.putString("x",statestring);
        editor.commit();
        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();

    }
}