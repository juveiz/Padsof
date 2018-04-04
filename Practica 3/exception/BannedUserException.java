package exception;

public class BannedUserException extends Exception {
	private static final long serialVersionUID = 1L ;
	/**
	 * Creates a new Non registered exception
	 */
	public BannedUserException() {
	}
	/**
	 * toString fot the Non registered exception
	 */
	public String toString() {
		return "The user is banned";
	}
}
