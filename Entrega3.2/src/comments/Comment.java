package comments;

import exception.*;
import user.*;

import java.io.Serializable;

/**
 * Comment class. It represents the offer's comments.
 * 
 * @author Miguel Angel Sanchez y Juan Velasco
 *
 */
public abstract class Comment implements Serializable {
	/**
	 * Guest: guest user who makes the comment.
	 */
	private static final long serialVersionUID = 1L;
	private RegisteredUser guest;

	/**
	 * Creates a new Comment
	 * 
	 * @param guest
	 *            User who makes the comment
	 * @throws GuestException
	 *             The user is not a guest
	 */
	public Comment(RegisteredUser guest) throws GuestException {
		this.guest = guest;
	}

	/**
	 * Get the user who makes the comment
	 * 
	 * @return guest
	 */
	public RegisteredUser getGuest() {
		return guest;
	}

	/**
	 * Says if the comment is a text comment
	 * 
	 * @return false
	 */
	public boolean isText() {
		return false;
	}

	/**
	 * Says if the comment is a numerical comment
	 * 
	 * @return false
	 */
	public boolean isNumerical() {
		return false;
	}

	/**
	 * toString form comment
	 */
	public String toString() {
		return "User: " + guest.getName();
	}
}
