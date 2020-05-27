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
/*
    private static final String JSON_RESPONSE = "{\n" +
            "  \"response\": {\n" +
            "    \"status\": \"ok\",\n" +
            "    \"userTier\": \"developer\",\n" +
            "    \"total\": 35506,\n" +
            "    \"startIndex\": 1,\n" +
            "    \"pageSize\": 10,\n" +
            "    \"currentPage\": 1,\n" +
            "    \"pages\": 3551,\n" +
            "    \"orderBy\": \"relevance\",\n" +
            "    \"results\": [\n" +
            "      {\n" +
            "        \"id\": \"football/2020/may/14/football-quiz-world-cup-heroes-club-careers\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"football\",\n" +
            "        \"sectionName\": \"Football\",\n" +
            "        \"webPublicationDate\": \"2020-05-14T09:13:28Z\",\n" +
            "        \"webTitle\": \"Football quiz: World Cup heroes' club careers\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/football/2020/may/14/football-quiz-world-cup-heroes-club-careers\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/football/2020/may/14/football-quiz-world-cup-heroes-club-careers\",\n" +
            "        \"tags\": [\n" +
            "          {\n" +
            "            \"id\": \"profile/niall-mcveigh\",\n" +
            "            \"type\": \"contributor\",\n" +
            "            \"webTitle\": \"Niall McVeigh\",\n" +
            "            \"webUrl\": \"https://www.theguardian.com/profile/niall-mcveigh\",\n" +
            "            \"apiUrl\": \"https://content.guardianapis.com/profile/niall-mcveigh\",\n" +
            "            \"references\": [],\n" +
            "            \"bio\": \"<p>Niall McVeigh is a freelance football writer. He recently won the Guardian's Who wants to be an MBM-er? competition</p>\",\n" +
            "            \"firstName\": \"mcveigh\",\n" +
            "            \"lastName\": \"niall\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"isHosted\": false,\n" +
            "        \"pillarId\": \"pillar/sport\",\n" +
            "        \"pillarName\": \"Sport\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"football/2020/mar/26/football-quiz-guess-missing-clubs-goalkeepers-career-paths\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"football\",\n" +
            "        \"sectionName\": \"Football\",\n" +
            "        \"webPublicationDate\": \"2020-03-26T15:27:28Z\",\n" +
            "        \"webTitle\": \"Football quiz: guess the missing clubs in these goalkeepers' careers\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/football/2020/mar/26/football-quiz-guess-missing-clubs-goalkeepers-career-paths\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/football/2020/mar/26/football-quiz-guess-missing-clubs-goalkeepers-career-paths\",\n" +
            "        \"tags\": [\n" +
            "          {\n" +
            "            \"id\": \"profile/niall-mcveigh\",\n" +
            "            \"type\": \"contributor\",\n" +
            "            \"webTitle\": \"Niall McVeigh\",\n" +
            "            \"webUrl\": \"https://www.theguardian.com/profile/niall-mcveigh\",\n" +
            "            \"apiUrl\": \"https://content.guardianapis.com/profile/niall-mcveigh\",\n" +
            "            \"references\": [],\n" +
            "            \"bio\": \"<p>Niall McVeigh is a freelance football writer. He recently won the Guardian's Who wants to be an MBM-er? competition</p>\",\n" +
            "            \"firstName\": \"mcveigh\",\n" +
            "            \"lastName\": \"niall\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"isHosted\": false,\n" +
            "        \"pillarId\": \"pillar/sport\",\n" +
            "        \"pillarName\": \"Sport\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"world/2020/apr/06/ministers-seeking-to-smear-civil-servants-over-coronavirus-handling\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"world\",\n" +
            "        \"sectionName\": \"World news\",\n" +
            "        \"webPublicationDate\": \"2020-04-06T14:23:12Z\",\n" +
            "        \"webTitle\": \"UK ministers accused of prioritising careers over lives of coronavirus victims\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/world/2020/apr/06/ministers-seeking-to-smear-civil-servants-over-coronavirus-handling\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/world/2020/apr/06/ministers-seeking-to-smear-civil-servants-over-coronavirus-handling\",\n" +
            "        \"tags\": [\n" +
            "          {\n" +
            "            \"id\": \"profile/rajeev-syal\",\n" +
            "            \"type\": \"contributor\",\n" +
            "            \"webTitle\": \"Rajeev Syal\",\n" +
            "            \"webUrl\": \"https://www.theguardian.com/profile/rajeev-syal\",\n" +
            "            \"apiUrl\": \"https://content.guardianapis.com/profile/rajeev-syal\",\n" +
            "            \"references\": [],\n" +
            "            \"bio\": \"<p>Rajeev Syal covers Whitehall and works on off-diary stories from the lobby for the Guardian</p>\",\n" +
            "            \"bylineImageUrl\": \"https://uploads.guim.co.uk/2017/12/27/Rajeev-Syal.jpg\",\n" +
            "            \"bylineLargeImageUrl\": \"https://uploads.guim.co.uk/2017/12/27/Rajeev_Syal,_R.png\",\n" +
            "            \"firstName\": \"Rajeev\",\n" +
            "            \"lastName\": \"Syal\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"isHosted\": false,\n" +
            "        \"pillarId\": \"pillar/news\",\n" +
            "        \"pillarName\": \"News\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"world/2020/apr/07/politicians-and-public-figures-return-to-medical-careers-to-help-coronavirus-effort\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"world\",\n" +
            "        \"sectionName\": \"World news\",\n" +
            "        \"webPublicationDate\": \"2020-04-07T04:00:15Z\",\n" +
            "        \"webTitle\": \"Politicians and public figures return to medical careers to help coronavirus effort\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/world/2020/apr/07/politicians-and-public-figures-return-to-medical-careers-to-help-coronavirus-effort\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/world/2020/apr/07/politicians-and-public-figures-return-to-medical-careers-to-help-coronavirus-effort\",\n" +
            "        \"tags\": [\n" +
            "          {\n" +
            "            \"id\": \"profile/rorycarroll\",\n" +
            "            \"type\": \"contributor\",\n" +
            "            \"webTitle\": \"Rory Carroll\",\n" +
            "            \"webUrl\": \"https://www.theguardian.com/profile/rorycarroll\",\n" +
            "            \"apiUrl\": \"https://content.guardianapis.com/profile/rorycarroll\",\n" +
            "            \"references\": [],\n" +
            "            \"bio\": \"<p>Rory Carroll is the Guardian's Ireland correspondent. Click <a href=\\\"https://www.theguardian.com/pgp/PublicKeys/Rory%20Carroll.pub.txt\\\">here</a> for Rory's public key. Twitter&nbsp;<a href=\\\"https://twitter.com/rorycarroll72\\\">@rorycarroll72</a></p>\",\n" +
            "            \"bylineImageUrl\": \"https://static.guim.co.uk/sys-images/Guardian/Pix/contributor/2014/11/14/1415969428559/Rory-Carroll.jpg\",\n" +
            "            \"bylineLargeImageUrl\": \"https://uploads.guim.co.uk/2017/10/09/Rory-Carroll,-L.png\",\n" +
            "            \"firstName\": \"Carroll\",\n" +
            "            \"lastName\": \"Rory\",\n" +
            "            \"twitterHandle\": \"rorycarroll72\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": \"profile/kim-willsher\",\n" +
            "            \"type\": \"contributor\",\n" +
            "            \"webTitle\": \"Kim Willsher\",\n" +
            "            \"webUrl\": \"https://www.theguardian.com/profile/kim-willsher\",\n" +
            "            \"apiUrl\": \"https://content.guardianapis.com/profile/kim-willsher\",\n" +
            "            \"references\": [],\n" +
            "            \"bio\": \"<p>Kim Willsher is an award-winning foreign correspondent based in Paris</p>\",\n" +
            "            \"bylineImageUrl\": \"https://static.guim.co.uk/sys-images/Guardian/Pix/pictures/2011/9/30/1317399986248/kim.jpg\",\n" +
            "            \"firstName\": \"willsher\",\n" +
            "            \"lastName\": \"kim\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": \"profile/jennifer-rankin\",\n" +
            "            \"type\": \"contributor\",\n" +
            "            \"webTitle\": \"Jennifer Rankin\",\n" +
            "            \"webUrl\": \"https://www.theguardian.com/profile/jennifer-rankin\",\n" +
            "            \"apiUrl\": \"https://content.guardianapis.com/profile/jennifer-rankin\",\n" +
            "            \"references\": [],\n" +
            "            \"bylineImageUrl\": \"https://uploads.guim.co.uk/2017/12/26/Jennifer-Rankin.jpg\",\n" +
            "            \"bylineLargeImageUrl\": \"https://uploads.guim.co.uk/2017/12/26/Jennifer_Rankin,_L.png\",\n" +
            "            \"firstName\": \"Jennifer\",\n" +
            "            \"lastName\": \"Rankin\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"isHosted\": false,\n" +
            "        \"pillarId\": \"pillar/news\",\n" +
            "        \"pillarName\": \"News\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"football/2020/apr/05/finishing-school-fortuna-sittard-young-players-brighton-george-cox-english-youngsters-abroad\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"football\",\n" +
            "        \"sectionName\": \"Football\",\n" +
            "        \"webPublicationDate\": \"2020-04-05T11:00:26Z\",\n" +
            "        \"webTitle\": \"Finishing school: how Fortuna Sittard are giving a boost to young careers\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/football/2020/apr/05/finishing-school-fortuna-sittard-young-players-brighton-george-cox-english-youngsters-abroad\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/football/2020/apr/05/finishing-school-fortuna-sittard-young-players-brighton-george-cox-english-youngsters-abroad\",\n" +
            "        \"tags\": [\n" +
            "          {\n" +
            "            \"id\": \"profile/will-unwin\",\n" +
            "            \"type\": \"contributor\",\n" +
            "            \"webTitle\": \"Will Unwin\",\n" +
            "            \"webUrl\": \"https://www.theguardian.com/profile/will-unwin\",\n" +
            "            \"apiUrl\": \"https://content.guardianapis.com/profile/will-unwin\",\n" +
            "            \"references\": [],\n" +
            "            \"bio\": \"<p>Will is a freelance journalist</p>\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"isHosted\": false,\n" +
            "        \"pillarId\": \"pillar/sport\",\n" +
            "        \"pillarName\": \"Sport\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"world/2019/oct/28/women-paid-less-than-men-over-careers-gender-pay-gap-report\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"world\",\n" +
            "        \"sectionName\": \"World news\",\n" +
            "        \"webPublicationDate\": \"2019-10-28T12:17:53Z\",\n" +
            "        \"webTitle\": \"Women paid £260,000 less than men over their careers – report\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/world/2019/oct/28/women-paid-less-than-men-over-careers-gender-pay-gap-report\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/world/2019/oct/28/women-paid-less-than-men-over-careers-gender-pay-gap-report\",\n" +
            "        \"tags\": [\n" +
            "          {\n" +
            "            \"id\": \"profile/patrickcollinson\",\n" +
            "            \"type\": \"contributor\",\n" +
            "            \"webTitle\": \"Patrick Collinson\",\n" +
            "            \"webUrl\": \"https://www.theguardian.com/profile/patrickcollinson\",\n" +
            "            \"apiUrl\": \"https://content.guardianapis.com/profile/patrickcollinson\",\n" +
            "            \"references\": [],\n" +
            "            \"bio\": \"<p>Patrick Collinson is money editor of the Guardian and the newspaper's personal finance editor</p>\",\n" +
            "            \"bylineImageUrl\": \"https://static.guim.co.uk/sys-images/Guardian/Pix/contributor/2014/5/23/1400851508217/Patrick-Collinson.jpg\",\n" +
            "            \"bylineLargeImageUrl\": \"https://uploads.guim.co.uk/2017/10/09/Patrick-Collinson,-R.png\",\n" +
            "            \"firstName\": \"Patrick \",\n" +
            "            \"lastName\": \"Collinson\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"isHosted\": false,\n" +
            "        \"pillarId\": \"pillar/news\",\n" +
            "        \"pillarName\": \"News\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"music/2019/nov/08/new-entry-at-84-why-are-one-directions-solo-careers-stalling\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"music\",\n" +
            "        \"sectionName\": \"Music\",\n" +
            "        \"webPublicationDate\": \"2019-11-08T13:00:30Z\",\n" +
            "        \"webTitle\": \"‘New entry at 84’: why are One Direction's solo careers stalling?\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/music/2019/nov/08/new-entry-at-84-why-are-one-directions-solo-careers-stalling\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/music/2019/nov/08/new-entry-at-84-why-are-one-directions-solo-careers-stalling\",\n" +
            "        \"tags\": [\n" +
            "          {\n" +
            "            \"id\": \"profile/michaelcragg\",\n" +
            "            \"type\": \"contributor\",\n" +
            "            \"webTitle\": \"Michael Cragg\",\n" +
            "            \"webUrl\": \"https://www.theguardian.com/profile/michaelcragg\",\n" +
            "            \"apiUrl\": \"https://content.guardianapis.com/profile/michaelcragg\",\n" +
            "            \"references\": [],\n" +
            "            \"bio\": \"<p>Michael Cragg\\n is a music writer for the Guardian and Observer as well as contributing\\n to i-D, Fader and Q. He's also the editor of BEAT magazine.&nbsp; <br></p>\",\n" +
            "            \"bylineImageUrl\": \"https://uploads.guim.co.uk/2019/06/28/Michael_Cragg.jpg\",\n" +
            "            \"firstName\": \"Michael\",\n" +
            "            \"lastName\": \"Cragg\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"isHosted\": false,\n" +
            "        \"pillarId\": \"pillar/arts\",\n" +
            "        \"pillarName\": \"Arts\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"australia-news/2019/dec/05/the-block-star-scott-cam-to-be-paid-345000-as-national-careers-ambassador\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"australia-news\",\n" +
            "        \"sectionName\": \"Australia news\",\n" +
            "        \"webPublicationDate\": \"2019-12-05T23:26:46Z\",\n" +
            "        \"webTitle\": \"The Block star Scott Cam to be paid $345,000 as national careers ambassador\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/australia-news/2019/dec/05/the-block-star-scott-cam-to-be-paid-345000-as-national-careers-ambassador\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/australia-news/2019/dec/05/the-block-star-scott-cam-to-be-paid-345000-as-national-careers-ambassador\",\n" +
            "        \"tags\": [\n" +
            "          {\n" +
            "            \"id\": \"profile/paul-karp\",\n" +
            "            \"type\": \"contributor\",\n" +
            "            \"webTitle\": \"Paul Karp\",\n" +
            "            \"webUrl\": \"https://www.theguardian.com/profile/paul-karp\",\n" +
            "            \"apiUrl\": \"https://content.guardianapis.com/profile/paul-karp\",\n" +
            "            \"references\": [],\n" +
            "            \"bio\": \"<p>Paul Karp is a reporter for Guardian Australia. Email: paul.karp@theguardian.com</p>\",\n" +
            "            \"bylineImageUrl\": \"https://static.guim.co.uk/sys-images/Guardian/Pix/contributor/2016/2/11/1455181696016/Paul-Karp.jpg\",\n" +
            "            \"bylineLargeImageUrl\": \"https://uploads.guim.co.uk/2017/10/09/Paul-Karp,-L.png\",\n" +
            "            \"firstName\": \"Paul\",\n" +
            "            \"lastName\": \"Karp\",\n" +
            "            \"twitterHandle\": \"Paul_Karp\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"isHosted\": false,\n" +
            "        \"pillarId\": \"pillar/news\",\n" +
            "        \"pillarName\": \"News\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"sport/2019/nov/12/richard-hadlee-brilliance-bravado-cricket-career-the-spin\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"sport\",\n" +
            "        \"sectionName\": \"Sport\",\n" +
            "        \"webPublicationDate\": \"2019-11-12T11:09:54Z\",\n" +
            "        \"webTitle\": \"The Spin | Richard Hadlee put brilliance above bravado in one of the greatest careers\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/sport/2019/nov/12/richard-hadlee-brilliance-bravado-cricket-career-the-spin\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/sport/2019/nov/12/richard-hadlee-brilliance-bravado-cricket-career-the-spin\",\n" +
            "        \"tags\": [\n" +
            "          {\n" +
            "            \"id\": \"profile/danielharris\",\n" +
            "            \"type\": \"contributor\",\n" +
            "            \"webTitle\": \"Daniel Harris\",\n" +
            "            \"webUrl\": \"https://www.theguardian.com/profile/danielharris\",\n" +
            "            \"apiUrl\": \"https://content.guardianapis.com/profile/danielharris\",\n" +
            "            \"references\": [],\n" +
            "            \"bio\": \"<p>Daniel Harris was nominated for columnist of the year at the 2015 SJA awards. He has written two books,&nbsp;<a href=\\\"http://www.amazon.co.uk/On-Road-Journey-Through-Season-x/dp/0956594409/\\\">On The Road, a journey through a  season</a> and <a href=\\\"http://www.amazon.co.uk/Promised-Land-Manchester-Uniteds-Historic/dp/1909715050/ref=asap_bc?ie=UTF8\\\">The Promised Land</a>;&nbsp;helped Kevin Pietersen with&nbsp;<a href=\\\"https://www.amazon.co.uk/Kevin-Pietersen-Cricket-toughest-opponents/dp/0751562041\\\">Kevin Pietersen on Cricket</a>; and co-directed <a href=\\\"https://www.amazon.co.uk/House-Flying-Arrows-Daniel-Mendelle/dp/B01KO7G9CQ/ref=sr_1_1?s=dvd&amp;ie=UTF8&amp;qid=1490024666&amp;sr=1-1&amp;keywords=house+of+flying+arrows\\\">House of Flying Arrows</a> for Universal Pictures. He is now co-writing a <a href=\\\"http://www.boxingnews24.com/2017/04/fulwell-73-announce-benn-v-eubank-biopic/\\\">scripted feature on the lives of Nigel Benn and Chris Eubank</a> for Lorton Entertaniment</p>\",\n" +
            "            \"bylineImageUrl\": \"https://static.guim.co.uk/sys-images/Guardian/Pix/pictures/2011/4/5/1302019018185/Daniel_Harries.jpg\",\n" +
            "            \"firstName\": \"harris\",\n" +
            "            \"lastName\": \"\",\n" +
            "            \"twitterHandle\": \"DanielHarris\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"isHosted\": false,\n" +
            "        \"pillarId\": \"pillar/sport\",\n" +
            "        \"pillarName\": \"Sport\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"film/filmblog/2020/feb/06/kirk-douglas-a-career-in-clips\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"film\",\n" +
            "        \"sectionName\": \"Film\",\n" +
            "        \"webPublicationDate\": \"2020-02-06T06:00:31Z\",\n" +
            "        \"webTitle\": \"Kirk Douglas: a career in clips\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/film/filmblog/2020/feb/06/kirk-douglas-a-career-in-clips\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/film/filmblog/2020/feb/06/kirk-douglas-a-career-in-clips\",\n" +
            "        \"tags\": [\n" +
            "          {\n" +
            "            \"id\": \"profile/andrewpulver\",\n" +
            "            \"type\": \"contributor\",\n" +
            "            \"webTitle\": \"Andrew Pulver\",\n" +
            "            \"webUrl\": \"https://www.theguardian.com/profile/andrewpulver\",\n" +
            "            \"apiUrl\": \"https://content.guardianapis.com/profile/andrewpulver\",\n" +
            "            \"references\": [],\n" +
            "            \"bio\": \"<p>Andrew Pulver is Film editor, guardian.co.uk</p>\",\n" +
            "            \"bylineImageUrl\": \"https://static.guim.co.uk/sys-images/Guardian/Pix/contributor/2015/9/30/1443601844139/Andrew-Pulver.jpg\",\n" +
            "            \"bylineLargeImageUrl\": \"https://uploads.guim.co.uk/2017/10/06/Andrew-Pulver,-L.png\",\n" +
            "            \"firstName\": \"pulver\",\n" +
            "            \"lastName\": \"\",\n" +
            "            \"twitterHandle\": \"Andrew_Pulver\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"isHosted\": false,\n" +
            "        \"pillarId\": \"pillar/arts\",\n" +
            "        \"pillarName\": \"Arts\"\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}";
             */
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
