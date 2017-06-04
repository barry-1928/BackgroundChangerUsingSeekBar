package com.example.dell.probackgroundapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    int s1=0,s2=0,s3=0;
    SharedPreferences mSettings;
    SeekBar seekBar1,seekBar2,seekBar3;

    Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSettings = this.getSharedPreferences("Settings", Context.MODE_PRIVATE);
        int a = mSettings.getInt("s1", 0);
        int b = mSettings.getInt("s2", 0);
        int c = mSettings.getInt("s3", 0);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        TextView textView = (TextView) findViewById(R.id.textbox);
        LinearLayout layout = (LinearLayout) findViewById(R.id.lay);
        layout.setBackgroundColor(Color.rgb(a, b, c));
        textView.setText("(" + a + "," + b + "," + c + ")");
        b1.setText("" + a);
        b2.setText("" + b);
        b3.setText("" + c);
        s1 = a;
        s2 = b;
        s3 = c;
        seekBar1 = (SeekBar) findViewById(R.id.seekbar1);
        seekBar2 = (SeekBar) findViewById(R.id.seekbar2);
        seekBar3 = (SeekBar) findViewById(R.id.seekbar3);
        seekBar1.setMax(255);
        seekBar2.setMax(255);
        seekBar3.setMax(255);
        seekBar1.setProgress(s1);
        seekBar2.setProgress(s2);
        seekBar3.setProgress(s3);
        seekBar1.setOnSeekBarChangeListener(this);
        seekBar2.setOnSeekBarChangeListener(this);
        seekBar3.setOnSeekBarChangeListener(this);
        seekBar1.setBackgroundColor(Color.parseColor("#00ff00"));
        seekBar2.setBackgroundColor(Color.parseColor("#00ff00"));
        seekBar3.setBackgroundColor(Color.parseColor("#00ff00"));


    }

    public void reset(View view){
        b1.setText("0");
        b2.setText("0");
        b3.setText("0");
        LinearLayout layout = (LinearLayout) findViewById(R.id.lay);
        layout.setBackgroundColor(Color.rgb(0,0,0));
        TextView textView = (TextView) findViewById(R.id.textbox);
        textView.setText("(" + 0 + "," + 0 + "," + 0 + ")");
        s1=0;
        s2=0;
        s3=0;
        sp();
    }
    public void setTextBox(){
        TextView textView = (TextView) findViewById(R.id.textbox);
        textView.setText("(" + s1 + "," + s2 + "," + s3 + ")");
        LinearLayout layout = (LinearLayout) findViewById(R.id.lay);
        layout.setBackgroundColor(Color.rgb(s1,s2,s3));
        sp();
    }
    public void sp(){
        SharedPreferences mSettings = this.getSharedPreferences("Settings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt("s1",s1);
        editor.putInt("s2",s2);
        editor.putInt("s3",s3);
        editor.apply();
        seekBar1.setProgress(s1);
        seekBar2.setProgress(s2);
        seekBar3.setProgress(s3);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(seekBar.getId()==seekBar1.getId()){
            b1.setText(""+progress);
            s1 = progress;
            setTextBox();
            sp();
        }
        else if(seekBar.getId()==seekBar2.getId()){
            b2.setText(""+progress);
            s2 = progress;
            setTextBox();
            sp();
        }
        else if(seekBar.getId()==seekBar3.getId()){
            b3.setText(""+progress);
            s3 = progress;
            setTextBox();
            sp();
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
