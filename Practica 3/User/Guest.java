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
}
