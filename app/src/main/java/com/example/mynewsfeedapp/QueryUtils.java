package com.example.mynewsfeedapp;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class QueryUtils {

    /** Sample JSON response for 'the guardian' query
     * For the author details to show, you need to use the "show-tags-contributor" parameter in your URL.*/

    private static final String JSON_RESPONSE = "{\n" +
            "  \"response\": {\n" +
            "    \"status\": \"ok\",\n" +
            "    \"userTier\": \"developer\",\n" +
            "    \"total\": 2192465,\n" +
            "    \"startIndex\": 1,\n" +
            "    \"pageSize\": 10,\n" +
            "    \"currentPage\": 1,\n" +
            "    \"pages\": 219247,\n" +
            "    \"orderBy\": \"newest\",\n" +
            "    \"results\": [\n" +
            "      {\n" +
            "        \"id\": \"lifeandstyle/2020/may/16/what-links-a-cave-bear-with-a-dire-wolf-the-weekend-quiz\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"lifeandstyle\",\n" +
            "        \"sectionName\": \"Life and style\",\n" +
            "        \"webPublicationDate\": \"2020-05-16T06:00:24Z\",\n" +
            "        \"webTitle\": \"What links a cave bear with a dire wolf? The Weekend quiz\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/lifeandstyle/2020/may/16/what-links-a-cave-bear-with-a-dire-wolf-the-weekend-quiz\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/lifeandstyle/2020/may/16/what-links-a-cave-bear-with-a-dire-wolf-the-weekend-quiz\",\n" +
            "        \"isHosted\": false,\n" +
            "        \"pillarId\": \"pillar/lifestyle\",\n" +
            "        \"pillarName\": \"Lifestyle\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"society/2020/may/16/i-flew-to-greece-and-began-solo-ivf-then-the-world-shut-down\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"society\",\n" +
            "        \"sectionName\": \"Society\",\n" +
            "        \"webPublicationDate\": \"2020-05-16T06:00:24Z\",\n" +
            "        \"webTitle\": \"I flew to Greece and began solo IVF. Then the world shut down\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/society/2020/may/16/i-flew-to-greece-and-began-solo-ivf-then-the-world-shut-down\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/society/2020/may/16/i-flew-to-greece-and-began-solo-ivf-then-the-world-shut-down\",\n" +
            "        \"isHosted\": false,\n" +
            "        \"pillarId\": \"pillar/news\",\n" +
            "        \"pillarName\": \"News\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"money/2020/may/16/cash-could-be-the-latest-victim-of-coronavirus-and-may-never-recover\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"money\",\n" +
            "        \"sectionName\": \"Money\",\n" +
            "        \"webPublicationDate\": \"2020-05-16T06:00:23Z\",\n" +
            "        \"webTitle\": \"Cash could be the latest victim of coronavirus – and may never recover | Patrick Collinson\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/money/2020/may/16/cash-could-be-the-latest-victim-of-coronavirus-and-may-never-recover\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/money/2020/may/16/cash-could-be-the-latest-victim-of-coronavirus-and-may-never-recover\",\n" +
            "        \"isHosted\": false,\n" +
            "        \"pillarId\": \"pillar/lifestyle\",\n" +
            "        \"pillarName\": \"Lifestyle\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"travel/2020/may/16/pico-iyer-how-stopover-at-tokyo-airport-japan-changed-my-life\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"travel\",\n" +
            "        \"sectionName\": \"Travel\",\n" +
            "        \"webPublicationDate\": \"2020-05-16T06:00:23Z\",\n" +
            "        \"webTitle\": \"How a stopover at Tokyo airport changed my life | Pico Iyer\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/travel/2020/may/16/pico-iyer-how-stopover-at-tokyo-airport-japan-changed-my-life\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/travel/2020/may/16/pico-iyer-how-stopover-at-tokyo-airport-japan-changed-my-life\",\n" +
            "        \"isHosted\": false,\n" +
            "        \"pillarId\": \"pillar/lifestyle\",\n" +
            "        \"pillarName\": \"Lifestyle\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"books/2020/may/16/tired-of-conversation-a-secret-diary-is-a-great-emotional-outlet-just-ask-adrian-mole\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"books\",\n" +
            "        \"sectionName\": \"Books\",\n" +
            "        \"webPublicationDate\": \"2020-05-16T06:00:23Z\",\n" +
            "        \"webTitle\": \"Tired of conversation? A secret diary is a great emotional outlet – just ask Adrian Mole\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/books/2020/may/16/tired-of-conversation-a-secret-diary-is-a-great-emotional-outlet-just-ask-adrian-mole\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/books/2020/may/16/tired-of-conversation-a-secret-diary-is-a-great-emotional-outlet-just-ask-adrian-mole\",\n" +
            "        \"isHosted\": false,\n" +
            "        \"pillarId\": \"pillar/arts\",\n" +
            "        \"pillarName\": \"Arts\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"money/2020/may/16/should-i-book-a-summer-holiday-lockdown-cottage-campsite\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"money\",\n" +
            "        \"sectionName\": \"Money\",\n" +
            "        \"webPublicationDate\": \"2020-05-16T06:00:23Z\",\n" +
            "        \"webTitle\": \"Should I book a summer holiday despite the lockdown?\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/money/2020/may/16/should-i-book-a-summer-holiday-lockdown-cottage-campsite\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/money/2020/may/16/should-i-book-a-summer-holiday-lockdown-cottage-campsite\",\n" +
            "        \"isHosted\": false,\n" +
            "        \"pillarId\": \"pillar/lifestyle\",\n" +
            "        \"pillarName\": \"Lifestyle\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"us-news/2020/may/16/coronavirus-pandemic-deaths-grieving-invisible\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"us-news\",\n" +
            "        \"sectionName\": \"US news\",\n" +
            "        \"webPublicationDate\": \"2020-05-16T06:00:22Z\",\n" +
            "        \"webTitle\": \"Invisible deaths: from nursing homes to prisons, the corona toll is out of sight – and out of mind?\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/us-news/2020/may/16/coronavirus-pandemic-deaths-grieving-invisible\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/us-news/2020/may/16/coronavirus-pandemic-deaths-grieving-invisible\",\n" +
            "        \"isHosted\": false,\n" +
            "        \"pillarId\": \"pillar/news\",\n" +
            "        \"pillarName\": \"News\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"money/2020/may/16/coronavirus-thousands-of-uk-students-caught-in-rent-trap-by-private-landlords\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"money\",\n" +
            "        \"sectionName\": \"Money\",\n" +
            "        \"webPublicationDate\": \"2020-05-16T06:00:22Z\",\n" +
            "        \"webTitle\": \"Thousands of UK students caught in rent trap by private landlords\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/money/2020/may/16/coronavirus-thousands-of-uk-students-caught-in-rent-trap-by-private-landlords\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/money/2020/may/16/coronavirus-thousands-of-uk-students-caught-in-rent-trap-by-private-landlords\",\n" +
            "        \"isHosted\": false,\n" +
            "        \"pillarId\": \"pillar/lifestyle\",\n" +
            "        \"pillarName\": \"Lifestyle\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"australia-news/live/2020/may/16/coronavirus-australia-live-news-restrictions-health-pandemic-pubs-scott-morrison-economic-nsw-qld-victoria-latest-updates\",\n" +
            "        \"type\": \"liveblog\",\n" +
            "        \"sectionId\": \"australia-news\",\n" +
            "        \"sectionName\": \"Australia news\",\n" +
            "        \"webPublicationDate\": \"2020-05-16T05:59:19Z\",\n" +
            "        \"webTitle\": \"Coronavirus live Australia: 1m tests conducted nationally as restrictions eased in NSW, Queensland and Victoria – latest news\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/australia-news/live/2020/may/16/coronavirus-australia-live-news-restrictions-health-pandemic-pubs-scott-morrison-economic-nsw-qld-victoria-latest-updates\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/australia-news/live/2020/may/16/coronavirus-australia-live-news-restrictions-health-pandemic-pubs-scott-morrison-economic-nsw-qld-victoria-latest-updates\",\n" +
            "        \"isHosted\": false,\n" +
            "        \"pillarId\": \"pillar/news\",\n" +
            "        \"pillarName\": \"News\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"world/live/2020/may/16/coronavirus-live-news-us-deaths-headed-for-100000-by-june-brazil-health-minister-resigns\",\n" +
            "        \"type\": \"liveblog\",\n" +
            "        \"sectionId\": \"world\",\n" +
            "        \"sectionName\": \"World news\",\n" +
            "        \"webPublicationDate\": \"2020-05-16T05:50:50Z\",\n" +
            "        \"webTitle\": \"Coronavirus live news: Democrats pass House bill calling for $3tn stimulus, Brazil health minister quits\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/world/live/2020/may/16/coronavirus-live-news-us-deaths-headed-for-100000-by-june-brazil-health-minister-resigns\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/world/live/2020/may/16/coronavirus-live-news-us-deaths-headed-for-100000-by-june-brazil-health-minister-resigns\",\n" +
            "        \"isHosted\": false,\n" +
            "        \"pillarId\": \"pillar/news\",\n" +
            "        \"pillarName\": \"News\"\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}";
    /**
     * PRIVATE CONSTRUCTOR
     * is created because no one should ever create a {@link QueryUtils} object.
     * To prevent someone creating this constructor by accident.
     * This class is only meant to hold static variables and methods, which can be accessed
     * directly from the class name QueryUtils (and an object instance of QueryUtils is not needed).
     */
    private QueryUtils() {
    }

    /**
     * METHOD (@link extractNews}
     * is created to take in inputs and return an ArrayList
     * Return a list of {@link News} objects that has been built up from
     * parsing a JSON response.
     */
    public static ArrayList<News> extractNews(){
        // If the JSON string is empty or null, then return early.
        if (TextUtils.isEmpty(JSON_RESPONSE)) {
            return null;
        }
        // Create an empty ArrayList that we can start adding data to, and
        // return it at the end of this method
        ArrayList<News> arrayListNewsFeeds = new ArrayList<>();

        // Try to parse the JSON_RESPONSE.
        // If there's a problem with the way the JSON is formatted,
        // an exception object (JSONException} will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.
        try {
            // Create a JSONObject from the JSON response string
            JSONObject baseJsonResponse = new JSONObject(JSON_RESPONSE);

            // Extract the JSONObject associated with the key called "response"
            JSONObject responseJsonObject = baseJsonResponse.getJSONObject("response");

            // Extract the JSONArray associated with the key called "results"
            JSONArray resultsArray = responseJsonObject.getJSONArray("results");

            // For each element in the resultsArray, create a {@link News} object
            for (int i = 0; i < resultsArray.length(); i++) {

                // Get a single news at position i within the list of news
                JSONObject currentNews = resultsArray.getJSONObject(i);

                String title = currentNews.getString("sectionId");
                String news = currentNews.getString("webTitle");
                String date = currentNews.getString("webPublicationDate");
                String url = currentNews.getString("webUrl");

                // For a given news, if it contains the key called "tags", extract JSONArray
                // associated with the key "tags"
                /*
                String author = null;
                if (currentNews.has("tags")) {
                    // Extract the JSONArray associated with the key called "tags"
                    JSONArray tagsArray = currentNews.getJSONArray("tags");
                    if (tagsArray.length() != 0) {
                        // Extract the first JSONObject in the tagsArray
                        JSONObject firstTagsItem = tagsArray.getJSONObject(0);
                        // Extract the value for the key called "webTitle"
                        author = firstTagsItem.getString("webTitle");
                    }
                }*/
                // If the news contains the key called "tags" array to extract the author,
                // than extract using  JSONArray associated with the key "tags"
                String author=null;
                if (currentNews.has("tags")) {
                    JSONArray tags = currentNews.getJSONArray("tags");
                    JSONObject authorName = tags.getJSONObject(0);
                    // Check if tags array is greater than 0
                    if (authorName.length() != 0) {
                        author = authorName.getString("webTitle");
                    }
                }


                // Create a new {@link NewsFeed} object
                News newsList =  new News(title, news, date, author, url);

                // Add the new {@link News} to list of newsList.
                arrayListNewsFeeds.add(newsList);
            }
        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the JSON results", e);
        }

        // Return the list of earthquakes
        return arrayListNewsFeeds;
    }

}
