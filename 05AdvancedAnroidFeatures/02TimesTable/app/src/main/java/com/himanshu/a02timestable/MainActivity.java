package com.himanshu.a02timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    public void generateTimesTable(int timesTable){

        ArrayList<String> timesTableContent = new ArrayList<String>();
        ArrayAdapter <String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,timesTableContent);

        for(int i =1;i<=10;i++){

            timesTableContent.add(Integer.toString(i*timesTable)) ;
        }

        listView.setAdapter(arrayAdapter);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timesTableSeekBar = (SeekBar)findViewById(R.id.timesTableSeekbar);
        listView = (ListView)findViewById(R.id.lvtimestable);

        timesTableSeekBar.setMax(20);
        timesTableSeekBar.setProgress(10);


        timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                   int min =1;
                   int timesTable;

                   if(seekBar.getProgress()<min){
                        timesTable = min;
                        timesTableSeekBar.setProgress(min);
                   }else{
                       timesTable = seekBar.getProgress();
                   }
                   generateTimesTable(timesTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        generateTimesTable(10);


    }
}
