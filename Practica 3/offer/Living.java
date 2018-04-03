package offer;

import java.io.Serializable;
import java.time.LocalDate;

import exception.HostException;
import user.RegisteredUser;

/**
 * Living class. It representes de living offers.
 * @author Miguel Angel Sanchez y Juan Velasco
 *
 */
public class Living extends Offer implements Serializable{
	/**
	 * Months: number of months of the offer.
	 */
	private static final long serialVersionUID = 1L;
	private double months;
	
	/**
	 * It creates a new living offer
	 * @param startingDate Starting date of the offer
	 * @param price Price of the offer
	 * @param host Creator of the offer
	 * @param house House of the offer
	 * @param months Months of the offer
	 * @throws HostException The user is not a host
	 */
	public Living(LocalDate startingDate, double price, RegisteredUser host, House house,double months) throws HostException{
		super(startingDate,price,host,house);
		this.months = months;
		super.setDeposit(super.getprice()*0.001); //he puesto 10 por ciento no se cuanto es xd
	}
	/**
	 * Return the number of months of the offer
	 * @return number of months
	 */
	public double getMonths() {
		return months;
	}
	
	/**
	 * Modify the parameters of the offer
	 * @param h New house of the offer
	 * @param s New starting date of the offers
	 * @param d New price of the offer
	 * @param months New number of months of the offer
	 * @return true if it has been modify correctly or false if it is not
	 */
	public boolean modifyOffer(House h, LocalDate s, double d,double months) {
		if(super.modifyOffer(h, s, d)) {
			this.months = months;
			return true;
		}
		return false;
	}
}
