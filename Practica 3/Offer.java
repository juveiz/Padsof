import java.util.*;
public abstract class Offer {

	private Date startingDate;
	private double deposit;
	private int state;
	private Date modifyDate;
	private Host host;
	private House house;
	private List<Comment> comments;
	private Reserve reserve;
	
	
	public Offer(Date startingDate, double deposit, Host host, House house) {
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
	public Host getHost() {
		return host;
	}
	public void setHost(Host host) {
		this.host = host;
	}
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
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
	
	public void denyOffer(Admin a) {
		this.setState(-1);
		a.getOffers().remove(this);
		host.getOffers().remove(this);
	}
	
	public void askForChanges() {
		this.setState(2);
		modifyDate = new Date();
	}
	
	public void cancelOfer() {
		this.setState(-1);
		host.getOffers().remove(this);
		//ojo en admin
	}
	
	public void modifyOffer(House h, Date s, double d) {
		house = h;
		startingDate = s;
		deposit = d;
		modifyDate = new Date();
		this.setState(0);
		//ojo 5 dias
	}
	
	public boolean reserveOffer(Guest g) {
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
	
	public void commentOffer(Guest g,String c) {
		Comment comment;
		comment = new Text(c,g);
		comments.add(comment);
	}
	
	public void rateOffer(Guest g, double r) {
		Comment comment;
		comment = new Numerical(r,g);
		comments.add(comment);
	}
}
