package com.example.android.newsapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link NewsAdapter} provide the layout for list for {@link News} Object
 */

public class NewsAdapter extends ArrayAdapter<News> {

    //For Logs
    private static final String LOG_TAG = NewsAdapter.class.getSimpleName();

    private static final String DATE_SEPARATOR = "T";

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     *
     * @param context The current context. Used to inflate the layout file.
     * @param news    A List of news objects to display in a list
     */
    public NewsAdapter(Activity context, ArrayList<News> news) {
        super(context, 0, news);
    }

    /**
     * Provides a view for an AdapterView
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link News} object located at this position in the list
        News currentNews = getItem(position);

        // Find the TextView in the list_item.xml with the ID story and get Story from News
        TextView storyTextView = (TextView) listItemView.findViewById(R.id.story);
        storyTextView.setText(currentNews.getStory());

        // Find the TextView in the list_item.xml with the ID section and get type from News
        TextView sectionTextView = (TextView) listItemView.findViewById(R.id.section);
        sectionTextView.setText(currentNews.getType());

        //Get PublicationDate i. e. 2017-03-22T17:32:44Z from News and split it to date and time
        String originalDate = currentNews.getDate();
        String date;
        String time;

        if (originalDate.contains(DATE_SEPARATOR)) {
            String[] parts = originalDate.split(DATE_SEPARATOR);
            date = parts[0];
            // Delete last char from time, because after split we have i.e. 17:32:44Z
            String timeWithZ = parts[1];
            time = timeWithZ.substring(0, timeWithZ.length() - 1);
        } else {
            date = "Unknown date";
            time = "Unknown time";
        }

        // Find the TextView in the list_item.xml with the ID date
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        // Display the date of the current News in that TextView
        dateTextView.setText(date);

        //Find the TextView in the list_item.xml with the ID time
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time);
        // Display the time of the current News in that TextView
        timeTextView.setText(time);

        return listItemView;
    }


}
