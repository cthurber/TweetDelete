package utils;

import models.DataActions;

public class LinkedTweets implements DataActions {
	
	private Node head;
	private int numTweets;
	
	public int getSize() {
		return numTweets;
	}
	
	// Adds a Tweet to the list
	public boolean add(Tweet Data) {
		head = new Node(Data, head);
		numTweets++;
		return true;
	}

	// Returns the tweet removed from the list
	public Tweet remove() {
		Tweet tweetRemoved = head.tweet;
		head = head.next;
		numTweets--;
		return tweetRemoved;
	}

	// Returns whether or not the item was removed from the list
	public boolean remove(Tweet Data) {
		Node n = head;
		Node p = head;
		while(n!=null) {
			if(n.tweet.equals(Data)) {
				return true;
			}
			p=n;
			n=n.next;
		}
		return false;
	}
	
	// Searches the data structure for a note with 'ID'
	public Tweet lookup(Tweet tweet) {
		Node n = head;
		while(n!=null){
			if(n.tweet.equals(tweet)) {
				return n.tweet;
			}
			n=n.next;
		}
		return null;
	}

	public LinkedTweets intersection(LinkedTweets listToMerge) {
		LinkedTweets union = new LinkedTweets();
		Node leadNode;
		Node lendNode;
		
		if(this.getSize() > listToMerge.getSize()) {
			leadNode = listToMerge.head;
			lendNode = this.head;
		} else {
			leadNode = this.head;
			lendNode = listToMerge.head;
		}
		
		while(leadNode!=null){
			Node iterNode = lendNode;
			while(iterNode!=null){
				if(iterNode.tweet.equals(leadNode.tweet)) union.add(iterNode.tweet);
				iterNode = lendNode.next;
			}
			iterNode = lendNode;
			leadNode = leadNode.next;
		}
		
		return union;
	}
	
	public Tweet[] toArray(){
		int numFound = 0;
		Tweet[] tweets = new Tweet[numTweets];
		Node n = head;
		
		for(int i=0; i<numTweets; i++) {
			tweets[i] = n.tweet;
			n=n.next;
		}
		
		return tweets;
	}

	// Searches tweet's text for a search term
	public LinkedTweets search(String term) {
		LinkedTweets matches = new LinkedTweets();
		Tweet[] tweets = this.toArray(); 
		int pivot = (int) tweets.length/2;
		int up = pivot;
		int down = pivot;
		
		while(up>=0 && down<=tweets.length) {
			if(tweets[up].getText().contains(term)) {
				matches.add(tweets[up]);
			}
			if (tweets[down].getText().contains(term)) {
				matches.add(tweets[down]);
			}
			up++;
			down--;
		}
		
		return matches;
	}

	// Currently O(n^2)
	// Searches tweet's text for search terms
	public LinkedTweets search(String[] terms) {
		LinkedTweets matches = new LinkedTweets();
		
		for(String term : terms) {
			LinkedTweets match = search(term);
			matches.intersection(match);
		}
		
		return matches;
	}
	
	
	public void clear() {
		head = null;
		numTweets = 0;
	}
	
	private class Node {
		  private Tweet tweet; // Entry in bag
		  private Node next; // Link to next node

			private Node(Tweet dataPortion) {
				this(dataPortion, null);	
			} // end constructor
			
			private Node(Tweet dataPortion, Node nextNode) {
				tweet = dataPortion;
				next = nextNode;	
			} // end constructor
		} // end Node
	
}
