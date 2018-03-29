package User;

import java.util.ArrayList;
import java.util.List;

import offer.Offer;

public class Guest extends Profile {
	
	private List<Offer> offers;
	
	public Guest() {
		offers = new ArrayList<>();
	}
	
	public void addOffer(Offer o) {
		offers.add(o);
	}
	
	public boolean removeOffer(Offer o) {
		if (offers.remove(o)) {
			return true;
		}
		return false;
	}
	
	public boolean isGuest() {
		return true;
	}
}
