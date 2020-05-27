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

    // URL from the data set is stored to a String constant variable
    private static final String JSON_RESPONSE =
            "https://content.guardianapis.com/search?api-key=test";

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

    /**
     * ***** ASYNC TASK inner class******
     * {@link AsyncTask} to perform the network request on a background thread,
     *   ..and then update the UI with the first earthquake in the response.
     * AsyncTask<Input, Progress, Result>
     *   {@param Input}.. is a String for doInBackground method.
     *   {@param Progress}.. is set to Void because we are not updating the user about the progress
     *   {@param Result}.. is set to NewsFeed class because we want the background work to be the news feed object
     */
    private class NewsAsyncTask extends AsyncTask<String, Void, NewsFeed> {
        /**
         * This method is invoked (or called) on a background thread.
         * It is NOT okay to update the UI from a background thread, so we just return
         *  ..an{@link NewsFeed} object as the result.
         */
        protected NewsFeed doInBackground(String... urls) {

            // Don't perform the request if there are no URLs, or the first URL is null.
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }
            // Perform the HTTP request by calling the Utils.fetchData method.
            // And process or parse the response.
            // Use Input parameter by accessing the 0 element of the URL's Array{}
            // This way this Async Task can work for any String URL.
            //NewsFeed result = QueryUtils.fetchData(urls[0]);
            NewsFeed result = (NewsFeed) QueryUtils.fetchData(urls[0]);

            return result;
        }

        /**
         * This method is invoked (or called) on the main UI thread after the background
         *  ..work is done.
         * It is OKAY to modify the UI within this method.
         * We take the NewsFeed object and update the views on the screen.
         */
        protected void onPostExecute(NewsFeed data) {
            // Clear the adapter of previous earthquake data
            mAdapter.clear();

            // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
            // data set. This will trigger the ListView to update.
            if (data != null) {
                mAdapter.addAll(data);
            }
        }
}
