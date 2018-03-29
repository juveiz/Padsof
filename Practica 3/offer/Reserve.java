package offer;
import java.util.*;

import Exception.*;
import User.*;

public class Reserve {
	private Date dateFin;
	private RegisteredUser guest;
	private Offer offer;
	
	public Reserve(Date dateFin, RegisteredUser guest, Offer offer) throws GuestException{
		if (guest.isGuest() == false) {
			GuestException g = new GuestException();
			throw g;
		}
		this.dateFin = dateFin;
		this.guest = guest;
		this.offer = offer;
	}
	
	public Date getDateFin() {
		return dateFin;
	}
	
	public RegisteredUser getGuest() {
		return guest;
	}
	
	public Offer getOffer() {
		return offer;
	}

}
