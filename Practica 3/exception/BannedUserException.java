package exception;

import user.RegisteredUser;

/**
 * BannedUserException. It is thrown when an user is banned
 * 
 * @author Miguel Angel Sanchez y Juan Velasco
 *
 */
public class BannedUserException extends Exception {
	private static final long serialVersionUID = 1L;
	private RegisteredUser user;

	/**
	 * Creates a new banned user exception
	 * 
	 * @param u
	 *            Banned user
	 */
	public BannedUserException(RegisteredUser u) {
		this.user = u;
	}

	/**
	 * Get the banned user
	 * 
	 * @return banned user
	 */
	public RegisteredUser getUser() {
		return user;
	}

	/**
	 * toString for the banned user exception
	 */
	public String toString() {
		return "The user " + user + " is banned";
	}
}
