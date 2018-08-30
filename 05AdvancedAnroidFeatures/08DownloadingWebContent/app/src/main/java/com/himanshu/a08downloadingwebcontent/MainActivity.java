package com.himanshu.a08downloadingwebcontent;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.HttpsURLConnection;


public class MainActivity extends AppCompatActivity {

    // AsyncTask: way of running the code on the different thread
    // Code which takes some time run , should run on the different thread other than main thread or UI thread
    // So that there is no delay in the UI thread
    // It allows to run the task in the background

    // ---> Request Permission in the manifest file <uses-permission android:name="android.permission.INTERNET"/>
    public class DownloadTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... urls) { // varargs: like the array contains the bunch of string

            String result = "";

            URL url ;

            HttpsURLConnection httpsURLConnection = null; // It is like a browser we are using it to fetch the contents of the URl

            try{

                url = new URL(urls[0]);

                httpsURLConnection = (HttpsURLConnection)url.openConnection(); // Like opening the browser window

                InputStream in  = httpsURLConnection.getInputStream(); // Stream to hold input of data when it comes

                InputStreamReader reader = new InputStreamReader(in);

                int data = reader.read(); // which keep the track the locatin of the html content

                while(data != -1){ // data value will be -1 when it reaches the end
                    char current = (char)data;

                    result +=current;
                    data = reader.read(); // data loops through all the character in the contents of the URL

                }
                return result;

            }catch (Exception e ){
                e.printStackTrace();
                return  "Failed";
            }



        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadTask downloadTask = new DownloadTask();
        String result = null; // can add any no of variables
        try {
            result = downloadTask.execute("https://github.com/").get();


        } catch (InterruptedException e) {
            e.printStackTrace();

        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Log.i("Contents of URL",result);


    }
}
