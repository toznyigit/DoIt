package com.tstudio.second;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class GameSettingActivity extends AppCompatActivity implements View.OnClickListener{

    private int time;
    private int point;
    private int limit;
    ArrayList<String> nameList;
    ArrayList<Integer> colour = new ArrayList(){{
        add(Color.parseColor("#C0392B"));
        add(Color.parseColor("#2980B9"));
        add(Color.parseColor("#1ABC9C"));
        add(Color.parseColor("#F1C40F"));
        add(Color.parseColor("#9B59B6"));
        add(Color.parseColor("#34495E"));
    }};
    private boolean mIsBound = false;
    private MusicService mServ;
    HomeWatcher mHomeWatcher;


        @Override
    protected void onPause() {
        super.onPause();

        PowerManager pm = (PowerManager)
                getSystemService(Context.POWER_SERVICE);
        boolean isScreenOn = false;
        if (pm != null) {
            isScreenOn = pm.isScreenOn();
        }

        if (!isScreenOn) {
            if (mServ != null) {
                mServ.pauseMusic();
            }
        }

    }

    private ServiceConnection Scon =new ServiceConnection(){

        public void onServiceConnected(ComponentName name, IBinder
                binder) {
            mServ = ((MusicService.ServiceBinder)binder).getService();
        }

        public void onServiceDisconnected(ComponentName name) {
            mServ = null;
        }
    };

    void doBindService(){
        bindService(new Intent(this,MusicService.class),
                Scon, Context.BIND_AUTO_CREATE);
        mIsBound = true;
    }

    void doUnbindService()
    {
        if(mIsBound)
        {
            unbindService(Scon);
            mIsBound = false;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mServ != null) {
            mServ.resumeMusic();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        doUnbindService();
        Intent music = new Intent();
        music.setClass(this,MusicService.class);
        stopService(music);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game_setting);
        nameList = getIntent().getExtras().getStringArrayList("names");
        limit = getIntent().getExtras().getInt("limit");
        TextView txt = findViewById(R.id.textView);
        TextView txt2 = findViewById(R.id.textView2);
        TextView txt3 = findViewById(R.id.textView3);
        TextView txt4 = findViewById(R.id.textView4);
        TextView txt5 = findViewById(R.id.textView5);
        TextView txt6 = findViewById(R.id.textView6);

        Button qh = findViewById(R.id.min15);
        Button hh = findViewById(R.id.min30);
        Button fh = findViewById(R.id.min60);
        Button pt = findViewById(R.id.point10);
        Button ptf = findViewById(R.id.point25);
        Button pf = findViewById(R.id.point50);

        qh.setOnClickListener(this);
        hh.setOnClickListener(this);
        fh.setOnClickListener(this);
        pt.setOnClickListener(this);
        ptf.setOnClickListener(this);
        pf.setOnClickListener(this);

        doBindService();
        Intent music = new Intent();
        music.setClass(this, MusicService.class);
        startService(music);

        mHomeWatcher = new HomeWatcher(this);
        mHomeWatcher.setOnHomePressedListener(new HomeWatcher.OnHomePressedListener() {
            @Override
            public void onHomePressed() {
                if (mServ != null) {
                    mServ.pauseMusic();
                }
            }
            @Override
            public void onHomeLongPressed() {
                if (mServ != null) {
                    mServ.pauseMusic();
                }
            }
        });
        mHomeWatcher.startWatch();

        switch (limit){
            case 2:
                txt2.setVisibility(View.VISIBLE); txt2.setText(nameList.get(0)); txt2.setTextColor(colour.get(0));
                txt6.setVisibility(View.VISIBLE); txt6.setText(nameList.get(1)); txt6.setTextColor(colour.get(1));
                break;
            case 3:
                txt.setVisibility(View.VISIBLE); txt.setText(nameList.get(0)); txt.setTextColor(colour.get(0));
                txt3.setVisibility(View.VISIBLE); txt3.setText(nameList.get(1)); txt3.setTextColor(colour.get(1));
                txt6.setVisibility(View.VISIBLE); txt6.setText(nameList.get(2)); txt6.setTextColor(colour.get(2));
                break;
            case 4:
                txt.setVisibility(View.VISIBLE); txt.setText(nameList.get(0)); txt.setTextColor(colour.get(0));
                txt3.setVisibility(View.VISIBLE); txt3.setText(nameList.get(1)); txt3.setTextColor(colour.get(1));
                txt4.setVisibility(View.VISIBLE); txt4.setText(nameList.get(2)); txt4.setTextColor(colour.get(2));
                txt5.setVisibility(View.VISIBLE); txt5.setText(nameList.get(3)); txt5.setTextColor(colour.get(3));
                break;
            case 5:
                txt.setVisibility(View.VISIBLE); txt.setText(nameList.get(0)); txt.setTextColor(colour.get(0));
                txt2.setVisibility(View.VISIBLE); txt2.setText(nameList.get(1)); txt2.setTextColor(colour.get(1));
                txt3.setVisibility(View.VISIBLE); txt3.setText(nameList.get(2)); txt3.setTextColor(colour.get(2));
                txt4.setVisibility(View.VISIBLE); txt4.setText(nameList.get(3)); txt4.setTextColor(colour.get(3));
                txt5.setVisibility(View.VISIBLE); txt5.setText(nameList.get(4)); txt5.setTextColor(colour.get(4));
                break;
            case 6:
                txt.setVisibility(View.VISIBLE); txt.setText(nameList.get(0)); txt.setTextColor(colour.get(0));
                txt2.setVisibility(View.VISIBLE); txt2.setText(nameList.get(1)); txt2.setTextColor(colour.get(1));
                txt3.setVisibility(View.VISIBLE); txt3.setText(nameList.get(2)); txt3.setTextColor(colour.get(2));
                txt4.setVisibility(View.VISIBLE); txt4.setText(nameList.get(3)); txt4.setTextColor(colour.get(3));
                txt5.setVisibility(View.VISIBLE); txt5.setText(nameList.get(4)); txt5.setTextColor(colour.get(4));
                txt6.setVisibility(View.VISIBLE); txt6.setText(nameList.get(5)); txt6.setTextColor(colour.get(5));
                break;

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.min15:
                time = 15;
                point = -1;
                break;
            case R.id.min30:
                time = 30;
                point = -1;
                break;
            case R.id.min60:
                time = 60;
                point = -1;
                break;
            case R.id.point10:
                time = -1;
                point = 10;
                break;
            case R.id.point25:
                time = -1;
                point = 25;
                break;
            case R.id.point50:
                time = -1;
                point = 50;
                break;

        }

        Intent intent = new Intent(GameSettingActivity.this, BoardActivity.class);
        intent.putExtra("names",nameList);
        intent.putExtra("limit",limit);
        intent.putExtra("timeLimit",time);
        intent.putExtra("pointLimit",point);
        if (mServ != null) {
            mServ.pauseMusic();
        }
        startActivity(intent);

    }
    @Override
    public void onBackPressed(){}
}
