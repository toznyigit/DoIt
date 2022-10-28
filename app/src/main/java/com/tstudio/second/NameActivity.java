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
import android.widget.Toast;

import java.util.ArrayList;

public class NameActivity extends AppCompatActivity{

    private int count;

    public ArrayList<String> nameList = new ArrayList<String>();

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
        setContentView(R.layout.activity_name_activity);
        Button add = findViewById(R.id.add_player);
        Button start = findViewById(R.id.start);
        count = 0;

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

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(NameActivity.this, GameSettingActivity.class);
                intent.putExtra("names",nameList);
                intent.putExtra("limit",count);
                startActivity(intent);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txt = findViewById(R.id.playerText);
                if (txt.length() < 2) {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.emptyNameField), Toast.LENGTH_SHORT).show();
                } else {
                    nameList.add(count, txt.getText().toString());
                    count += 1;
                    if (count == 2) {
                        findViewById(R.id.start).setVisibility(View.VISIBLE);
                    }
                    if (count > 5) {
                        findViewById(R.id.add_player).setVisibility(View.GONE);
                        findViewById(R.id.playerText).setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(), getResources().getString(R.string.maxPlayerError), Toast.LENGTH_SHORT).show();
                    }
                    txt.setText("");
                }
            }
        });
    }
}
