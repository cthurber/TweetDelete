package utils;

public class Tweet {
	
	private String id;
	private String text;
	private String date;

	public Tweet(String ID, String Text, String Date) {
		id = ID;
		text = Text;
		date = Date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
