package com.example.mynewsfeedapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class News_Adapter  extends ArrayAdapter<News> {

    public News_Adapter(Context context, ArrayList<News> objects) {
        super(context, 0, objects);
    }

    /**
     * Create a getView method to call the variables from NewsFeed Class to the list view
     * @param position of the list item
     * @param convertView recycle the view and populate
     * @param parent is the ViewGroup that is used for inflation
     * @return the View to the position in the AdapterView
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // declare a View variable for convertView and..
        // check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // get NewsFeed class current item position on the screen
        // declare it to a variable to store the info
        News currentNewsPosition = getItem(position);


        // 1. Find the View in the list_item.xml layout with the ID
        // 2. Get the text from the current Quake object and
        // 3. set the text to the corresponding View position

        TextView magnitude = listItemView.findViewById(R.id.title);
        magnitude.setText(currentNewsPosition.getmTitle());

        TextView location = listItemView.findViewById(R.id.news);
        location.setText(currentNewsPosition.getmNews());

        TextView date = listItemView.findViewById(R.id.date);
        date.setText(currentNewsPosition.getmDate());

        TextView author = listItemView.findViewById(R.id.author);
        author.setText(currentNewsPosition.getmAuthor());

        // Return the whole list item layout (containing all TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }


}
