package com.hvg.listeningee;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;

public class NextActivity extends Activity {

    TextView txtName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        Intent intent = getIntent();
        txtName = (TextView)findViewById(R.id.txtName);
        txtName.setText(intent.getStringExtra("key"));
    }

}
