package offer;

import java.io.Serializable;
import java.time.*;

import exception.HostException;
import user.RegisteredUser;

public class Vacational extends Offer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private LocalDate endingDate;
	
	public Vacational(LocalDate startingDate, double price, RegisteredUser host, House house,LocalDate endingDate) throws HostException{
		super(startingDate,price,host,house);
		this.endingDate = endingDate;
		super.setDeposit(super.getprice()*0.01); //tampoco me acuerdo
	}

	public LocalDate getEndingDate() {
		return endingDate;
	}
	
	public boolean modifyOffer(House h, LocalDate s, double d,LocalDate endingDate) {
		if(super.modifyOffer(h, s, d)) {
			this.endingDate = endingDate;
			return true;
		}
		return false;
	}
}
