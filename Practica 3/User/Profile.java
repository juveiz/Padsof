package User;

import offer.House;
import offer.Offer;
/**
 * Profile class. It represents the type of registered user
 * @author Miguel Angel Sanchez y Juan Velasco
 *
 */
public abstract class Profile {
	/**
	 * Add an offer to the profile. It will be used in its sons.
	 * @param o House to add
	 */
	public void addOffer(Offer o) {};
	/**
	 * Add a house to the profile. It will be used in its sons.
	 * @param h
	 */
	public void addHouse(House h) {};
	/**
	 * Removes an offer from the profile.
	 * @param o Offer to be removed
	 * @return true if you can remove the offer or false if the offer is not in the profile
	 */
	public boolean removeOffer(Offer o) {
		return false;
	}
	/**
	 * Removes a house from the profile.
	 * @param h House to be removed
	 * @return true if you can remove the house or false if the house is not in the profile
	 */
	public boolean removeHouse(House h) {
		return false;
	}
	/**
	 * Says if the profile is Guest
	 * @return false
	 */
	public boolean isGuest() {
		return false;
	}
	/**
	 * Says if the profile is Host
	 * @return false
	 */
	public boolean isHost() {
		return false;
	}
}
