package comments;

public abstract class Comment {
	private Guest guest;
	
	public Comment(Guest guest) {
		this.guest = guest;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}
}
