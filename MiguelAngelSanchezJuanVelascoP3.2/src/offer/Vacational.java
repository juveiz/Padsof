package offer;

import java.io.Serializable;
import java.time.*;

import exception.HostException;
import user.RegisteredUser;

/**
 * Vacational class. It represents the vacational offers.
 * 
 * @author Miguel Angel Sanchez y Juan Velasco
 *
 */
public class Vacational extends Offer implements Serializable {

	/**
	 * endingDate: Final date of the offer
	 */
	private static final long serialVersionUID = 1L;
	private LocalDate endingDate;

	/**
	 * Creates a new vacational offer
	 * 
	 * @param startingDate
	 *            Starting date of the offer
	 * @param price
	 *            Price of the offer
	 * @param host
	 *            User who creates the offer
	 * @param house
	 *            House of the offer
	 * @param endingDate
	 *            Final date of the offer
	 * @throws HostException
	 *             The user is not host
	 */
	public Vacational(LocalDate startingDate, double price, RegisteredUser host, House house, LocalDate endingDate)
			throws HostException {
		super(startingDate, price, host, house);
		this.endingDate = endingDate;
		super.setDeposit(super.getprice() * 0.02); // tampoco me acuerdo
	}

	/**
	 * Return the final date of the offer
	 * 
	 * @return Final date
	 */
	public LocalDate getEndingDate() {
		return endingDate;
	}

	/**
	 * Modify the offer
	 * 
	 * @param h
	 *            User who creates the offer
	 * @param s
	 *            Starting date of the offer
	 * @param d
	 *            Price of the offer
	 * @param endingDate
	 *            Final date of the offer
	 * @return true if it has been modify correctly or false if not
	 */
	@Override
	public boolean modifyOffer(House h, LocalDate s, double d, LocalDate endingDate) {
		if (super.modifyOffer(h, s, d)) {
			this.endingDate = endingDate;
			return true;
		}
		return false;
	}

	/**
	 * Tells if an offer is vacational
	 * 
	 * @return true
	 */
	public boolean isVacational() {
		return true;
	}

	/**
	 * Compare two vacational offers
	 * 
	 * @param o
	 *            Offer to be compared
	 * @return true if they are equals false if not
	 */
	public boolean equals(Offer o) {
		if (super.getHouse().equals(o.getHouse()) == false) {
			return false;
		}
		if (o.isVacational() == false) {
			return false;
		}
		if (super.getState() != -1 && super.getState() != 4) {
			return true;
		}
		return false;
	}

	/**
	 * toString for vacational offers
	 */
	public String toString() {
		return super.toString() + "\nEnding Date: " + endingDate;
	}
}
