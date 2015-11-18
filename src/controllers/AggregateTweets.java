package controllers;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

import utils.LinkedTweets;
import utils.Tweet;
import models.Aggregate;

public class AggregateTweets implements Aggregate {
	
	private LinkedTweets fileContents = new LinkedTweets();
	private LinkedTweets filteredContents = new LinkedTweets();
	
	// Reads specific columns from rows of CSV file into 'fileContents', returns number of lines read 
	public int readFile(String filename) throws IOException {
		CSVReader reader = new CSVReader(new FileReader(filename), ',' , '"' , 1);
		
	    //Read CSV line by line and use the string array as you want
	    String[] nextLine;
	    while ((nextLine = reader.readNext()) != null) {
	       if (nextLine != null) {
			  String id = nextLine[0];		// Tweets ID
			  String date = nextLine[3];	// Date tweeted
			  String text = nextLine[5];	// Tweet contents/text
			  Tweet tweet = new Tweet(id, date, text);
			  System.out.println("\n"+tweet.getId()+" : "+tweet.getText());
			  fileContents.add(tweet);
	       }
	    }
		return (int) reader.getLinesRead();
	}
	
	// Filters contents based on parameters
	public int filter(String[] parameters) {
		
		if(parameters.length == 1) {
			filteredContents = fileContents.search(parameters[0]);
		} else {
			filteredContents = fileContents.search(parameters);
		}
		
		return filteredContents.getSize();
	}
	
	public static void main(String[] args) throws Exception {
		AggregateTweets thing = new AggregateTweets();
		thing.readFile("tweets.csv");
		String[] searchTerms = {"cool"};
		thing.filter(searchTerms);
		for(Tweet t : thing.filteredContents.toArray()) {
			System.out.println(t.getText());
		}
	}
	
}
