package comments;

import User.*;
import Exception.*;

/**
 * Numerical class. It represents the numerical comments. 
 * @author Miguel Angel Sanchez y Juan Velasco
 *
 */
public class Numerical extends Comment {
	/**
	 * Rate: rate of the offer (or comment).
	 */
	private double rate;
	/**
	 * Creates a new numerical comment
	 * @param rate Rate of the offer (or comment).
	 * @param guest User who makes the comment.
	 * @throws GuestException The user is not a guest.
	 */
	public Numerical(double rate, RegisteredUser guest) throws GuestException{
		super(guest);
		this.rate = rate;
	}
	
	/**
	 * Get the rate from the numerical comment
	 * @return rate
	 */
	public double getRate() {
		return rate;
	}
	/**
	 * Says if the comment is a numerical comment
	 * @return true
	 */
	public boolean isNumerical() {
		return true;
	}
}
