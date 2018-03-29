package User;

import java.util.*;
import offer.*;

public class Host extends Profile {
	private List<Offer> offers;
	private List<House> houses;
	
	public Host () {
		offers = new ArrayList<>();
		houses = new ArrayList<>();
	}
	
	public void addOffer(Offer o) {
		offers.add(o);
	}
	
	public void addHouse(House h) {
		houses.add(h);
	}
	
	public boolean removeOffer(Offer o) {
		if (offers.remove(o)) {
			return true;
		}
		return false;
	}
	
	public boolean removeHouse(House h) {
		if (houses.remove(h)) {
			return true;
		}
		return false;
	}
	
	public boolean isHost() {
		return true;
	}
}
