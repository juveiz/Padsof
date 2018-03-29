package comments;

import java.util.*;
import User.*;
import Exception.*;

public class Text extends Comment {

	private String text;
	private List<Comment> comments;

	public Text(String text,RegisteredUser guest) throws GuestException {
		super(guest);
		this.text = text;
		comments = new ArrayList<Comment>();
	}
	
	public String getText() {
		return text;
	}
	
	public List<Comment> getComments() {
		return comments;
	}

	public void commentComments(String comment, RegisteredUser g) throws GuestException {
		Comment c = new Text(comment,g);
		comments.add(c);
	}
	
	public void rateComment(double rate,RegisteredUser g) throws GuestException {
		Comment r = new Numerical(rate,g);
		comments.add(r);
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
