package Exception;

public class GuestException extends Exception {
	private static final long serialVersionUID = 1L ;
	
	public GuestException() {
	}
	
	public String toString() {
		return "The user is not a guest";
	}
}
