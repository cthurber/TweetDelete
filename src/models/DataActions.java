package models;

import utils.LinkedTweets;
import utils.Tweet;

public interface DataActions {
	// Add data to the data structure
	public boolean add(Tweet Data);
	
	// Remove an object from the data structure
	public Tweet remove();
	
	// Remove a specific object from the data structure
	public boolean remove(Tweet Data);
	
	// Search for an object in the data structure
	public LinkedTweets search(Tweet term);
	
	// Reset the data structure
	public void clear();	
}
