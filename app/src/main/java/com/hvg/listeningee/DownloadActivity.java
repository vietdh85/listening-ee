package com.hvg.listeningee;

import android.os.Bundle;
import android.app.Activity;
import android.os.Environment;
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
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DownloadActivity extends Activity {

    Button btnDownload;
    //String extStorageDirectory;
    TextView txtSourcePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        //extStorageDirectory = Environment.getExternalStorageDirectory().toString();

        btnDownload = (Button)findViewById(R.id.btnDownload);
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(DownloadActivity.this, "Download data", Toast.LENGTH_SHORT).show();

                File root = android.os.Environment.getExternalStorageDirectory();
                File dir = new File(root.getAbsolutePath() + "/test");

                txtSourcePath = (TextView)findViewById(R.id.txtSource);
                txtSourcePath.setText(root.getAbsolutePath() + "/test");

                if(dir.exists() == false){
                    dir.mkdirs();
                }

                try {
                    URL url = new URL("http://hoangvietblog.com/day.mp3");
                    File file = new File(dir, "test.mp3");

//                    URLConnection uconn = url.openConnection();
//
////                    InputStream is = uconn.getInputStream();
////                    BufferedInputStream bufferinstream = new BufferedInputStream(is);
//
//                    int contentLength = uconn.getContentLength();
//                    DataInputStream stream = new DataInputStream(url.openStream());
//                    byte[] buffer = new byte[contentLength];
//                    stream.readFully(buffer);
//                    stream.close();
//
//                    DataOutputStream fos = new DataOutputStream(new FileOutputStream(file));
//                    fos.write(buffer);
//                    fos.flush();
//                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
        });
    }

}
