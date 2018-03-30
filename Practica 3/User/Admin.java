package User;
import java.util.*;

import offer.Offer;

public class Admin {
	
	private String name;
	private String surname;
	private String password;
	private int id;
	private int state;
	private List<Offer> offers;
	
	public Admin(String name, String surname, String password, int id) {
		super();
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.id = id;
		state = 0;
		offers = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	public void addOffer(Offer o) {
		offers.add(o);
	}
	public List<Offer> getOffer(){
		return offers;
	}

	
	

}
