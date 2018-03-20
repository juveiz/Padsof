package comments;

public class Numerical extends Comment {
	private double rate;
	public Numerical(double rate, Guest guest) {
		super(guest);
		this.rate = rate;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	
}
