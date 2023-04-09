package com.example.tictacteo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Game_page extends AppCompatActivity {
    TextView player1 , player2;
    ToggleButton b00 , b01 , b02,
                 b10 , b11 , b12 ,
                 b20 , b21 , b22 ;
    char board[][] = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    char boards[][] = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    char rfinal[][] = boards;
    static int v = 0 , res1=0 , res2=0;
    boolean first = true;
    static int Xplayer = 0, Oplayer = 0;
    Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);
        b00 = (ToggleButton) findViewById(R.id.b00);
        b01 = (ToggleButton) findViewById(R.id.b01);
        b02 = (ToggleButton) findViewById(R.id.b02);
        b10 = (ToggleButton) findViewById(R.id.b10);
        b11 = (ToggleButton) findViewById(R.id.b11);
        b12 = (ToggleButton) findViewById(R.id.b12);
        b20 = (ToggleButton) findViewById(R.id.b20);
        b21 = (ToggleButton) findViewById(R.id.b21);
        b22 = (ToggleButton) findViewById(R.id.b22);
        b00.setText("");
        b01.setText("");
        b02.setText("");
        b10.setText("");
        b11.setText("");
        b12.setText("");
        b20.setText("");
        b21.setText("");
        b22.setText("");
        player1 = (TextView) findViewById(R.id.Player1);
        player2 = (TextView) findViewById(R.id.Player2);
         extras = getIntent().getExtras();
        if (extras != null) {
            player1.setText(extras.getString("player1")+" ("+res1+")");
            player2.setText(extras.getString("player2")+" ("+res2+")");
        }



    }

    public void Back(View view) {
        startActivity(new Intent(this , MainActivity.class));
    }
    static boolean threequals(char x, char y, char z) {
        return x == y && x == z && x != ' ';
    }
    static int checkWinner(char[][] board) {
        //  2: X winner
        // -2: O winner
        //  0: Tie
        //  1: No winner

        // For rows
        for (int i = 0; i < 3; i++) {
            if (threequals(board[i][0], board[i][1], board[i][2])) {
                if (board[i][0] == 'X') {
                    Xplayer++;
                    return 2;
                } else {
                    Oplayer++;
                    return -2;
                }

            }
        }
        for (int i = 0; i < 3; i++) {
            if (threequals(board[0][i], board[1][i], board[2][i])) {
//                return board[0][i] == 'X' ? 2 : -2;
                if (board[0][i] == 'X') {
                    Xplayer++;
                    return 2;
                } else {
                    Oplayer++;
                    return -2;
                }

            }
        }

        // Diameter 1
        if (threequals(board[0][0], board[1][1], board[2][2])) {
//            return board[0][0] == 'X' ? 2 : -2;
            if (board[0][0] == 'X') {
                Xplayer++;
                return 2;
            } else {
                Oplayer++;
                return -2;
            }
        }
        // Diameter 2
        if (threequals(board[2][0], board[1][1], board[0][2])) {
//            return board[2][0] == 'X' ? 2 : -2;
            if (board[2][0] == 'X') {
                Xplayer++;
                return 2;
            } else {
                Oplayer++;
                return -2;
            }
        }

        // For Tie Case
        boolean tie = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    tie = false;
                }
            }
        }
        if (tie) {
            return 0;
        }

        return 1;
    }


    public void play(View view) {
        char players;
        if (first) {
            players = 'X';
            first = false;
        } else {
            players = 'O';
            first = true;
        }
        @SuppressLint("ResourceType") int pos = view.getId()%100;
        if (pos == 35){
            boards[0][0] = players;
            rfinal[0][0] = boards[0][0];
            if (players == 'X'){
                b00.setTextColor(Color.RED);
            } else {
                b00.setTextColor(Color.YELLOW);
            }
            b00.setText(String.valueOf(players));
            b00.setEnabled(false);
        } else if (pos == 36){
            boards[0][1] = players;
            rfinal[0][1] = boards[0][1];
            if (players == 'X'){
                b01.setTextColor(Color.RED);
            } else {
                b01.setTextColor(Color.YELLOW);
            }
            b01.setText(String.valueOf(players));
            b01.setEnabled(false);
        } else if (pos == 37){
            boards[0][2] = players;
            rfinal[0][2] = boards[0][2];
            if (players == 'X'){
                b02.setTextColor(Color.RED);
            } else {
                b02.setTextColor(Color.YELLOW);
            }
            b02.setText(String.valueOf(players));
            b02.setEnabled(false);
        } else if (pos == 38){
            boards[1][0] = players;
            rfinal[1][0] = boards[1][0];
            if (players == 'X'){
                b10.setTextColor(Color.RED);
            } else {
                b10.setTextColor(Color.YELLOW);
            }
            b10.setText(String.valueOf(players));
            b10.setEnabled(false);
        } else if (pos == 39){
            boards[1][1] = players;
            rfinal[1][1] = boards[1][1];
            if (players == 'X'){
                b11.setTextColor(Color.RED);
            } else {
                b11.setTextColor(Color.YELLOW);
            }
            b11.setText(String.valueOf(players));
            b11.setEnabled(false);
        } else if (pos == 40){
            boards[1][2] = players;
            rfinal[1][2] = boards[1][2];
            if (players == 'X'){
                b12.setTextColor(Color.RED);
            } else {
                b12.setTextColor(Color.YELLOW);
            }
            b12.setText(String.valueOf(players));
            b12.setEnabled(false);
        } else if (pos == 41){
            boards[2][0] = players;
            rfinal[2][0] = boards[2][0];
            if (players == 'X'){
                b20.setTextColor(Color.RED);
            } else {
                b20.setTextColor(Color.YELLOW);
            }
            b20.setText(String.valueOf(players));
            b20.setEnabled(false);
        } else if (pos == 42){
            boards[2][1] = players;
            rfinal[2][1] = boards[2][1];
            if (players == 'X'){
                b21.setTextColor(Color.RED);
            } else {
                b21.setTextColor(Color.YELLOW);
            }
            b21.setText(String.valueOf(players));
            b21.setEnabled(false);
        } else if (pos == 43){
            boards[2][2] = players;
            rfinal[2][2] = boards[2][2];
            if (players == 'X'){
                b22.setTextColor(Color.RED);
            } else {
                b22.setTextColor(Color.YELLOW);
            }
            b22.setText(String.valueOf(players));
            b22.setEnabled(false);
        }
        boolean has_winner = false;
        int result = checkWinner(rfinal);
        switch (result) {
            case 0:
                b00.setEnabled(false);
                b01.setEnabled(false);
                b02.setEnabled(false);
                b10.setEnabled(false);
                b11.setEnabled(false);
                b12.setEnabled(false);
                b20.setEnabled(false);
                b21.setEnabled(false);
                b22.setEnabled(false);
                Toast.makeText(this, "Tie", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                res1++;
                b00.setEnabled(false);
                b01.setEnabled(false);
                b02.setEnabled(false);
                b10.setEnabled(false);
                b11.setEnabled(false);
                b12.setEnabled(false);
                b20.setEnabled(false);
                b21.setEnabled(false);
                b22.setEnabled(false);
                Toast.makeText(this, extras.getString("player1") + " is winner", Toast.LENGTH_SHORT).show();
                player1.setText(extras.getString("player1")+" ("+res1+")");
                break;
            case -2:
                res2++;
                b00.setEnabled(false);
                b01.setEnabled(false);
                b02.setEnabled(false);
                b10.setEnabled(false);
                b11.setEnabled(false);
                b12.setEnabled(false);
                b20.setEnabled(false);
                b21.setEnabled(false);
                b22.setEnabled(false);
                Toast.makeText(this, extras.getString("player2") + " is winner", Toast.LENGTH_SHORT).show();
                player2.setText(extras.getString("player2")+" ("+res2+")");
                break;
            default:
                break;
        }
    }

    public void Again(View view) {
        b00.setText("");
        b01.setText("");
        b02.setText("");
        b10.setText("");
        b11.setText("");
        b12.setText("");
        b20.setText("");
        b21.setText("");
        b22.setText("");
        b00.setEnabled(true);
        b01.setEnabled(true);
        b02.setEnabled(true);
        b10.setEnabled(true);
        b11.setEnabled(true);
        b12.setEnabled(true);
        b20.setEnabled(true);
        b21.setEnabled(true);
        b22.setEnabled(true);
        for (int i =0 ; i< rfinal.length;i++){
            for (int j =0 ; j<rfinal.length;j++){
                rfinal[i][j]= ' ';
            }
        }
        first = true;
    }

    public void Reset(View view) {
        first = true;
        res1=0;
        res2=0;
        b00.setText("");
        b01.setText("");
        b02.setText("");
        b10.setText("");
        b11.setText("");
        b12.setText("");
        b20.setText("");
        b21.setText("");
        b22.setText("");
        b00.setEnabled(true);
        b01.setEnabled(true);
        b02.setEnabled(true);
        b10.setEnabled(true);
        b11.setEnabled(true);
        b12.setEnabled(true);
        b20.setEnabled(true);
        b21.setEnabled(true);
        b22.setEnabled(true);
        for (int i =0 ; i< rfinal.length;i++){
            for (int j =0 ; j<rfinal.length;j++){
                rfinal[i][j]= ' ';
            }
        }
        player1.setText(extras.getString("player1")+" ("+res1+")");
        player2.setText(extras.getString("player2")+" ("+res2+")");
    }
}