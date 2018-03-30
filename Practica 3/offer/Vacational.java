package offer;

import java.time.*;

import Exception.HostException;
import User.RegisteredUser;

public class Vacational extends Offer {
	
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
