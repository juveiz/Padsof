package comments;
import User.*;
import Exception.*;
public abstract class Comment {
	private RegisteredUser guest;
	
	public Comment(RegisteredUser guest) throws GuestException {
		if (guest.isGuest() == false) {
			GuestException g = new GuestException();
			throw g;
		}
		this.guest = guest;
	}

	public RegisteredUser getGuest() {
		return guest;
	}

}
