package com.example.recycleview;

import android.graphics.Typeface;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    // Using ArrayList to store images data
    ArrayList courseImg = new ArrayList<>(Arrays.asList(R.drawable.data_structure, R.drawable.c_plus_plus,
            R.drawable.c_hash, R.drawable.java_script,
            R.drawable.java, R.drawable.c,
            R.drawable.html, R.drawable.css));
    ArrayList courseName = new ArrayList<>(Arrays.asList("Data Structure", "C++", "C#", "JavaScript", "Java",
            "C-Language", "HTML 5", "CSS"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize and set the toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Set the title for the toolbar
        TextView toolbarTitle = new TextView(this);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        toolbarTitle.setLayoutParams(params);

        toolbarTitle.setText("GFG | RecyclerView As ListView");
        toolbarTitle.setTextSize(24);
        toolbarTitle.setTypeface(toolbarTitle.getTypeface(), Typeface.BOLD);
        toolbarTitle.setTextColor(getResources().getColor(R.color.white));

        toolbar.addView(toolbarTitle);

        // Getting reference of recyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // Setting the layout as linear
        // layout for vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        // Sending reference and data to Adapter
        Adapter adapter = new Adapter(MainActivity.this, courseImg, courseName);

        // Setting Adapter to RecyclerView
        recyclerView.setAdapter(adapter);
    }
}
