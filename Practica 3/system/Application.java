package system;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

import exception.*;
import offer.*;
import user.*;

public class Application implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private final Admin admin;
	private List<House> houses;
	private List<RegisteredUser> users;
	private List<Offer> offers;
	
	private Application(String name, String surname, String password) {
		admin = new Admin (name,surname,password,"ImTheMdfkAdmin");
		houses = new ArrayList<>();
		users = new ArrayList<>();
		offers = new ArrayList<>();
	}
	
	public static Application getApplication(String name, String surname, String password) {
		Application app = null;
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("SystemBackup.objectData"));
			app = (Application) is.readObject();
			is.close();
			return app;
		}catch(IOException e) {
			return new Application (name,surname,password);
		} catch (ClassNotFoundException e) {
			return new Application (name,surname,password);
		}
	}
	
	public RegisteredUser loginUser(String id,String pswrd) {
		if(admin.getState() == 1) {
			return null;
		}
		for(RegisteredUser u: users) {
			if(u.getState() == 1) {
				return null;
			}
		}
		for(RegisteredUser u: users) {
			if(u.getId().equals(id)) {
				if(u.getPassword().equals(pswrd)) {
					u.setState(1);
					return u;
				}else {
					return null;
				}
			}
		}
		return null;
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
	
	public Admin loginAdmin(String id,String pswrd) {
		if(admin.getState() == 1) {
			return null;
		}
		for(RegisteredUser u: users) {
			if(u.getState() == 1) {
				return null;
			}
		}
		if(admin.getId().equals(id)) {
			if(admin.getPassword().equals(pswrd)) {
				admin.setState(1);
				return admin;
			}else {
				return null;
			}
		}
		return null;
	}
	
	private boolean logoutAdmin() {
		if(admin.getState() == 1) {
			admin.setState(0);
			return true;
		}
		return false;
	}
	/*
	public boolean login(String id,String pswrd) {
		if(this.loginUser(id, pswrd) == false) {
			if(this.loginAdmin(id, pswrd) == false) {
				return false;
			}
		}
		return true;
	}*/
	
	public boolean logut() {
		if(this.logoutUser() == false) {
			if(this.logoutAdmin() == false) {
				return false;
			}
		}
		backup();
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
	
	public boolean addUser(String name, String surename, String id, String password, String creditCard,boolean guest,boolean host) {
		for(RegisteredUser u: users) {
			if(u.getId().equals(id)) {
				return false;
			}
		}
		if (guest == host == false) {
			return false;
		}
		users.add(new RegisteredUser(name,surename,id,password,creditCard,guest,host));
		return true;
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
	
	public void addOfferLiving(LocalDate startingDate, double price, House house,double months) throws HostException{
		RegisteredUser u = this.getLoggedUser();
		if(u == null) {
			HostException e = new HostException();
			throw e;
		}
		if(u.isHost() == false) {
			HostException e = new HostException();
			throw e;
		}
		Offer o = new Living(startingDate,price,u,house,months);
		u.getHost().addOffer(o);
	}
	
	public void addOfferVacational(LocalDate startingDate, double price, RegisteredUser host, House house,LocalDate endingDate) throws HostException{
		RegisteredUser u = this.getLoggedUser();
		if(u == null) {
			HostException e = new HostException();
			throw e;
		}
		if(u.isHost() == false) {
			HostException e = new HostException();
			throw e;
		}
		Offer o = new Vacational(startingDate,price,u,house,endingDate);
		u.getHost().addOffer(o);
	}
	
	public List<Offer> searchOfferType(String type){
		List<Offer> l = new ArrayList<>();
		if(type.equals("Living")) {
			for (Offer o: offers) {
				if(o.getState() == 1) {	
					if(o.isLiving()) {
						l.add(o);
					}
				}
			}
		}else if(type.equals("Vacational")) {
			for (Offer o: offers) {
				if(o.getState() == 1) {
					if(o.isVacational()) {
						l.add(o);
					}
		
				}
			}
		}
		return l;
	}
		
	public List<Offer> searchOfferZip(int z){
		List<Offer> l = new ArrayList<>();
		for(Offer o: offers) {
			if(o.getState() == 1) {
				if(o.getHouse().getZip() == z) {
					l.add(o);
				}
			}
		}
		return l;
	}
	
	public List<Offer> searchOfferDate(LocalDate d1,LocalDate d2){
		List<Offer> l = new ArrayList<>();
		for(Offer o: offers) {
			if(o.getState() == 1) {
				if(o.getStartingDate().compareTo(d1) >= 0 && o.getStartingDate().compareTo(d2) <= 0 ) {
					l.add(o);
				}
			}
		}
		return l;
	}
	
	public List<Offer> searchOfferRate(int min) throws NonRegisteredException{
		for(RegisteredUser u: users) {
			if(u.getState() == 1) {
				List<Offer> l = new ArrayList<>();
				for (Offer o: offers) {
					if(o.getRate() > min) {
						if(o.getState() != -1) {
							l.add(o);
						}
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
	
	private void backup() {
		List<Offer> noffers;
		noffers = admin.getOffers();
		for(Offer o: noffers) {
			if(o.getState() == -1) {
				admin.getOffers().remove(o);
			}
		}
	
		for(RegisteredUser r: users) {
			for(Profile p: r.getProfile()) {
				noffers = p.getOffers();
				for(Offer o: noffers) {
					if(o.getState() == -1) {
						p.removeOffer(o);
					}
				}
			}
		}
		
		noffers = this.offers;
		for(Offer o: noffers) {
			if(o.getState() == -1) {
				offers.remove(o);
			}
		}
		
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream( new FileOutputStream("SystemBackup.objectData"));
			oos.writeObject(this);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
	}
	
	public String toString() {
		String res = "J&MA: \n";
		return res + admin;
	}
}
