package utils;

import models.DataActions;

public class LinkedTweets implements DataActions {
	
	private Node head;
	private int numTweets = 0;

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

	@Override
	public LinkedTweets search(Tweet term) {
		LinkedTweets q = new LinkedTweets();
		Node n = head;
		
		while(n!=null) {
			if(n.tweet.getText().contains(term.getText())) {
				q.add(n.tweet);
				this.remove(n.tweet);
			}
			n=n.next;
		}
		return q;
	}

	@Override
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
