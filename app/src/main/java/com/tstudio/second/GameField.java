package com.tstudio.second;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameField extends AppCompatActivity {

    private int[] colors;
    private int[] pointList;
    private int[] timeList;
    private int playerId;
    private int questId;
    private String quest;
    private String playerName;
    private TextView questBoard;
    private TextView pointView;
    private TextView gameCounter;
    private ConstraintLayout backPlate;
    private Button success;
    private Button fail;
    private CountDownTimer timer;
    public int point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_field);

        playerName = getIntent().getExtras().getString("playerName");
        colors = getIntent().getExtras().getIntArray("colors");
        quest = getIntent().getExtras().getString("quest");
        pointList = getIntent().getExtras().getIntArray("pointList");
        playerId = getIntent().getExtras().getInt("playerId");
        questId = getIntent().getExtras().getInt("questId");
        timeList = getResources().getIntArray(R.array.timer);

        backPlate = findViewById(R.id.layout);
        success = findViewById(R.id.success);
        fail = findViewById(R.id.fail);
        gameCounter = findViewById(R.id.gameTimer);
        pointView = findViewById(R.id.pointView);

        questBoard = findViewById(R.id.questText);
        questBoard.setText(quest);
        questBoard.setTextColor(colors[1]);
        backPlate.setBackgroundColor(colors[0]);

        counterOperation(timeList[questId]);

        success.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                timer.cancel();
                point = 1;
                pointList[playerId] += 1;
                success.setVisibility(View.GONE);
                fail.setVisibility(View.GONE);
                questBoard.setVisibility(View.GONE);
                gameCounter.setVisibility(View.GONE);
                backPlate.setBackgroundColor(Color.parseColor("#429F53"));
                pointView.setVisibility(View.VISIBLE);
                pointView.setTextSize(16);
                pointView.setTextColor(Color.parseColor("#FFFFFF"));
                pointView.setText(getResources().getString(R.string.successQuest));
                turnBack();

            }
        });

        fail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                point = -1;
                pointList[playerId] = pointList[playerId] - 1;
                success.setVisibility(View.GONE);
                fail.setVisibility(View.GONE);
                questBoard.setVisibility(View.GONE);
                gameCounter.setVisibility(View.GONE);
                backPlate.setBackgroundColor(Color.parseColor("#C01525"));
                pointView.setVisibility(View.VISIBLE);
                pointView.setTextSize(16);
                pointView.setTextColor(Color.parseColor("#FFFFFF"));
                pointView.setText(getResources().getString(R.string.failQuest));
                turnBack();

            }
        });


    }

    private void counterOperation(int seconds) {
        timer = new CountDownTimer(seconds*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                gameCounter.setText(Integer.toString((int) millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                this.cancel();
                success.setVisibility(View.GONE);
                fail.setVisibility(View.GONE);
                questBoard.setVisibility(View.GONE);
                gameCounter.setVisibility(View.GONE);
                backPlate.setBackgroundColor(Color.parseColor("#000000"));
                pointView.setVisibility(View.VISIBLE);
                pointView.setTextSize(16);
                pointView.setTextColor(Color.parseColor("#FFFFFF"));
                pointView.setText(getResources().getString(R.string.penaltyQuest));
                point = -3;
                pointList[playerId] = pointList[playerId] - 3;
                turnBack();

            }
        }.start();
    }

    private void turnBack(){
        new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Toast.makeText(getApplicationContext(),Integer.toString(pointList[playerId]),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFinish() {
                this.cancel();
                Intent intent = new Intent(GameField.this,BoardActivity.class);
                intent.putExtra("pointList",pointList);

                intent.putExtra("names",getIntent().getExtras().getStringArrayList("names"));
                intent.putExtra("limit",getIntent().getExtras().getInt("limit"));
                intent.putExtra("timeLimit",getIntent().getExtras().getInt("timeLimit"));
                intent.putExtra("pointLimit",getIntent().getExtras().getInt("pointLimit"));

                startActivity(intent);
            }
        }.start();
    }

    @Override
    public void onBackPressed(){}

}
