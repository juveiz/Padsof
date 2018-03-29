package Exception;

public class HostException extends Exception {
private static final long serialVersionUID = 1L ;
	
	public HostException() {
	}
	
	public String toString() {
		return "The user is not a host";
	}
}
