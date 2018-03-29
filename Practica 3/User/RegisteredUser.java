package User;

import java.util.*;
import Exception.*;

public class RegisteredUser {
	private String name;
	private String surename;
	private int id;
	private String password;
	private String creditCard;
	private List<Profile> profile;
	private int state;
	
	public RegisteredUser(String name, String surename, int id, String password, String creditCard,boolean guest,boolean host) {
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

	public String getName() {
		return name;
	}

	public String getSurename() {
		return surename;
	}

	public int getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public int getState() {
		return state;
	}
	
	public void setState(int state) {
		this.state = state;
	}
	
	public boolean isGuest() {
		for (Profile p: profile) {
			if (p.isGuest()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isHost() {
		for (Profile p: profile) {
			if (p.isHost()) {
				return true;
			}
		}
		return false;
	}
	
	public Profile getGuest() throws GuestException {
		for(Profile p: profile) {
			if (p.isGuest()) {
				return p;
			}
		}
		GuestException g = new GuestException();
		throw g;
	}
	
	public Profile getHost() throws HostException {
		for(Profile p: profile) {
			if (p.isHost()) {
				return p;
			}
		}
		HostException h = new HostException();
		throw h;
	}
	
	public void banUser() {
		state = -1;
	}
	
	public void unbanUser(String creditCard) {
		state = 0;
		this.creditCard = creditCard;
	}
	
}
