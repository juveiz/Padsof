package comments;

import User.*;
import Exception.*;

public class Numerical extends Comment {
	private double rate;
	public Numerical(double rate, RegisteredUser guest) throws GuestException{
		super(guest);
		this.rate = rate;
	}
	
	public double getRate() {
		return rate;
	}
	
	public boolean isNumerical() {
		return true;
	}
}
