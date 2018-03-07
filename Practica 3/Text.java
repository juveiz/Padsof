import java.util.*;
public class Text extends Comment {

	private String text;
	private List<Comment> comments;

	public Text(String text,Guest guest) {
		super();
		this.text = text;
		this.guest = guest;
		comments = new ArrayList<Comment>;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public List<Comment> getComments() {
		return comments;
	}

	public void commentComments(String comment, Guest g) {
		Comment c = new Text(comment,g);
		comments.add(c);
	}
	
	public void rateComment(Double rate,Guest g) {
		Comment r = new Rate(rate,g);
		comments.add(r);
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
