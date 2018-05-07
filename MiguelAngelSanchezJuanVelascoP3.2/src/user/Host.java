package user;

import java.io.Serializable;
import java.util.*;
import offer.*;

/**
 * Host class. It represents the registered user Host
 * 
 * @author Miguel Angel Sanchez y Juan Velasco
 *
 */
public class Host extends Profile implements Serializable {
	/**
	 * Offers: List of created offers Houses: List of created houses
	 */
	private static final long serialVersionUID = 1L;
	private List<Offer> offers;
	private List<House> houses;

	/**
	 * Creates a new Host profile
	 */
	public Host() {
		offers = new ArrayList<>();
		houses = new ArrayList<>();
	}

	/**
	 * Adds an offer to the Host
	 * 
	 * @param o
	 *            offer to be added
	 */
	public void addOffer(Offer o) {
		offers.add(o);
	}

	/**
	 * Adds a house to the Host
	 * 
	 * @param h
	 *            house to be added
	 */
	public void addHouse(House h) {
		houses.add(h);
	}

	/**
	 * Removes an offer from the Host
	 * 
	 * @param o
	 *            offer to be removed
	 * @return true if it had been removed or false if it is not
	 */
	public boolean removeOffer(Offer o) {
		if (offers.remove(o)) {
			return true;
		}
		return false;
	}

	/**
	 * Removes a house from the Host
	 * 
	 * @param h
	 *            house to be removed
	 * @return true if it had been removed or false if it is not
	 */
	public boolean removeHouse(House h) {
		if (houses.remove(h)) {
			return true;
		}
		return false;
	}

	/**
	 * Says if the profile is a Host
	 * 
	 * @return true
	 */
	public boolean isHost() {
		return true;
	}

	/**
	 * Get the offers from the host
	 * 
	 * @return offers
	 */
	public List<Offer> getOffers() {
		return offers;
	}

	/**
	 * Get the houses from the host
	 * 
	 * @return houses
	 */
	public List<House> getHouses() {
		return houses;
	}
}
