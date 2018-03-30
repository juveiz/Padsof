package Exception;

public class NonRegisteredException extends Exception {
private static final long serialVersionUID = 1L ;
	
	public NonRegisteredException() {
	}
	
	public String toString() {
		return "The user is not registered";
	}
}
