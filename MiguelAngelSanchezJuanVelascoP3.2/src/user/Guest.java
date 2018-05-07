package user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import offer.Offer;

/**
 * Guest class. It represents the registered user Guests.
 * 
 * @author Miguel Angel Sanchez y Juan Velasco
 *
 */
public class Guest extends Profile implements Serializable {
	/**
	 * Offers: List of reserved offers
	 */
	private static final long serialVersionUID = 1L;
	private List<Offer> offers;

	/**
	 * Creates a new Guest profile
	 */
	public Guest() {
		offers = new ArrayList<>();
	}

	/**
	 * Add and offer to the Guest
	 * 
	 * @param o
	 *            Offer to add
	 */
	public void addOffer(Offer o) {
		offers.add(o);
	}

	/**
	 * Removes an offer from the Guest
	 * 
	 * @return true o false
	 */
	public boolean removeOffer(Offer o) {
		if (offers.remove(o)) {
			return true;
		}
		return false;
	}

	/**
	 * Says if the profile is a Guest
	 * 
	 * @return True
	 */
	public boolean isGuest() {
		return true;
	}

	/**
	 * Get the offer for the guest
	 * 
	 * @return offers
	 */
	public List<Offer> getOffers() {
		return offers;
	}
}
