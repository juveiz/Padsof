package exception;
/**
 * HostException. It is thrown when the user is not a host
 * @author Miguel Angel Sanchez y Juan Velasco
 *
 */
public class HostException extends Exception {
private static final long serialVersionUID = 1L ;
	/**
	 * Creates a new Host exception
	 */
	public HostException() {
	}
	/**
	 * toString for the Host exception
	 */
	public String toString() {
		return "The user is not a host";
	}
}
