package exception;

/**
 * LoggedException. It is thrown when another user is logged
 * 
 * @author juvei
 *
 */
public class LoggedException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new logged exception
	 */
	public LoggedException() {
	}

	/**
	 * toString for the Logged exception
	 */
	public String toString() {
		return "A user is already logged.";
	}
}
