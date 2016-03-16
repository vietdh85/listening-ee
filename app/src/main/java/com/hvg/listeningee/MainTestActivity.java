package com.hvg.listeningee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainTestActivity extends AppCompatActivity {

    Button btnSend;
    Button btnNext;
    EditText txtMessage;
    EditText txtResultText;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnSend = (Button)findViewById(R.id.btn_send);
        btnNext = (Button)findViewById(R.id.btnNext);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtMessage = (EditText)findViewById(R.id.edit_message);
                txtResultText = (EditText)findViewById(R.id.result_text);

                txtResultText.setText(txtMessage.getText().toString());
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainTestActivity.this, NextActivity.class);
                intent.putExtra("key", "Hello world");
                startActivity(intent);
            }
        });

        populateListView();
    }

    private void populateListView() {
        String[] items = {"History", "Lessons  for beginner", "Intermediate Level"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_items, items);

        listView = (ListView)findViewById(R.id.listItems);
        listView.setAdapter(adapter);
    }

}
