package user;

import java.io.Serializable;
import java.util.*;

import exception.*;

public class RegisteredUser implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String surename;
	private String id;
	private String password;
	private String creditCard;
	private List<Profile> profile;
	private int state;
	
	
	/**
	 * Creates a registered user
	 * @param name Name of the user
	 * @param surename Surname of the user
	 * @param id Id of the user
	 * @param password Password of the user
	 * @param creditCard CreditCard of the user
	 * @param guest If the user is a guest or not
	 * @param host If the user is a host or not
	 */
	public RegisteredUser(String name, String surename, String id, String password, String creditCard,boolean guest,boolean host) {
		this.name = name;
		this.surename = surename;
		this.id = id;
		this.password = password;
		this.creditCard = creditCard;
		profile = new ArrayList<>();
		if (guest) {
			profile.add(new Guest());
		}
		if (host) {
			profile.add(new Host());
		}
		this.state = 0; /** no loggeado**/
	}
	
	/**
	 * Gets the name of the user
	 * @return Name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the surname of the user
	 * @return Surname
	 */
	public String getSurename() {
		return surename;
	}
	
	/**
	 * Gets the id of the user
	 * @return Id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gets the password of the user
	 * @return Password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Gets the credit card of the user
	 * @return creditcard
	 */
	public String getCreditCard() {
		return creditCard;
	}

	/**
	 * Gets the state of the user
	 * @return state
	 */
	public int getState() {
		return state;
	}
	
	/**
	 * Sets the state of the user
	 * @param state State of the user
	 */
	public void setState(int state) {
		this.state = state;
	}
	
	/**
	 * Checks if the user is a guest
	 * @return true if it's a guest, false if it's not
	 */
	public boolean isGuest() {
		for (Profile p: profile) {
			if (p.isGuest()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks if the user is a host
	 * @return true if it's a host, false if it's not
	 */
	public boolean isHost() {
		for (Profile p: profile) {
			if (p.isHost()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Gets the profile of the guest
	 * @return profile
	 * @throws GuestException It's not a guest
	 */
	public Profile getGuest() throws GuestException {
		for(Profile p: profile) {
			if (p.isGuest()) {
				return p;
			}
		}
		GuestException g = new GuestException();
		throw g;
	}
	
	/**
	 * Gets the profile of the host
	 * @return profile
	 * @throws HostException It's not a host
	 */
	public Profile getHost() throws HostException {
		for(Profile p: profile) {
			if (p.isHost()) {
				return p;
			}
		}
		HostException h = new HostException();
		throw h;
	}
	
	/**
	 * Bans a user changing its state
	 */
	public void banUser() {
		state = -1;
	}
	
	/**
	 * Unbans a user changing state and credit card
	 * @param creditCard New credit card
	 */
	public void unbanUser(String creditCard) {
		state = 0;
		this.creditCard = creditCard;
	}

	/**
	 * Gets the profiles of the user
	 * @return List of the profiles
	 */
	public List<Profile> getProfile() {
		return profile;
	}
	
}
