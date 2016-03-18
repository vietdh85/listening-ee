package com.hvg.listeningee;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import vh.ExpandableListAdapter;

public class LessonListActivity extends Activity {

    TextView txtView;

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_list);

        txtView = (TextView) findViewById(R.id.textView);

        Intent intent = getIntent();

        int position = intent.getIntExtra(MainActivity.LEVEL, -1);

        Log.w("=========== DEBUG: ", String.valueOf(position));
        txtView.setText(String.valueOf(position));

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.elvLessons);
        prepareListData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);
    }

    private void prepareListData() {
        String[] listLevel = new String[]{
            "Level 1", "Level 2", "Level 3", "Level 4","Level 5"
        };

        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Level 1");
        listDataHeader.add("Level 2");
        listDataHeader.add("Level 3");
        listDataHeader.add("Level 4");

        // Adding child data
        List<String> level1 = new ArrayList<String>();
        level1.add("A_Day_for_the_Death");
        level1.add("A_Kiss");
        level1.add("Bubba_s_food");
        level1.add("Changed");

        List<String> level2 = new ArrayList<String>();
        level2.add("Bad Choices");
        level2.add("Double Standard");
        level2.add("Greek Family");
        level2.add("Longtime Affair");
        level2.add("Lost Custody");
        level2.add("Meddling Mother In Law");
        level2.add("Nudist");
        level2.add("Obsessive Behaviorw");

        List<String> level3 = new ArrayList<String>();
        level3.add("Cafe_puccini");
        level3.add("Disobedience");
        level3.add("Emotionally Intel Husbands");
        level3.add("First Battle");
        level3.add("Jack Kerouac Lessons");

        List<String> level4 = new ArrayList<String>();
        level4.add("Hitch");
        level4.add("Bonus Hitch 1");
        level4.add("Bonus Hitch 2");
        level4.add("Bonus Hitch 3");

        listDataChild.put(listDataHeader.get(0), level1);
        listDataChild.put(listDataHeader.get(1), level2);
        listDataChild.put(listDataHeader.get(2), level3);
        listDataChild.put(listDataHeader.get(3), level4);
    }

}
