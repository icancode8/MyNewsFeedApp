package com.example.mynewsfeedapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the list of earthquakes from {@link QueryUtils}
        ArrayList<News> news = QueryUtils.extractNews();

        // Create a variable for the ListView ID in activity_main.xml
        ListView newsListView = findViewById(R.id.list);

        // declare the {@link: NewsFeed_ArrayAdapter} to a variable with context of "news" from arrayList
        final News_Adapter adapter = new News_Adapter(this, news);

        // Set the adapter to the {@link ListView}
        // so the list can be populated in the UI
        newsListView.setAdapter(adapter);

        // **** item -> URL ***
        // Create an OnItemClickListener when the item is clicked, will send an intent to a
        // web browser to connect to the URL

        newsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Find the current earthquake that was clicked on
                News currentItemPosition = adapter.getItem(position);

                // Convert the String URL into a URI object (to pass into the Intent constructor)
                Uri uri = Uri.parse(currentItemPosition.getUrl());

                // Create a new intent to view the earthquake URI
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, uri);

                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });
    }
}
