package exception;
/**
 * GuestException. It is thrown when a user is not a guest
 * @author Miguel Angel Sanchez y Juan Velasco
 *
 */
public class GuestException extends Exception {
	private static final long serialVersionUID = 1L ;
	/**
	 * Creates a new guest exception
	 */
	public GuestException() {
	}
	/**
	 * toString for the exception
	 */
	public String toString() {
		return "The user is not a guest";
	}
}
