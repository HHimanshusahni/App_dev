package com.himanshu.a01listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView myListView = (ListView)findViewById(R.id.myListView);
         final ArrayList<String>myFamily = new ArrayList<String>();
        myFamily.add("ram");
        myFamily.add("shyam");
        myFamily.add("Mohan");
        myFamily.add("chaman lal");

        ArrayAdapter <String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myFamily);
         myListView.setAdapter(arrayAdapter);

         myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

//                 adapterView.setVisibility(view.GONE);   // Makes the adapter invisible when it is tapped

//                 Log.i("Name of the person",adapterView.getItemAtPosition(i).toString());
                                // OR
                 Log.i("Name of the person",myFamily.get(i));
                 Toast.makeText(getApplicationContext(),myFamily.get(i),Toast.LENGTH_SHORT).show();


             }
         });

    }
}
