package system;

import java.io.*;
import java.time.LocalDate;

import system.*;
import comments.*;
import exception.*;
import offer.*;
import user.*;

public class MainTest {
	public static void main(String[] args) {
		Application app = Application.getApplication("Eva", "Touris", "OpenBalls");
		RegisteredUser user = null;
		House house = null;
		Offer offer = null;
		Admin admin = null;

		System.out.println("First we charge the users for the txt");
		try {
			FileInputStream f = null;
			String line;
			f = new FileInputStream("ClientsExample.txt");
			BufferedReader buffer = new BufferedReader(new InputStreamReader(f));
			buffer.readLine();
			while ((line = buffer.readLine()) != null) {
				boolean guest, host;
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
					return;
				}
				System.out
						.println(app.addUser(newUser[3], newUser[2], newUser[1], newUser[4], newUser[5], guest, host));
			}
			buffer.close();
			System.out.println("User file charged for first time\n");
		} catch (IOException e) {
			System.out.println("The given file hasn't been opened");
			return;
		}
		System.out.println("First Application: \n" + app + "\n");
		/**
		 * First we login as a host user. First bad the ok
		 */

		System.out.println("Login as a host");
		try {
			user = app.loginUser("51999111X", "jojojo");
		} catch (LoggedException | BannedUserException e1) {
			e1.printStackTrace();
			return;
		}
		if (user == null) {
			System.out.println("The user is worng (51999111X,jojojo). Try a new user");
		} else {
			System.out.println("Something went wrong");
			return;
		}
		try {
			user = app.loginUser("51998111X", "pezEspada");
		} catch (LoggedException | BannedUserException e1) {
			e1.printStackTrace();
			return;
		}
		if (user == null) {
			System.out.println("The user is worng (51998111X,pezEspada). Try a new user");
		} else {
			System.out.println("Something went wrong");
			return;
		}
		try {
			user = app.loginUser("51999111X", "pezEspada");
		} catch (LoggedException | BannedUserException e1) {
			e1.printStackTrace();
			return;
		}
		if (user != null) {
			System.out.println("Welcome: " + user);
		} else {
			System.out.println("Something went wrong");
			return;
		}

		/**
		 * logout
		 */
		System.out.println("\nLogout: " + app.logut() + "\n");

		/**
		 * First we login as a guest user. First bad (id and password) and then ok
		 */

		System.out.println("Login as a guest");
		try {
			user = app.loginUser("55555111Z", "jojojo");
		} catch (LoggedException | BannedUserException e1) {
			e1.printStackTrace();
			return;
		}
		if (user == null) {
			System.out.println("The user is worng (55555111Z,jojojo). Try a new user");
		} else {
			System.out.println("Something went wrong");
			return;
		}
		try {
			user = app.loginUser("51998111X", "NoSeSaBe");
		} catch (LoggedException | BannedUserException e1) {
			e1.printStackTrace();
			return;
		}
		if (user == null) {
			System.out.println("The user is worng (51998111X,NoSeSaBe). Try a new user");
		} else {
			System.out.println("Something went wrong");
			return;
		}
		try {
			user = app.loginUser("55555111Z", "NoSeSaBe");
		} catch (LoggedException | BannedUserException e1) {
			e1.printStackTrace();
			return;
		}
		if (user != null) {
			System.out.println("Welcome: " + user);
		} else {
			System.out.println("Something went wrong");
			return;
		}

		/**
		 * logout
		 */
		System.out.println("\nLogout: " + app.logut() + "\n");

		/**
		 * First we login as both. First bad (id and password) and then ok
		 */

		System.out.println("Login as a both");
		try {
			user = app.loginUser("54444111D", "jojojo");
		} catch (LoggedException | BannedUserException e) {
			e.printStackTrace();
			return;
		}
		if (user == null) {
			System.out.println("The user is worng (54444111D,jojojo). Try a new user");
		} else {
			System.out.println("Something went wrong");
			return;
		}
		try {
			user = app.loginUser("51998111X", "olvidame");
		} catch (LoggedException | BannedUserException e) {
			e.printStackTrace();
			return;
		}
		if (user == null) {
			System.out.println("The user is worng (51998111X,olvidame). Try a new user");
		} else {
			System.out.println("Something went wrong");
			return;
		}
		try {
			user = app.loginUser("54444111D", "olvidame");
		} catch (LoggedException | BannedUserException e) {
			e.printStackTrace();
			return;
		}
		if (user != null) {
			System.out.println("Welcome: " + user);
		} else {
			System.out.println("Something went wrong");
			return;
		}

