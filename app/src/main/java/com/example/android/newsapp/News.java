package com.example.android.newsapp;

/**
 * News represents a news from  content.guardianapis.com api
 */

public class News {

    //String for store story details
    String mStory;

    //String for store genre information
    String mType;

    //String for store publication date
    String mPublicationDate;

    //String for store url information
    String mUrl;

    public News(String story, String type, String date, String url) {
        mStory = story;
        mType = type;
        mPublicationDate = date;
        mUrl = url;
    }

    public String getStory() {
        return mStory;
    }

    public String getType() {
        return mType;
    }

    public String getDate() {
        return mPublicationDate;
    }

    public String getUrl() {
        return mUrl;
    }
}
