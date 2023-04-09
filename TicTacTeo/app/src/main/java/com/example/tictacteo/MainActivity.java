package com.example.tictacteo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText player1 , player2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        player1 = (EditText) findViewById(R.id.player1);
        player2 = (EditText) findViewById(R.id.player2);
    }

    public void Next(View view) {
        String p1= player1.getText().toString();
        String p2= player2.getText().toString();
        if (p1.equals("")||p2.equals("")){
            Toast.makeText(this, "Enter Player Names", Toast.LENGTH_SHORT).show();
        } else {
            Intent i = new Intent(this, Game_page.class);
            i.putExtra("player1",p1);
            i.putExtra("player2",p2);
            startActivity(i);
        }


    }
}