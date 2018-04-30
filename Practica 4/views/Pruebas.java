package views;

import user.Admin;

public class Pruebas {
	public static void main(String args[]) {
		AdminView view = new AdminView(new Admin("Paco", "Sanchez", "1", "Wololo"));
		view.setVisible(true);
	}
}
