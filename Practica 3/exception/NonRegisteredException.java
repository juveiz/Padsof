package exception;

/**
 * NonRegisteredException. It is thrown when the user is not a registered user
 * 
 * @author Miguel Angel Sanchez y Juan Velasco
 *
 */
public class NonRegisteredException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new Non registered exception
	 */
	public NonRegisteredException() {
	}

	/**
	 * toString for the Non registered exception
	 */
	public String toString() {
		return "The user is not registered";
	}
}
