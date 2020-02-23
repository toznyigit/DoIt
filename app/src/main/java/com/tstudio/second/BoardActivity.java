package com.tstudio.second;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class BoardActivity extends AppCompatActivity implements View.OnClickListener {

    private Handler handler = new Handler();
    private int[] pointList = {0,0,0,0,0,0};
    private int counter;
    private ConstraintLayout bttn;
    public int playerLimit;
    private int timeLimit;
    private int pointLimit;
    private int randomInt;
    private TextView playerName;
    private TextView questBoard;
    private int[] indexes = {0,0};


    String[] quest;


    ArrayList<Integer> colour = new ArrayList(){{
        add(Color.parseColor("#C0392B"));
        add(Color.parseColor("#2980B9"));
        add(Color.parseColor("#1ABC9C"));
        add(Color.parseColor("#F1C40F"));
        add(Color.parseColor("#9B59B6"));
        add(Color.parseColor("#34495E"));
    }};
    ArrayList<Integer> counter_colour = new ArrayList(){{
        add(Color.parseColor("#2bc064"));
        add(Color.parseColor("#b95c29"));
        add(Color.parseColor("#bc3a1a"));
        add(Color.parseColor("#970ff1"));
        add(Color.parseColor("#b6a859"));
        add(Color.parseColor("#8a634a"));
    }};
    ArrayList<String> nameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_board);
        final int plLimit;
        int qsLimit;

        nameList = getIntent().getExtras().getStringArrayList("names");

        playerLimit = getIntent().getExtras().getInt("limit");
        timeLimit = getIntent().getExtras().getInt("timeLimit");
        pointLimit = getIntent().getExtras().getInt("pointLimit");

        if(getIntent().getExtras().getIntArray("pointList") != null) pointList = getIntent().getExtras().getIntArray("pointList");

        playerName = findViewById(R.id.boardText);
        questBoard = findViewById(R.id.questText);

        playerName.setVisibility(View.VISIBLE);
        questBoard.setEnabled(false);

        bttn = findViewById(R.id.layout);
        bttn.setBackgroundColor(Color.BLACK);

        quest = getResources().getStringArray(R.array.questions_array);

        Button ready = findViewById(R.id.ready);
        ready.setOnClickListener(this);

        Random rndm = new Random();
        //plLimit = rndm.nextInt(playerLimit);
        //qsLimit = rndm.nextInt(quest.length);

        counter = rndm.nextInt(playerLimit+1)+playerLimit;

        PWheel pWheel = new PWheel(counter,quest.length);
        pWheel.run();


    }

    @Override
    public void onClick(View v) {
        int[] colors = {colour.get(indexes[0]),counter_colour.get(indexes[0])};
        Intent intent = new Intent(BoardActivity.this,GameField.class);
        intent.putExtra("playerId",indexes[0]);
        intent.putExtra("questId",indexes[1]);
        intent.putExtra("playerName",nameList.get(indexes[0]));
        intent.putExtra("colors",colors);
        intent.putExtra("quest",quest[indexes[1]]);
        intent.putExtra("pointList",pointList);

        intent.putExtra("names",nameList);
        intent.putExtra("limit",playerLimit);
        intent.putExtra("timeLimit",timeLimit);
        intent.putExtra("pointLimit",pointLimit);

        startActivity(intent);

    }

    public class PWheel implements Runnable {
        Random rand = new Random();
        private int counter;
        private int questIndex;
        private int index;
        public int oldIndex;

        public PWheel(int counter, int questIndex){
            this.counter = counter;
            this.questIndex = questIndex;
        }

        @Override
        public void run() {
            if(counter>0){
                index = rand.nextInt(playerLimit);
                while(index==oldIndex){index = rand.nextInt(playerLimit);}
                oldIndex = index;
                bttn.setBackgroundColor(colour.get(index));
                playerName.setText(nameList.get(index));
                playerName.setTextColor(counter_colour.get(index));
                questBoard.setTextColor(counter_colour.get(index));
                indexes[0] = index;
                handler.postDelayed(this, 600);
                counter--;
            }else if(counter>-3 && counter<=0){
                questBoard.setText(Integer.toString(counter+3));
                handler.postDelayed(this, 1000);
                counter--;
            }else{
                questIndex = rand.nextInt(questIndex);
                indexes[1] = questIndex;
                questBoard.setText(quest[questIndex]);
                findViewById(R.id.ready).setVisibility(View.VISIBLE);
                handler.removeCallbacks(this);
            }
        }
    }

    @Override
    public void onBackPressed(){}

}
