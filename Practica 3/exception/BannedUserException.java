package exception;

import user.RegisteredUser;

public class BannedUserException extends Exception {
	private static final long serialVersionUID = 1L ;
	private RegisteredUser user;
	/**
	 * Creates a new Non registered exception
	 */
	public BannedUserException(RegisteredUser u) {
		this.user = u;
	}
	/**
	 * toString fot the Non registered exception
	 */
	public RegisteredUser getUser() {
		return user;
	}
	public String toString() {
		return "The user " + user + " is banned";
	}
}
