package com.example.assignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    private Button fullbutton;
    private Button absbutton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fullbutton = findViewById(R.id.fullbutton);
        absbutton = findViewById(R.id.absbutton);
       // endtext = findViewById(R.id.endtext);


    }

    public void tofullbody(View view) {
        Intent intent = new Intent(this,FullbodyPage.class);
        startActivity(intent);
    }

    public void toabs(View view) {
        Intent intent = new Intent(this,AbsPage.class);
        startActivity(intent);
    }

   /* public void showlastexercise(View view) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String result = "";
        Gson gson= new Gson();

        String str= prefs.getString("x","");
        String str2= prefs.getString("y","");
        if(prefs.)
        State[] state = gson.fromJson(str,State[].class);
        for (int i = 0; i<1; i++) {
            result= String.valueOf(state[i]);
        }
        endtext.setText(result);

    }*/
}