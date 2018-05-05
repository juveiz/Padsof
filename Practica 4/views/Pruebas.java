package views;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controllers.AdminOfferController;
import controllers.HousesController;
import exception.HostException;
import offer.*;
import system.Application;
import user.Admin;
import user.RegisteredUser;

public class Pruebas {
	public static void main(String args[]) {
		Admin admin = new Admin("Pedro", "Balodis", "youaregoingtofail", "2");
		RegisteredUser user = new RegisteredUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, true);
		House house = new House("Madrid", 28903, "Avenida de la Felicidad nº 23.\n Very wide\nPool");
		List<Offer> offers = new ArrayList<>();
		for (int i = 1; i <= 18; i++) {
			try {
				offers.add(new Living(LocalDate.of(2022, 3, i), 2020202, user, house, 30));
			} catch (HostException e) {
				e.printStackTrace();
			}
		}
		OfferView v = new OfferView(offers.get(0));

		v.setVisible(true);
	}
}
