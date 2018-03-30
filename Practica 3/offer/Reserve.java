package offer;

import java.time.*;

import Exception.*;
import User.*;

public class Reserve {
	private LocalDate dateFin;
	private RegisteredUser guest;
	private Offer offer;
	
	public Reserve(LocalDate dateFin, RegisteredUser guest, Offer offer) throws GuestException{
		if (guest.isGuest() == false) {
			GuestException g = new GuestException();
			throw g;
		}
		this.dateFin = dateFin;
		this.guest = guest;
		this.offer = offer;
	}
	
	public LocalDate getDateFin() {
		return dateFin;
	}
	
	public RegisteredUser getGuest() {
		return guest;
	}
	
	public Offer getOffer() {
		return offer;
	}

}
