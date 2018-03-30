package offer;

import java.time.LocalDate;

import Exception.HostException;
import User.RegisteredUser;

public class Living extends Offer {
	
	private double months;
	
	public Living(LocalDate startingDate, double price, RegisteredUser host, House house,double months) throws HostException{
		super(startingDate,price,host,house);
		this.months = months;
		super.setDeposit(super.getprice()*0.1); //he puesto 10 por ciento no se cuanto es xd
	}

	public double getMonths() {
		return months;
	}
	
	public boolean modifyOffer(House h, LocalDate s, double d,double months) {
		if(super.modifyOffer(h, s, d)) {
			this.months = months;
			return true;
		}
		return false;
	}
}
