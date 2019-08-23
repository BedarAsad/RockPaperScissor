package com.example.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button bt_1player, bt_2player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_1player = (Button) findViewById(R.id.bt_1player);
        bt_2player = (Button) findViewById(R.id.bt_2player);

        bt_1player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_game_1player();
            }
        });



        bt_2player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    public void main_game_1player() {
        Intent intent = new Intent(this, Main_game_1player.class);
        startActivity(intent);
    }


}
