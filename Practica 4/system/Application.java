package system;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

import exception.*;
import offer.*;
import user.*;

/**
 * Aplication class. It implements the general features for the application
 * 
 * @author Miguel Angel Sanchez y Juan Velasco
 *
 */
public class Application implements Serializable {

	private static final long serialVersionUID = 1L;
	private static Application app = null;
	private final Admin admin;
	private List<House> houses;
	private List<RegisteredUser> users;
	private List<Offer> offers;

	/**
	 * Creates a new application
	 * 
	 * @param name
	 *            Name of the admin
	 * @param surname
	 *            Surename of the admin
	 * @param password
	 *            Password of the admin
	 */
	private Application(String name, String surname, String password) {
		admin = new Admin(name, surname, password, "ImTheMdfkAdmin");
		houses = new ArrayList<>();
		users = new ArrayList<>();
		offers = new ArrayList<>();
	}

	/**
	 * Get the application from the file. If it doesn't exist, it creates a new one
	 * 
	 * @param name
	 *            Name of the admin
	 * @param surname
	 *            Surename of the admin
	 * @param password
	 *            Password of the admin
	 * @return Application
	 */
	private static Application getApplication(String name, String surname, String password) {
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("SystemBackup.objectData"));
			app = (Application) is.readObject();
			is.close();
			return app;
		} catch (IOException e) {
			app = new Application(name, surname, password);
			try {
				FileInputStream f = null;
				String line;
				f = new FileInputStream("ClientsExample.txt");
				BufferedReader buffer = new BufferedReader(new InputStreamReader(f));
				buffer.readLine();
				while ((line = buffer.readLine()) != null) {
					boolean guest = false,host = false;
					String[] newUser = line.split(";");
					if (newUser[0].equals("O")) {
						guest = false;
						host = true;
					} else if (newUser[0].equals("D")) {
						guest = true;
						host = false;
					} else if (newUser[0].equals("OD")) {
						guest = true;
						host = true;
					} else {
						buffer.close();
					}
					System.out
							.println(app.addUser(newUser[3], newUser[2], newUser[1], newUser[4], newUser[5], guest, host));
				}
				buffer.close();
				return app;
			} catch (IOException e1) {
				System.out.println("The given file hasn't been opened");
			}
		} catch (ClassNotFoundException e) {
			app = new Application(name, surname, password);
			try {
				FileInputStream f = null;
				String line;
				f = new FileInputStream("ClientsExample.txt");
				BufferedReader buffer = new BufferedReader(new InputStreamReader(f));
				buffer.readLine();
				while ((line = buffer.readLine()) != null) {
					boolean guest = false,host = false;
					String[] newUser = line.split(";");
					if (newUser[0].equals("O")) {
						guest = false;
						host = true;
					} else if (newUser[0].equals("D")) {
						guest = true;
						host = false;
					} else if (newUser[0].equals("OD")) {
						guest = true;
						host = true;
					} else {
						buffer.close();
					}
					System.out
							.println(app.addUser(newUser[3], newUser[2], newUser[1], newUser[4], newUser[5], guest, host));
				}
				buffer.close();
				return app;
			} catch (IOException e1) {
				System.out.println("The given file hasn't been opened");
			}
		}
		return app;
	}
	
	/**
	 * Get the instance of the application
	 * @return app
	 */
	public static Application getInstance() {
		if (app == null) {
			app = Application.getApplication("Eva", "Touris", "OpenBalls");
		}
		return app;
	}
	/**
	 * User login. If a host has a wrong credit card, it shows a message telling it
	 * 
	 * @param id
	 *            Id of the user
	 * @param pswrd
	 *            Password of the user
	 * @return User if it exist or null if it don't
	 * @throws LoggedException
	 *             Another user is logged
	 * @throws BannedUserException
	 *             The user is banned
	 */
	public RegisteredUser loginUser(String id, String pswrd) throws LoggedException, BannedUserException {
		if (admin.getState() == 1) {
			LoggedException e = new LoggedException();
			throw e;
		}
		for (RegisteredUser u : users) {
			if (u.getState() == 1) {
				LoggedException e = new LoggedException();
				throw e;
			}
		}
		for (RegisteredUser u : users) {
			if (u.getId().equals(id)) {
				if (u.getPassword().equals(pswrd)) {
					if (u.getState() == -1) {
						throw new BannedUserException(u);
					}
					if (u.getState() == -2) {
						System.out.println("Contact the admin to make the pays\n");
					}
					u.setState(1);
					return u;
				} else {
					return null;
				}
			}
		}
		return null;
	}

	/**
	 * Logout user
	 * 
	 * @return true if it logout or false if it not
	 */
	private boolean logoutUser() {
		for (RegisteredUser u : users) {
			if (u.getState() == 1) {
				u.setState(0);
				return true;
			}
		}
		return false;
	}

	/**
	 * Admin login
	 * 
	 * @param id
	 *            Id of the admin
	 * @param pswrd
	 *            Password of the admin
	 * @return Admin if it exist or null if it doesn't
	 * @throws LoggedException
	 *             Another user is logged
	 */
	public Admin loginAdmin(String id, String pswrd) throws LoggedException {
		if (admin.getState() == 1) {
			LoggedException e = new LoggedException();
			throw e;
		}
		for (RegisteredUser u : users) {
			if (u.getState() == 1) {
				LoggedException e = new LoggedException();
				throw e;
			}
		}
		if (admin.getId().equals(id)) {
			if (admin.getPassword().equals(pswrd)) {
				admin.setState(1);
				return admin;
			} else {
				return null;
			}
		}
		return null;
	}

	/**
	 * Admin logout
	 * 
	 * @return true if it logged out or false if it not
	 */
	private boolean logoutAdmin() {
		if (admin.getState() == 1) {
			admin.setState(0);
			return true;
		}
		return false;
	}

	/**
	 * General logout. It logout and make a backup
	 * 
	 * @return true if everything went okay false it it not
	 */
	public boolean logut() {
		if (this.logoutUser() == false) {
			if (this.logoutAdmin() == false) {
				return false;
			}
		}
		backup();
		return true;
	}

	/**
	 * Get the logged User (not admin)
	 * 
	 * @return User or null
	 */
	public RegisteredUser getLoggedUser() {
		for (RegisteredUser u : users) {
			if (u.getState() == 1) {
				return u;
			}
		}
		return null;
	}
	/**
	 * Get the admin
	 * 
	 * @return Admin 
	 */
	public Admin getAdmin() {
		return admin;
	}
	/**
	 * Get a registered user from the app
	 * @param id Id
	 * @param pass Password
	 * @return user or null if it doesn't exist
	 */
	public RegisteredUser getUser(String id,String pass) {
		for(RegisteredUser user :users) {
			if (user.getId().equals(id) && user.getPassword().equals(pass)) {
				return user;
			}
		}
		return null;
	}
	/**
	 * Creates a new user
	 * 
	 * @param name
	 *            Name of the user
	 * @param surename
	 *            Surename of the user
	 * @param id
	 *            Id of the user
	 * @param password
	 *            Password of the user
	 * @param creditCard
	 *            Credit card of the user
	 * @param guest
	 *            The user is a guest
	 * @param host
	 *            The user is a host
	 * @return true if everything went ok false if the id exist or both guest and
	 *         host are fasle
	 */
	public boolean addUser(String name, String surename, String id, String password, String creditCard, boolean guest,
			boolean host) {
		for (RegisteredUser u : users) {
			if (u.getId().equals(id)) {
				return false;
			}
		}
		if (guest == false && host == false) {
			return false;
		}
		users.add(new RegisteredUser(name, surename, id, password, creditCard, guest, host));
		return true;
	}

	/**
	 * Add a new house
	 * 
	 * @param city
	 *            City of the house
	 * @param zip
	 *            Zip code of the house
	 * @param description
	 *            Description of the house
	 * @throws HostException
	 *             The user logged is not host
	 */
	public void addHouse(String city, int zip, String description) throws HostException {
		RegisteredUser u = this.getLoggedUser();
		if (u == null) {
			HostException e = new HostException();
			throw e;
		}
		if (u.isHost() == false) {
			HostException e = new HostException();
			throw e;
		}
		House h = new House(city, zip, description);
		for (House oldHouse : this.houses) {
			if (oldHouse.equals(h)) {
				return;
			}
		}
		houses.add(h);
		u.getHost().addHouse(h);
	}

	/**
	 * Get the houses from an user
	 * 
	 * @param user
	 *            User
	 * @return Houses of the user
	 * @throws HostException The user is not a host
	 */
	public List<House> getHostHouses(RegisteredUser user) throws HostException {
		if (user.getState() != 1) {
			return null;
		}
		if (user.isHost() == false) {
			HostException e = new HostException();
			throw e;
		}
		for (Profile p : user.getProfile()) {
			if (p.isHost()) {
				return p.getHouses();
			}
		}
		return null;
	}

	/**
	 * Creates a new living offer
	 * 
	 * @param startingDate
	 *            Starting date
	 * @param price
	 *            Price of the offer
	 * @param house
	 *            House of the offer
	 * @param months
	 *            Months of the offer
	 * @throws HostException
	 *             The logged user is not a host
	 */
	public void addOfferLiving(LocalDate startingDate, double price, House house, double months) throws HostException {
		RegisteredUser u = this.getLoggedUser();
		if (u == null) {
			HostException e = new HostException();
			throw e;
		}
		if (u.isHost() == false) {
			HostException e = new HostException();
			throw e;
		}
		if (house == null) {
			return;
		}
		Offer o = new Living(startingDate, price, u, house, months);
		for (Offer oldOffer : this.offers) {
			if (oldOffer.equals(o)) {
				return;
			}
		}
		this.offers.add(o);
		this.admin.addOffer(o);
		u.getHost().addOffer(o);
	}

	/**
	 * Creates a new vacational offer
	 * 
	 * @param startingDate
	 *            Starting date
	 * @param price
	 *            Price of the offer
	 * @param house
	 *            House of the offer
	 * @param endingDate
	 *            Final date of the offer
	 * @throws HostException
	 *             The logged user is not a host
	 */
	public void addOfferVacational(LocalDate startingDate, double price, House house, LocalDate endingDate)
			throws HostException {
		RegisteredUser u = this.getLoggedUser();
		if (u == null) {
			HostException e = new HostException();
			throw e;
		}
		if (u.isHost() == false) {
			HostException e = new HostException();
			throw e;
		}
		Offer o = new Vacational(startingDate, price, u, house, endingDate);
		for (Offer oldOffer : this.offers) {
			if (oldOffer.equals(o)) {
				return;
			}
		}
		this.offers.add(o);
		this.admin.addOffer(o);
		u.getHost().addOffer(o);
	}

	/**
	 * Get the offers of a host user
	 * 
	 * @param user
	 *            Host
	 * @return List of offers of null it it isn't logged
	 * @throws HostException
	 *             The user is not a host
	 */
	public List<Offer> getHostOffers(RegisteredUser user) throws HostException {
		if (user.getState() != 1) {
			return null;
		}
		if (user.isHost() == false) {
			HostException e = new HostException();
			throw e;
		}
		for (Profile p : user.getProfile()) {
			if (p.isHost()) {
				return p.getOffers();
			}
		}
		return null;
	}

	/**
	 * Get the offers from a guest user
	 * 
	 * @param user
	 *            Guest
	 * @return Offers or null if it isn't registered
	 * @throws GuestException
	 *             the user is not a guest
	 */
	public List<Offer> getGuestOffers(RegisteredUser user) throws GuestException {
		if (user.getState() != 1) {
			return null;
		}
		if (user.isGuest() == false) {
			GuestException e = new GuestException();
			throw e;
		}
		for (Profile p : user.getProfile()) {
			if (p.isGuest()) {
				return p.getOffers();
			}
		}
		return null;
	}

	/**
	 * Get the admin offers
	 * 
	 * @return Offers or null it the admin isn't logged
	 */
	public List<Offer> getAdminOffers() {
		if (admin.getState() != 1) {
			return null;
		}
		return admin.getOffers();
	}

	/**
	 * Search by type
	 * 
	 * @param type
	 *            Type of the offer
	 * @return offers
	 */
	public List<Offer> searchOfferType(String type) {
		List<Offer> l = new ArrayList<>();
		if (type.equals("Living")) {
			for (Offer o : offers) {
				if (o.getState() == 1) {
					if (o.isLiving()) {
						l.add(o);
					}
				}
			}
		} else if (type.equals("Vacational")) {
			for (Offer o : offers) {
				if (o.getState() == 1) {
					if (o.isVacational()) {
						l.add(o);
					}

				}
			}
		}
		return l;
	}

	/**
	 * Search offer by zip
	 * 
	 * @param z
	 *            Zip code
	 * @return Offers
	 */
	public List<Offer> searchOfferZip(int z) {
		List<Offer> l = new ArrayList<>();
		for (Offer o : offers) {
			if (o.getState() == 1) {
				if (o.getHouse().getZip() == z) {
					l.add(o);
				}
			}
		}
		return l;
	}

	/**
	 * Search by initial date
	 * 
	 * @param d1
	 *            First date
	 * @param d2
	 *            Second date
	 * @return Offers
	 */
	public List<Offer> searchOfferDate(LocalDate d1, LocalDate d2) {
		List<Offer> l = new ArrayList<>();
		for (Offer o : offers) {
			if (o.getState() == 1) {
				if (o.getStartingDate().compareTo(d1) >= 0 && o.getStartingDate().compareTo(d2) <= 0) {
					l.add(o);
				}
			}
		}
		return l;
	}

	/**
	 * Search offer by rate
	 * 
	 * @param min
	 *            Minimal rate
	 * @return Offers
	 * @throws NonRegisteredException
	 *             The user is not registered
	 */
	public List<Offer> searchOfferRate(int min) throws NonRegisteredException {
		for (RegisteredUser u : users) {
			if (u.getState() == 1) {
				List<Offer> l = new ArrayList<>();
				for (Offer o : offers) {
					if (o.getRate() >= min) {
						if (o.getState() != -1) {
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

	/**
	 * Search reserved offers
	 * 
	 * @return Offers
	 * @throws NonRegisteredException
	 *             The user is not a registered user
	 */
	public List<Offer> searchOfferReserved() throws NonRegisteredException {
		for (RegisteredUser u : users) {
			if (u.getState() == 1) {
				List<Offer> l = new ArrayList<>();
				for (Offer o : offers) {
					if (o.getState() == 3) {
						l.add(o);
					}
				}
				return l;
			}
		}
		NonRegisteredException e = new NonRegisteredException();
		throw e;
	}

	/**
	 * Search bought offers
	 * 
	 * @return Offers
	 * @throws NonRegisteredException
	 *             The user is not regiestered
	 */
	public List<Offer> searchOfferBought() throws NonRegisteredException {
		for (RegisteredUser u : users) {
			if (u.getState() == 1) {
				List<Offer> l = new ArrayList<>();
				for (Offer o : offers) {
					if (o.getState() == 4) {
						l.add(o);
					}
				}
				return l;
			}
		}
		NonRegisteredException e = new NonRegisteredException();
		throw e;
	}

	/**
	 * File backup
	 */
	private void backup() {
		List<Offer> noffers = new ArrayList<>();
		for (Offer o : admin.getOffers()) {
			if (o.getState() == -1 || o.getState() == 2) {
				noffers.add(o);
			}
		}
		admin.getOffers().removeAll(noffers);

		for (RegisteredUser r : users) {
			for (Profile p : r.getProfile()) {
				noffers = new ArrayList<>();
				for (Offer o : p.getOffers()) {
					if (o.getState() == -1) {
						noffers.add(o);
					}
				}
				p.getOffers().removeAll(noffers);
			}
		}

		noffers = new ArrayList<>();
		for (Offer o : this.offers) {
			if (o.getState() == -1) {
				noffers.add(o);
			}
		}
		this.offers.removeAll(noffers);

		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("SystemBackup.objectData"));
			oos.writeObject(this);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

	}

	/**
	 * toString of the app
	 */
	public String toString() {
		String res = "J&MA: \n";
		return res + admin;
	}
}
