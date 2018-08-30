package com.himanshu.a09downloadingimages;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {


    ImageView downLoadedImg ;


    public void downloadImage(View view){

        ImageDownloader imageDownloader = new ImageDownloader();
        Bitmap myImage ;

        try {
            myImage = imageDownloader.execute("https://upload.wikimedia.org/wikipedia/en/a/aa/Bart_Simpson_200px.png").get();


                downLoadedImg.setImageBitmap(myImage);

        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.i("Interation","Button Tapped");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       downLoadedImg = (ImageView)findViewById(R.id.ImageView);
    }

    public  class ImageDownloader extends AsyncTask<String,Void,Bitmap>{

        @Override
        protected Bitmap doInBackground(String... urls) {
            try {
                URL url  = new URL(urls[0]);

                HttpsURLConnection httpsURLConnection = (HttpsURLConnection)url.openConnection();

                httpsURLConnection.connect();

                InputStream inputStream = httpsURLConnection.getInputStream();

                Bitmap myBitmap = BitmapFactory.decodeStream(inputStream);

                return  myBitmap;



            } catch (MalformedURLException e) {
                e.printStackTrace();
            }catch ( IOException e ){
                 e.printStackTrace();
            }
            return  null;
        }
    }
}
