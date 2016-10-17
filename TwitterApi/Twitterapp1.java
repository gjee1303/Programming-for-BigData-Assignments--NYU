/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitterapp1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import twitter4j.*;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.TwitterFactory;
/**
 *
 * @author MonilShah
 */
public class Twitterapp1  {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws TwitterException, IOException {
        // TODO code application logic here
        ConfigurationBuilder cb = new ConfigurationBuilder();
        BufferedWriter output = null;
        BufferedWriter output1 = null;
 // Enabling OAuth Authentication for Twitter Apps
        cb.setDebugEnabled(true)
          .setOAuthConsumerKey("JalTD3urWpCTJYbdhMerTtlEr")
          .setOAuthConsumerSecret("P7xRVsVJ0iPqc0lJePwuMfQ2iKtxjuK8DoOihCV4sN3mM0Vywm")
          .setOAuthAccessToken("2498948928-fwJBmOOA93hxYqjDMgx7mQCH1HK8xNvJbuDn2Kw")
          .setOAuthAccessTokenSecret("fHhHYhKHA0jm5aWeKA1RJ1qWR4AhkS1KMX8Kr8iMqIjMZ");
        
 // Getting TwitterFactory instance
        Twitter twitter = new TwitterFactory(cb.build()).getInstance();
  //Recent Tweets from TimeLine
        List<Status> statuses = twitter.getHomeTimeline();
        File file = new File("output_tweets.txt");
        File file1 = new File("output_search.txt");
        output = new BufferedWriter(new FileWriter(file));
        output1 = new BufferedWriter(new FileWriter(file1));
        String newLine = System.getProperty("line.separator");
        for(Status st : statuses)
        {
             String text1 = st.getUser().getName()+" : "+st.getText()+ newLine;
  // Appending results to output file
             output.write(text1);
        }
        output.close();
        try {
  // Using Twitter API to get tweets related to specified Query
            Query query = new Query("Narendra Modi");
            QueryResult result;
            do {
                result = twitter.search(query);
  // Getting tweets for Query
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                    String text= "@" + tweet.getUser().getScreenName() + " - " + tweet.getText()+newLine;
   // Appending results to output file
                    output1.write(text);

                }
            } while ((query = result.nextQuery()) != null);
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }
        output1.close();
    }
    }

   
    

