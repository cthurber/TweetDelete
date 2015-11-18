package utils;

public class Tweet {
	
	private String id;
	private String text;
	private String date;

	public Tweet(String ID, String Date, String Text) {
		id = ID;
		date = Date;
		text = Text;
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
