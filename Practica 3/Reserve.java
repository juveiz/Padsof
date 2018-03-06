import java.util.*;
public class Reserve {
	private Date dateFin;
	private Guest guest;
	private Offer offer;
	
	public Reserve(Date dateFin, Guest guest, Offer offer) {
		this.dateFin = dateFin;
		this.guest = guest;
		this.offer = offer;
	}
	
	public Date getDateFin() {
		return dateFin;
	}
	
	public Guest getGuest() {
		return guest;
	}
	
	public Offer getOffer() {
		return offer;
	}
	
}
