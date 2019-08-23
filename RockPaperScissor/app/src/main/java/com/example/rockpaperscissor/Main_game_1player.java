package com.example.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Main_game_1player extends AppCompatActivity {

    TextView tv_score;
    ImageView iv_computerChoice, iv_humanChoice;
    Button bt_rock, bt_paper, bt_scissor;

    int player_score =0, computer_score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game_1player);

        bt_rock = (Button) findViewById(R.id.bt_rock);
        bt_paper = (Button) findViewById(R.id.bt_paper);
        bt_scissor = (Button) findViewById(R.id.bt_scissor);

        tv_score = (TextView) findViewById(R.id.tv_score);

        iv_computerChoice = (ImageView) findViewById(R.id.iv_computerChoice);
        iv_humanChoice = (ImageView) findViewById(R.id.iv_humanChoice);


        bt_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_humanChoice.setImageResource(R.drawable.rock);
                String result = computer_turn("rock");
                Toast.makeText(Main_game_1player.this, result, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score: You "+Integer.toString(player_score) +" Computer "+ Integer.toString(computer_score));
            }
        });

        bt_scissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_humanChoice.setImageResource(R.drawable.scissor);
                String result = computer_turn("scissor");
                Toast.makeText(Main_game_1player.this, result, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score: You "+Integer.toString(player_score) +" Computer "+ Integer.toString(computer_score));

            }
        });

        bt_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_humanChoice.setImageResource(R.drawable.paper);
                String result = computer_turn("paper");
                Toast.makeText(Main_game_1player.this, result, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score: You "+Integer.toString(player_score) +" Computer "+ Integer.toString(computer_score));

            }
        });
    }


    public String computer_turn(String player_choice){
        String computer_choice = "";
        Random r = new Random();
        int computer_choice_number = r.nextInt(3)+1;

        if(computer_choice_number == 1){
            computer_choice = "rock";
        }
        else if(computer_choice_number == 2){
            computer_choice = "scissor";
        }
        else if(computer_choice_number == 3){
            computer_choice = "paper";
        }

        if(computer_choice == "rock"){
            iv_computerChoice.setImageResource(R.drawable.rock);
        }
        else if(computer_choice == "scissor"){
            iv_computerChoice.setImageResource(R.drawable.scissor);
        }
        else if(computer_choice == "paper"){
            iv_computerChoice.setImageResource(R.drawable.paper);
        }




        //result
        if(computer_choice == player_choice){
            return "Draw";

        }

        else if(computer_choice =="rock" && player_choice =="scissor"){
            computer_score++;
            return "Computer win!";
        }

        else if(computer_choice =="rock" && player_choice =="paper"){
            player_score++;
            return "You win!";
        }
        else if(computer_choice =="paper" && player_choice =="scissor"){
            player_score++;
            return "You win!";
        }
        else if(computer_choice =="paper" && player_choice =="rock"){
            computer_score++;

            return "Computer win!";
        }
        else if(computer_choice =="scissor" && player_choice =="rock"){
            player_score++;
            return "You win!";
        }
        else if(computer_choice =="scissor" && player_choice =="paper"){
            computer_score++;

            return "Computer win!";
        }
        else return "Not sure!";
    }
}
