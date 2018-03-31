package offer;
import java.time.*;
import java.util.*;

import es.uam.eps.padsof.telecard.*;
import comments.*;
import User.*;
import Exception.*;

public abstract class Offer {

	private LocalDate startingDate;
	private double price;
	private double deposit;
	private int state;
	private LocalDate modifyDate;
	private RegisteredUser host;
	private House house;
	private List<Comment> comments;
	private Reserve reserve;
	
	
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
	
	public LocalDate getStartingDate() {
		return startingDate;
	}
	public void setStartingDate(LocalDate startingDate) {
		this.startingDate = startingDate;
	}
	public double getprice() {
		return price;
	}
	public void setprice(double price) {
		this.price = price;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public LocalDate getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(LocalDate modifyDate) {
		this.modifyDate = modifyDate;
	}
	public RegisteredUser getHost() {
		return host;
	}
	public House getHouse() {
		return house;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public Reserve getReserve() {
		return reserve;
	}
	public void setReserve(Reserve reserve) {
		this.reserve = reserve;
	}
	
	/**
	 * a implementar (easy)
	 * @return
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
		res = res/cont;
		return res;
	}
	
	public void approveOffer(Admin a) {
		this.setState(1);
		modifyDate = LocalDate.now();
	}
	
	public boolean denyOffer(Admin a) throws HostException {
		this.setState(-1);
		return true;
	}
	
	public void askForChanges() {
		this.setState(2);
		modifyDate = LocalDate.now();
	}
	
	public void cancelOfer() throws HostException {
		this.setState(-1);
		host.getHost().removeOffer(this);
	}
	
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
		return true;
	}
	
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
	
	public void commentOffer(RegisteredUser g,String c) throws GuestException {
		if (g.isGuest() == false) {
			GuestException gu = new GuestException();
			throw gu;
		}
		Comment comment;
		comment = new Text(c,g);
		comments.add(comment);
	}
	
	public void rateOffer(RegisteredUser g, double r) throws GuestException{
		if (g.isGuest() == false) {
			GuestException gu = new GuestException();
			throw gu;
		}
		Comment comment;
		comment = new Numerical(r,g);
		comments.add(comment);
	}
	
	public boolean isLiving() {
		return false;
	}
	
	public boolean isVacational() {
		return false;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
}
