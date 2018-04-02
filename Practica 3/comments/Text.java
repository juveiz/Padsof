package comments;

import java.io.Serializable;
import java.util.*;
import User.*;
import Exception.*;

/**
 * Text class. It represents the text comments
 * @author Miguel Angel Sanchez y Juan Velasco
 *
 */
public class Text extends Comment implements Serializable{
	/**
	 * Text: Text of the comment
	 * Comments: Comments to the comment
	 */
	private static final long serialVersionUID = 1L;
	private String text;
	private List<Comment> comments;
	
	/**
	 * Creates a new text comment
	 * @param text Text of the comment
	 * @param guest User who writes the comment
	 * @throws GuestException The user is not a guest
	 */
	public Text(String text,RegisteredUser guest) throws GuestException {
		super(guest);
		this.text = text;
		comments = new ArrayList<Comment>();
	}
	/**
	 * Gets the text of the comment
	 * @return text
	 */
	public String getText() {
		return text;
	}
	/**
	 * Gets the list of comments to the comment
	 * @return Comments
	 */
	public List<Comment> getComments() {
		return comments;
	}
	/**
	 * Comment a comment
	 * @param comment Text of the comment
	 * @param g User who makes the comment
	 * @throws GuestException THe user is not a guest
	 */
	public void commentComments(String comment, RegisteredUser g) throws GuestException {
		Comment c = new Text(comment,g);
		comments.add(c);
	}
	/**
	 * Rate a comment
	 * @param rate Rate of the comment
	 * @param g User who makes the rate
	 * @throws GuestException The user is not a guest
	 */
	public void rateComment(double rate,RegisteredUser g) throws GuestException {
		Comment r = new Numerical(rate,g);
		comments.add(r);
	}

	public boolean isText() {
		return true;
	}
}
