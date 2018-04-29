package views;

import user.RegisteredUser;

public class Pruebas {
	public static void main(String args[]) {
		HostView view = new HostView(new RegisteredUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, true));
		view.setVisible(true);
	}
}
