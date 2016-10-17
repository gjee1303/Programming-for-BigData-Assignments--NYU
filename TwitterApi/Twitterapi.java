/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitterapi;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.in;
import java.util.List;
import java.util.logging.Level;
import twitter4j.*;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.TwitterFactory;

/**
 *
 * @author MonilShah
 */
public class Twitterapi {

    /**
     * @param args the command line arguments
     */
 /* 
    
}*/
    public static void main(String[] args) throws TwitterException, IOException {
        
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
          .setOAuthConsumerKey("JalTD3urWpCTJYbdhMerTtlEr")
          .setOAuthConsumerSecret("P7xRVsVJ0iPqc0lJePwuMfQ2iKtxjuK8DoOihCV4sN3mM0Vywm")
          .setOAuthAccessToken("2498948928-fwJBmOOA93hxYqjDMgx7mQCH1HK8xNvJbuDn2Kw")
          .setOAuthAccessTokenSecret("fHhHYhKHA0jm5aWeKA1RJ1qWR4AhkS1KMX8Kr8iMqIjMZ");
   //     
        TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
        
         
        String newLine = System.getProperty("line.separator");
       
        StatusListener listener;
        listener = new StatusListener() {
          //   int count=0;
            @Override
            public void onStatus(Status status) {
               
                BufferedWriter output = null;
                    File file = new File("output_tweets.txt");
                try {
                    output = new BufferedWriter(new FileWriter(file,true));
                } catch (IOException ex) {
                    java.util.logging.Logger.getLogger(Twitterapi.class.getName()).log(Level.SEVERE, null, ex);
                }
              
                
                    
               
                    
                try{
                   

                  
                        output.write(status.getUser().getScreenName()+" : "+status.getText()+ newLine);
                        output.close();
                   
                    
                } catch (IOException ex) {
                    java.util.logging.Logger.getLogger(Twitterapi.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
               // System.out.println("Got a status deletion notice id:" + statusDeletionNotice.getStatusId());
            }

            @Override
            public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
                System.out.println("Got track limitation notice:" + numberOfLimitedStatuses);
            }

            @Override
            public void onScrubGeo(long userId, long upToStatusId) {
                System.out.println("Got scrub_geo event userId:" + userId + " upToStatusId:" + upToStatusId);
            }

            @Override
            public void onStallWarning(StallWarning warning) {
                System.out.println("Got stall warning:" + warning);
            }

            @Override
            public void onException(Exception ex) {
                ex.printStackTrace();
            }
           
        };
        
    //     
        twitterStream.addListener(listener);
        twitterStream.sample();
    }
}
