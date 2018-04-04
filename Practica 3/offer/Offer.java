package offer;
import java.io.Serializable;
import java.time.*;
import java.util.*;

import es.uam.eps.padsof.telecard.*;
import exception.*;
import user.*;
import comments.*;

public abstract class Offer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private LocalDate startingDate;
	private double price;
	private double deposit;
	private int state;
	private LocalDate modifyDate;
	private RegisteredUser host;
	private House house;
	private List<Comment> comments;
	private Reserve reserve;
	private String changes;
	
	/**
	 * Creates an offer
	 * @param startingDate StartingDate of the offer
	 * @param price Price of the offer
	 * @param host Host that creates the offer
	 * @param house House of the offer
	 * @throws HostException The user is not a host
	 */
	public Offer(LocalDate startingDate, double price, RegisteredUser host, House house) throws HostException {
		if(host.isHost() == false) {
			HostException h = new HostException();
			throw h;
		}
		this.startingDate = startingDate;
		this.price = price;
		this.host = host;
		this.house = house;
		modifyDate = LocalDate.now();
		state = 0;
		comments = new ArrayList<>();
		deposit = 0;
		reserve = null;
	}
	
	/**
	 * Gets the starting date
	 * @return startingDate
	 */
	public LocalDate getStartingDate() {
		return startingDate;
	}
	
	/**
	 * Sets the starting date
	 * @param startingDate Starting date of the offer
	 */
	public void setStartingDate(LocalDate startingDate) {
		this.startingDate = startingDate;
	}
	
	/**
	 * Gets the price of the offer
	 * @return price
	 */
	public double getprice() {
		return price;
	}
	
	/**
	 * Sets the price of the offer
	 * @param price Price of the offer
	 */
	public void setprice(double price) {
		this.price = price;
	}
	
	/**
	 * Gets the state of the offer
	 * @return state
	 */
	public int getState() {
		return state;
	}
	
	/**
	 * Sets the state of the offer
	 * @param state State of the offer
	 */
	public void setState(int state) {
		this.state = state;
	}
	
	/**
	 * Gets the last date that the offer was modified
	 * @return modify date
	 */
	public LocalDate getModifyDate() {
		return modifyDate;
	}
	
	/**
	 * Sets the modify date
	 * @param modifyDate Last date that the offer was modified
	 */
	public void setModifyDate(LocalDate modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	/**
	 * Gets the host that made the offer
	 * @return host
	 */
	public RegisteredUser getHost() {
		return host;
	}
	
	/**
	 * Gets the house of the offer
	 * @return house
	 */
	public House getHouse() {
		return house;
	}
	
	/**
	 * Gets the list of the comments of the offer
	 * @return list of the comments
	 */
	public List<Comment> getComments() {
		return comments;
	}
	
	/**
	 * Sets a list of comments to the offer
	 * @param comments List of comments
	 */
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	/**
	 * Gets the reserve of the offer
	 * @return The reserve if it's reserved or null if it's not
	 */
	public Reserve getReserve() {
		return reserve;
	}
	
	/**
	 * Sets a reserve to the offer
	 * @param reserve Reserve for the offer
	 */
	public void setReserve(Reserve reserve) {
		this.reserve = reserve;
	}
	
	/**
	 * Gets the rate of the offer
	 * @return Rate of the offer
	 */
	public double getRate() {
		double res = 0;
		double cont = 0;
		for(Comment c: comments) {
			if(c.isNumerical()) {
				res = res + ((Numerical)c).getRate();
				cont = cont + 1;
			}
		}
		if (cont==0) return 0;
		res = res/cont;
		return res;
	}
	
	/**
	 * Approves the offer
	 * @param a Admin that approves the offer
	 */
	public void approveOffer(Admin a) {
		this.setState(1);
		modifyDate = LocalDate.now();
		a.getOffers().remove(this);
	}
	
	/**
	 * Denies the offer
	 * @param a Admin that denies the offer
	 */
	public void denyOffer(Admin a){
		this.setState(-1);
	}
	
	/**
	 * Ask for changes in the offer
	 * @param changes Changes to be done 
	 * @param admin Admin who ask for changes
	 */
	public void askForChanges(String changes,Admin admin) {
		this.setState(2);
		modifyDate = LocalDate.now();
		this.changes = changes;
	}
	
	/**
	 * Cancels the offer
	 * @throws HostException The user is not a host
	 */
	public void cancelOfer() throws HostException {
		host.getHost().removeOffer(this);
		this.setState(-1);
	}
	
	/**
	 * Modifies the offer
	 * @param h New house of the offer
	 * @param s New date of the offer
	 * @param d New price of the offer
	 * @return True if the offer was successfully modified, false if it was not
	 */
	public boolean modifyOffer(House h, LocalDate s, double d) {
		if(modifyDate.plusDays(5).compareTo(LocalDate.now()) <= 0) {
			this.setState(-1);
			return false;
		}
		house = h;
		startingDate = s;
		price = d;
		modifyDate = LocalDate.now();
		this.setState(0);
		return true;
	}
	
	/**
	 * Reserves the offer
	 * @param g Guest that reserves the offer
	 * @return True if the offer is successfully reserved, false if it's not
	 * @throws GuestException The user is not a guest
	 */
	public boolean reserveOffer(RegisteredUser g) throws GuestException {
		if (g.isGuest() == false) {
			GuestException gu = new GuestException();
			throw gu;
		}
		if (state != 1) {
			return false;
		}
		reserve = new Reserve(LocalDate.now().plusDays(5),g,this);//ver como se hace 
		this.setState(3);
		for(Profile p: g.getProfile()) {
			if(g.isGuest()) {
				p.addOffer(this);
			}
		}
		return true;
	}
	
	/*
	 * HAY QUE HACER LO DE PAGAR AL HOST
	 */
	
	/**
	 * Buys this offer
	 * @param g Guest that buys the offer
	 * @param subject Subject of the buying of the offer
	 * @param trace Trace of the payment of the offer
	 * @return different numbers for each error
	 * @throws GuestException The user is not a guest
	 */
	public int buyOffer(RegisteredUser g,String subject,boolean trace) throws GuestException {
		String creditCard;
		if(g.isGuest() == false) {
			GuestException e = new GuestException();
			throw e;
		}
		if (reserve == null) {
			creditCard = g.getCreditCard();
			try {
				if(trace) {
					TeleChargeAndPaySystem.charge(creditCard,subject,price + deposit,trace);
				}else {
					TeleChargeAndPaySystem.charge(creditCard,subject,price + deposit);
					
				}
			}catch(InvalidCardNumberException e) {
				g.banUser();
				return -1;
				//usuario baneado
			}catch(FailedInternetConnectionException e) {
				return -2;
				//caca de internete
			}catch(OrderRejectedException e) {
				return -3;
				//esto no se que es
			}
			this.setState(4);
			return 0;
		}else {
			creditCard = g.getCreditCard();
			if (reserve.getGuest().getId() == g.getId() ) {//hacer en guest
				try {
					if(trace) {
						TeleChargeAndPaySystem.charge(creditCard,subject,price + deposit,trace);
					}else {
						TeleChargeAndPaySystem.charge(creditCard,subject,price + deposit);
						
					}
				}catch(InvalidCardNumberException e) {
					g.banUser();
					return -1;
					//usuario baneado
				}catch(FailedInternetConnectionException e) {
					return -2;
					//caca de internete
				}catch(OrderRejectedException e) {
					return -3;
					//esto no se que es
				}
				this.setState(4);
				return 0;
			}else {
				return -4;
				//Usuario distinto de reserrva
			}
		}
		
	}
	
	/**
	 * Comments the offer
	 * @param g Guest that comments the offer
	 * @param c String with the comment
	 * @throws GuestException The user is not a guest
	 */
	public void commentOffer(RegisteredUser g,String c) throws GuestException {
		if (g.isGuest() == false) {
			GuestException gu = new GuestException();
			throw gu;
		}
		Comment comment;
		comment = new Text(c,g);
		comments.add(comment);
	}
	
	/**
	 * Rates the offer
	 * @param g Guest that rates the offer
	 * @param r Rating of the offer
	 * @throws GuestException the user is not a guest
	 */
	public void rateOffer(RegisteredUser g, double r) throws GuestException{
		if (g.isGuest() == false) {
			GuestException gu = new GuestException();
			throw gu;
		}
		Comment comment;
		comment = new Numerical(r,g);
		comments.add(comment);
	}
	
	/**
	 * Checks if the offer is a living offer
	 * @return True if it's a living offer, false if it's not
	 */
	public boolean isLiving() {
		return false;
	}
	
	/**
	 * Checks if the offer is a vacational offer
	 * @return True if it's a vacational offer, false if it's not
	 */
	public boolean isVacational() {
		return false;
	}

	/**
	 * Gets the deposit of the offer
	 * @return deposit
	 */
	public double getDeposit() {
		return deposit;
	}
	
	/**
	 * Sets the deposit of the offer
	 * @param deposit Deposit of the offer
	 */
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	
	public abstract boolean equals(Offer o);
	public String toString() {
		String res = "Offer: \n";
		String state;
		if(this.state == 0) {
			state = "Pending of aproval";
		}else if(this.state == 1) {
			state = "Available";
		}else if(this.state == -1) {
			state = "Canceled";
		}else if(this.state == 2) {
			state = "Need changes";
		}else if(this.state == 3) {
			state = "Reserved";
		}else if(this.state == 4) {
			state = "Bought";
		}else {
			return "";
		}
		return res + "State: " + state + "\nStarting Date: " + startingDate + "\nPrice: " + price + "\nDeposit: " + deposit+"\n" + house;
	}

	public String getChanges() {
		return changes;
	}
}
