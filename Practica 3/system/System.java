package system;

import java.util.*;

import Exception.*;
import User.*;
import offer.*;

public class System {
	private List<Admin> admins;
	private List<House> houses;
	private List<RegisteredUser> users;
	private List<Offer> offers;
	
	public System() {
		admins = new ArrayList<>();
		houses = new ArrayList<>();
		users = new ArrayList<>();
		offers = new ArrayList<>();
	}
	
	private boolean loginUser(int id,String pswrd) {
		for(Admin u: admins) {
			if(u.getState() == 1) {
				return false;
			}
		}
		for(RegisteredUser u: users) {
			if(u.getState() == 1) {
				return false;
			}
		}
		for(RegisteredUser u: users) {
			if(u.getId() == id) {
				if(u.getPassword().equals(pswrd)) {
					u.setState(1);
					return true;
				}else {
					return false;
				}
			}
		}
		return false;
	}
	
	private boolean logoutUser() {
		for(RegisteredUser u: users) {
			if(u.getState() == 1) {
				u.setState(0);
				return true;
			}
		}
		return false;
	}
	
	private boolean loginAdmin(int id,String pswrd) {
		for(Admin u: admins) {
			if(u.getState() == 1) {
				return false;
			}
		}
		for(RegisteredUser u: users) {
			if(u.getState() == 1) {
				return false;
			}
		}
		for(Admin u: admins) {
			if(u.getId() == id) {
				if(u.getPassword().equals(pswrd)) {
					u.setState(1);
					return true;
				}else {
					return false;
				}
			}
		}
		return false;
	}
	
	private boolean logoutAdmin() {
		for(Admin u: admins) {
			if(u.getState() == 1) {
				u.setState(0);
				return true;
			}
		}
		return false;
	}
	
	public boolean login(int id,String pswrd) {
		if(this.loginUser(id, pswrd) == false) {
			if(this.loginAdmin(id, pswrd) == false) {
				return false;
			}
		}
		return true;
	}
	
	public boolean logut() {
		if(this.logoutUser() == false) {
			if(this.logoutAdmin() == false) {
				return false;
			}
		}
		return true;
	}
	
	private RegisteredUser getLoggedUser() {
		for(RegisteredUser u: users) {
			if(u.getState() == 1) {
				return u;
			}
		}
		return null;
	}
	
	public void addHouse(String city, int zip, String description) throws HostException {
		RegisteredUser u = this.getLoggedUser();
		if(u == null) {
			HostException e = new HostException();
			throw e;
		}
		if(u.isHost() == false) {
			HostException e = new HostException();
			throw e;
		}
		House h = new House(city,zip,description);
		houses.add(h);
		u.getHost().addHouse(h);
	}
	
	public void addOffer() {
		
	}
	
	public List<Offer> searchOfferType(String type){
		List<Offer> l = new ArrayList<>();
		if(type.equals("Living")) {
			for (Offer o: offers) {
				if(o.isLiving()) {
					l.add(o);
				}
			}
		}else if(type.equals("Vacational")) {
			for (Offer o: offers) {
				if(o.isVacational()) {
					l.add(o);
				}
		}
		
		}
		return l;
	}
		
	public List<Offer> searchOfferZip(int z){
		List<Offer> l = new ArrayList<>();
		for(Offer o: offers) {
			if(o.getHouse().getZip() == z) {
				l.add(o);
			}
		}
		return l;
	}
	/*
	 * queda ver la fecha
	 */
	public List<Offer> searchOfferDate(){
		
	}
	
	public List<Offer> searchOfferRate(int min) throws NonRegisteredException{
		for(RegisteredUser u: users) {
			if(u.getState() == 1) {
				List<Offer> l = new ArrayList<>();
				for (Offer o: offers) {
					if(o.getRate() > min) {
						l.add(o);
					}
				}
				return l;
			}
		}
		NonRegisteredException e = new NonRegisteredException();
		throw e;
	}
	
	public List<Offer> searchOfferReserved() throws NonRegisteredException{
		for(RegisteredUser u: users) {
			if(u.getState() == 1) {
				List<Offer> l = new ArrayList<>();
				for (Offer o: offers) {
					if(o.getState() == 3) {
						l.add(o);
					}
				}
				return l;
			}
		}
		NonRegisteredException e = new NonRegisteredException();
		throw e;
	}
	
	public List<Offer> searchOfferBought() throws NonRegisteredException{
		for(RegisteredUser u: users) {
			if(u.getState() == 1) {
				List<Offer> l = new ArrayList<>();
				for (Offer o: offers) {
					if(o.getState() == 4) {
						l.add(o);
					}
				}
				return l;
			}
		}
		NonRegisteredException e = new NonRegisteredException();
		throw e;
	}
}
