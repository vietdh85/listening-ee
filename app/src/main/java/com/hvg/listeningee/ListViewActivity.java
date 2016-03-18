package com.hvg.listeningee;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import vh.Weather;
import vh.WeatherAdapter;

public class ListViewActivity extends Activity {

    ListView listview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        listview1 = (ListView)findViewById(R.id.listView1);

        Weather weather_data[] = new Weather[]{
            new Weather(R.mipmap.android, "test 1"),
            new Weather(R.mipmap.android, "test 2"),
            new Weather(R.mipmap.android, "test 3"),
            new Weather(R.mipmap.android, "test 4")
        };

        WeatherAdapter adapter = new WeatherAdapter(this, R.layout.listview_item_row, weather_data);
        listview1.setAdapter(adapter);

        View header = (View)getLayoutInflater().inflate(R.layout.listview_header_row, null);
        listview1.addHeaderView(header);

        listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView txt = (TextView) view.findViewById(R.id.txtTitle);
                Toast.makeText(ListViewActivity.this, txt.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