		/**
		 * Try to login with a logged user on the system
		 */
		System.out.println("\nLogging when a user is logged");
		try {
			user = app.loginUser("55555111Z", "NoSeSaBe");
			return;
		} catch (LoggedException | BannedUserException e) {
			System.out.println(e);
		}
		/**
		 * Host function: add house and check user houses
		 */
		System.out.println("\nHost functions: add a house a get his houses.");
		System.out.println("We add a first house: San Jose Street 1ºA. Getafe, 28901, New 108m2 Pool");
		try {
			app.addHouse("San Jose Street 1ºA. Getafe", 28901, "New\n108m2\nPool");
		} catch (HostException e) {
			System.out.println(e);
			return;
		}
		System.out.println("We add a second house: Happines Avenue. Madrid, 23456, 10 years old Duplex");
		try {
			app.addHouse("Happines Avenue. Madrid", 23456, "10 years old\nDuplex");
		} catch (HostException e) {
			System.out.println(e);
			return;
		}
		System.out.println("We check the user houses\n");
		try {
			for (House h : app.getHostHouses(user)) {
				System.out.println(h + "\n");
				house = h;
			}
		} catch (HostException e) {
			System.out.println(e);
			return;
		}
		/**
		 * Host functions: add offer
		 */
		System.out.println("\nHost functions: add an offer a get his offers.");
		System.out.println(
				"We add a living offer: \n" + "Initial date: " + LocalDate.now() + "\nPrice: 500\nMonths: 3\n" + house);
		try {
			app.addOfferLiving(LocalDate.now(), 500, house, 3);
		} catch (HostException e) {
			System.out.println(e);
			return;
		}
		System.out.println("We add a vacational offer: \n" + "Initial date: " + LocalDate.now()
				+ "\nPrice: 30\nFinal date: " + LocalDate.now().plusDays(15) + "\n" + house);
		try {
			app.addOfferVacational(LocalDate.now(), 30, house, LocalDate.now().plusDays(15));
		} catch (HostException e) {
			System.out.println(e);
			return;
		}
		System.out.println("We check the user offers\n");
		try {
			for (Offer o : app.getHostOffers(user)) {
				System.out.println(o + "\n");
				offer = o;
			}
		} catch (HostException e) {
			System.out.println(e);
			return;
		}
		/**
		 * Host function: cancel offer
		 */
		System.out.println("\nWe cancel the last offer we made");
		try {
			offer.cancelOfer();
		} catch (HostException e) {
			System.out.println(e);
			return;
		}
		System.out.println(
				"We check the user offers. It won't appear in the user offers because we remove the offer form his list\n");
		try {
			for (Offer o : app.getHostOffers(user)) {
				System.out.println(o + "\n");
				offer = o;
			}
		} catch (HostException e) {
			System.out.println(e);
			return;
		}
		System.out.println(
				"We add it again and we add another offer to try the admin functions. Now we are going to check the some admin functions\n");
		try {
			app.addOfferVacational(LocalDate.now(), 30, house, LocalDate.now().plusDays(15));
		} catch (HostException e) {
			System.out.println(e);
			return;
		}
		try {
			house = app.getHostHouses(user).get(0);
			app.addOfferVacational(LocalDate.of(2018, 3, 31), 3000, house, LocalDate.of(2018, 3, 31).plusDays(10));
		} catch (HostException e) {
			System.out.println(e);
			return;
		}

		app.logut();
		/**
		 * Login as an admin
		 */
		System.out.println("We login as an admin\n");
		try {
			admin = app.loginAdmin("ImTheMdfkAdmin", "OpenBalls");
		} catch (LoggedException e) {
			e.printStackTrace();
			return;
		}
		System.out.println("We see the admin offers\n");
		for (Offer o : app.getAdminOffers()) {
			System.out.println(o + "\n");
		}

		System.out.println("We aprove the first offer and see that it doesn't appear in the admin offers\n");
		app.getAdminOffers().get(0).approveOffer(admin);
		for (Offer o : app.getAdminOffers()) {
			System.out.println(o + "\n");
		}

		System.out.println("We deny the second offer and see the admin offers\n");
		app.getAdminOffers().get(0).denyOffer(admin);
		for (Offer o : app.getAdminOffers()) {
			System.out.println(o + "\n");
		}
		System.out.println("We ask for changes the third offer and see the admin offers\n");
		app.getAdminOffers().get(1).askForChanges("You have to change all", admin);
		for (Offer o : app.getAdminOffers()) {
			System.out.println(o + "\n");
		}
		System.out.println("We logout as an admin,try to modify the offer and approve the offer (we will add more offers)\n");
		app.logut();
		
		
		
		
		
		
		
		/**
		 * Login as user again
		 */
		System.out.println("We login as a user\n");
		try {
			user = app.loginUser("55555111Z", "NoSeSaBe");
		} catch (LoggedException | BannedUserException e1) {
			e1.printStackTrace();
			return;
		}
		System.out.println("We check all the search types\n");
		System.out.println("Search by type");
		for (Offer o : app.searchOfferType("Living")) {
			System.out.println(o + "\n");
		}
		app.logut();
	}
}
