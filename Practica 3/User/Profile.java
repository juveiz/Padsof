package User;

import offer.House;
import offer.Offer;

public abstract class Profile {
	
	public void addOffer(Offer o) {};
	
	public void addHouse(House h) {};
	
	public boolean removeOffer(Offer o) {
		return false;
	}
	
	public boolean removeHouse(House h) {
		return false;
	}
	
	public boolean isGuest() {
		return false;
	}
	
	public boolean isHost() {
		return false;
	}
}
