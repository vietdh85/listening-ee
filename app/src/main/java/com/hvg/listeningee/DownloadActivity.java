package com.hvg.listeningee;

import android.os.Bundle;
import android.app.Activity;
import android.os.Environment;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DownloadActivity extends Activity {

    Button btnDownload;
    TextView txtSourcePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setContentView(R.layout.activity_download);

        btnDownload = (Button)findViewById(R.id.btnDownload);
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DownloadActivity.this, "Download data", Toast.LENGTH_SHORT).show();

                File root = android.os.Environment.getExternalStorageDirectory();
//                File dir = new File(root.getAbsolutePath() + "/test");
//                if(dir.exists() == false){
//                    dir.mkdirs();
//                }
                txtSourcePath = (TextView)findViewById(R.id.txtSource);
                txtSourcePath.setText(root.getAbsolutePath() + "/test");

                try {
                    URL url = new URL("http://hoangvietblog.com/day.mp3");
                    String filePath = root.getAbsolutePath() + "/test/test.mp3";

                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    //connect
                    urlConnection.connect();

                    if (urlConnection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                        Log.w("MYAPP DEBUG", "Server returned HTTP " + urlConnection.getResponseCode() + " " + urlConnection.getResponseMessage());
                    }

                    InputStream inputStream = urlConnection.getInputStream();

                    // download the file
                    InputStream input = new BufferedInputStream(inputStream);
                    OutputStream output = new FileOutputStream(filePath);

                    byte data[] = new byte[1024];
                    int count;
                    while ((count = input.read(data)) != -1) {
                        output.write(data, 0, count);
                    }

                    output.flush();
                    output.close();
                    input.close();
                    Log.w("MYAPP DEBUG", "Download completed!");
                    urlConnection.disconnect();
                } catch (Exception e) {
                    Log.w("MYAPP ERROR", "ERROR: " + e.toString());
                    e.printStackTrace();
                }
            }
        });
    }

}
