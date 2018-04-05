package user;

import java.io.Serializable;
import java.util.*;

import offer.Offer;

/**
 * Admin class. It implements the admin of the application
 * 
 * @author Miguel Angel Sanchez y Juan Velasco
 *
 */
public class Admin implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String surname;
	private String password;
	private String id;
	private int state;
	private List<Offer> offers;

	/**
	 * Creates a new admin
	 * 
	 * @param name
	 *            Name of the admin
	 * @param surname
	 *            Surname of the admin
	 * @param password
	 *            Password of the admin
	 * @param id
	 *            Id of the admin
	 */

	public Admin(String name, String surname, String password, String id) {
		super();
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.id = id;
		state = 0;
		offers = new ArrayList<>();
	}

	/**
	 * Gets the name of the admin
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the admin
	 * 
	 * @param name
	 *            Name of the admin
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the surname of the admin
	 * 
	 * @return surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Sets the surname of the admin
	 * 
	 * @param surname
	 *            Surname of the admin
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * Gets the password of the admin
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password of the admin
	 * 
	 * @param password
	 *            Password of the admin
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the id of the admin
	 * 
	 * @return Id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the Id of the admin
	 * 
	 * @param id
	 *            Id of the admin
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the state of the admin
	 * 
	 * @return state
	 */
	public int getState() {
		return state;
	}

	/**
	 * Sets the state of the admin
	 * 
	 * @param state
	 *            State of the admin
	 */
	public void setState(int state) {
		this.state = state;
	}

	/**
	 * Adds an offer to the list of the offers of the admin
	 * 
	 * @param o
	 *            Offer that needs to be added
	 */
	public void addOffer(Offer o) {
		offers.add(o);
	}

	/**
	 * Gets the offers of the admin
	 * 
	 * @return List of the offers of the admin
	 */
	public List<Offer> getOffers() {
		return offers;
	}

	/**
	 * toString for the admin
	 */
	public String toString() {
		return "Admin:\n" + "Name: " + name + " " + surname;
	}

}
