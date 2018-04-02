package exception;

public class NameException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 837449844782823346L;

	public String name;
	
	public NameException(String n) {
		name = n;
	}
	
	public String toString() {
		return "You have a very long name, "+ name;
	}
}
