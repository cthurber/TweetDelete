package models;

import utils.LinkedTweets;
import utils.Tweet;

public interface DataActions {
	
	// Returns size of data structure
	public int getSize();
	
	// Add data to the data structure
	public boolean add(Tweet Data);
	
	// Remove an object from the data structure
	public Tweet remove();
	
	// Remove a specific object from the data structure
	public boolean remove(Tweet Data);
	
	// Searches the data structure for a note with 'ID'
	public Tweet lookup(Tweet tweet);
	
	// Converts the data structure to an array for faster searching
	public Tweet[] toArray();
	
	// Search for an object in the data structure
	public LinkedTweets search(String term);
	
	// Search for multiple objects in the data structure
	public LinkedTweets search(String[] terms);
	
	// Reset the data structure
	public void clear();	
}
