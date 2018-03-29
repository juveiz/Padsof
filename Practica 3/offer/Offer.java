package offer;
import java.util.*;

import comments.*;
import User.*;
import Exception.*;

public abstract class Offer {

	private Date startingDate;
	private double deposit;
	private int state;
	private Date modifyDate;
	private RegisteredUser host;
	private House house;
	private List<Comment> comments;
	private Reserve reserve;
	
	
	public Offer(Date startingDate, double deposit, RegisteredUser host, House house) throws HostException {
		if(host.isHost() == false) {
			HostException h = new HostException();
			throw h;
		}
		this.startingDate = startingDate;
		this.deposit = deposit;
		this.host = host;
		this.house = house;
		modifyDate = new Date() ;
		state = 0;
		comments = new ArrayList<>();
		reserve = null;
	}
	
	public Date getStartingDate() {
		return startingDate;
	}
	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
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
	
	
	public void approveOffer(Admin a) {
		this.setState(1);
		modifyDate = new Date();
	}
	
	public boolean denyOffer(Admin a) throws HostException {
		this.setState(-1);
		if (a.getOffer().remove(this) == false) {
			return false;
		}
		if (host.getHost().removeOffer(this) == false) {
			return false;
		}
		return true;
	}
	
	public void askForChanges() {
		this.setState(2);
		modifyDate = new Date();
	}
	
	public void cancelOfer() throws HostException {
		this.setState(-1);
		host.getHost().removeOffer(this);
	}
	
	public void modifyOffer(House h, Date s, double d) {
		house = h;
		startingDate = s;
		deposit = d;
		modifyDate = new Date();
		this.setState(0);
		//ojo 5 dias
	}
	
	public boolean reserveOffer(RegisteredUser g) throws GuestException {
		if (g.isGuest() == false) {
			GuestException gu = new GuestException();
			throw gu;
		}
		if (state != 1) {
			return false;
		}
		reserve = new Reserve(g,this,dateFin);//ver como se hace 
		this.setState(3);
		return true;
	}
	
	public int buyOffer(Guest g) {
		String creditCard;
		boolean paymenOk;
		if (reserve == null) {
			creditCard = g.getCreditCard();
			//aqui hacer el pago
			if (paymentOK) {
				this.setState(4);
				return 0;
			}else{
				g.banUser();
				return -1;
			}
		}else {
			if (reserve.getGuest().equals(g)) {//hacer en guest
				creditCard = g.getCreditCard();
				//aqui hacer el pago
				if (paymentOK) {
					this.setState(4);
					return 0;
				}else{
					g.banUser();
					reserve = null;
					return -1;
				}
			}else {
				return -2;
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
}
