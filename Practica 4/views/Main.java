package views;

import user.RegisteredUser;

public class Main {
	public static void main(String args[]) {
		RegisteredUser u = new RegisteredUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, true);
		guestView view = new guestView(u);
	}
}
