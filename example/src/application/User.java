package application;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String nombre, nick;
	private int edad;
	
	/**
	 * 
	 * @param n_
	 * @param ni_
	 */
	public User(String n_, String ni_) {
		nombre = n_;
		nick = ni_;
		edad = 45;
	}
	
	public String printInfo() {
		return nombre+ "(" + nick + ")";
	}
	
	 /**
	  * 
	  * @param years
	  * @return
	  */
	public int sumaAnyos(int years) {
		return edad+ years;
	}
}
