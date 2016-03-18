package com.hvg.listeningee;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

    public static final String LEVEL = "level";
    ListView listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listItems = (ListView) findViewById(R.id.listItems);

        listItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                clickItem(parent, view, position, id);
            }
        });

        populateListView();
    }

    private void populateListView() {
        String[] items = {"History", "Lessons  for beginner", "Intermediate Level"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_items, items);

        listItems = (ListView)findViewById(R.id.listItems);
        listItems.setAdapter(adapter);
    }

    private void clickItem(AdapterView<?> parent, View view, int position, long id){
        TextView txtTitle = (TextView) view.findViewById(R.id.txtTitle);
        Log.w("DEBUG: ", "Index-" + position + " : " + txtTitle.getText().toString());

        Intent intent = new Intent(MainActivity.this, LessonListActivity.class);
        //intent.putExtra(LEVEL, txtTitle.getText().toString());
        intent.putExtra(LEVEL, position);
        startActivity(intent);
    }

}
