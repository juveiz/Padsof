package offer;

import java.io.Serializable;
import java.time.*;

import Exception.*;
import User.*;

/**
 * Reserve class. It represents the reserve of the offers.
 * @author Miguel Angel Sanchez y Juan Velasco
 *
 */
public class Reserve implements Serializable{
	
	/**
	 * dateFin: Final date of the reserve.
	 * guest: User who has made the reserve.
	 * offer: Offer reserved.
	 */
	private static final long serialVersionUID = 1L;
	private LocalDate dateFin;
	private RegisteredUser guest;
	private Offer offer;
	/**
	 * Creates a new reserve
	 * @param dateFin Final date of the reserve
	 * @param guest User who made the reserve
	 * @param offer Offer reserved
	 * @throws GuestException The user is not a guest
	 */
	public Reserve(LocalDate dateFin, RegisteredUser guest, Offer offer) throws GuestException{
		if (guest.isGuest() == false) {
			GuestException g = new GuestException();
			throw g;
		}
		this.dateFin = dateFin;
		this.guest = guest;
		this.offer = offer;
	}
	/**
	 * Get the final date of the reserve
	 * @return date fin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}
	/**
	 * Get the user of the reserve
	 * @return Guest
	 */
	public RegisteredUser getGuest() {
		return guest;
	}
	/**
	 * Get the offer of the reserve
	 * @return offer
	 */
	public Offer getOffer() {
		return offer;
	}

}
