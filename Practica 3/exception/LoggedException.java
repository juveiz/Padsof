package exception;

public class LoggedException extends Exception {
	private static final long serialVersionUID = 1L ;
	/**
	 * Creates a new Host exception
	 */
	public LoggedException() {
	}
	/**
	 * toString for the Host exception
	 */
	public String toString() {
		return "A user is already logged.";
	}
}
