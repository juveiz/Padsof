package system;

import java.io.*;
import java.time.LocalDate;

import comments.*;
import exception.*;
import offer.*;
import user.*;

public class MainTest2 {
	public static void main(String[] args) {
		Application app = Application.getApplication("Eva", "Touris", "OpenBalls");
		RegisteredUser user = null;
		House house = null;
		Offer offer = null;
		Admin admin = null;

		System.out.println("First we check that the backup and the restore of the application has been made correctly\nWe check all the offers to see this\n");
		for(Offer o: app.searchOfferDate(LocalDate.now().minusDays(1000),LocalDate.now().plusDays(10000))) {
			System.out.println(o + "\n");
			offer = o;
		}
		/**
		 * Login as user again
		 */
		System.out.println("We login as a user\n");
		try {
			user = app.loginUser("54444111D", "olvidame");
		} catch (LoggedException | BannedUserException e) {
			e.printStackTrace();
			return;
		}
		System.out.println("We comment an offer as a guest\n");
		try {
			offer.commentOffer(user, "Very well Manuel");
		} catch (GuestException e) {
			e.printStackTrace();
			return;
		}
		System.out.println(offer.getComments());
		System.out.println("We rate an offer as a guest\n");
		try {
			offer.rateOffer(user,5);
		} catch (GuestException e) {
			e.printStackTrace();
			return;
		}
		System.out.println(offer.getComments());
		System.out.println("\nWe get the rate of an offer\n");
		System.out.println(offer.getRate());
		System.out.println("\nWe search an offer for his rate\n");
		try {
			for(Offer o: app.searchOfferRate(2)) {
				System.out.println(o + "\n");
			}
		} catch (NonRegisteredException e1) {
			System.out.println(e1);
			return;
		}
		System.out.println("We reserve an offer\n");
		try {
			System.out.println("Reserve offer: " + offer.reserveOffer(user));
		} catch (GuestException e) {
			e.printStackTrace();
			return;
		}
		System.out.println("\nWe search the reserved offers\n");
		try {
			for(Offer o: app.searchOfferReserved()) {
				System.out.println(o + "\n");
			}
		} catch (NonRegisteredException e1) {
			System.out.println(e1);
			return;
		}
		System.out.println("\nWe try to reserve a non available offer and see that we can't\n");
		try {
			System.out.println("Reserve offer: " + offer.reserveOffer(user));
		} catch (GuestException e) {
			e.printStackTrace();
			return;
		}
		System.out.println("\nWe try to buy the reserved offer");
		try {
			System.out.println(offer);
			if(offer.buyOffer(user, "Because yes", true) != 0) {
				System.out.print("Payment failed");
				return;
			}
		} catch (GuestException e) {
			e.printStackTrace();
		}
		System.out.print("\nWe try to buy a non reserved offer\n");
		offer = app.searchOfferDate(LocalDate.now().minusDays(1000),LocalDate.now().plusDays(10000)).get(0);
		try {
			System.out.println(offer);
			if(offer.buyOffer(user, "10/10 IGN", true) != 0) {
				System.out.print("Payment failed");
				return;
			}
		} catch (GuestException e) {
			e.printStackTrace();
		}
		System.out.println("\nWe search the bought offers\n");
		try {
			for(Offer o: app.searchOfferBought()) {
				System.out.println(o + "\n");
				o.setState(1);
			}
		} catch (NonRegisteredException e1) {
			System.out.println(e1);
			return;
		}
		System.out.println("\nWe have made all the offers avialable again\n");
		System.out.println("Now we are going to change an user credit card, making it false\n");
		app.logut();
		
		try {
			user = app.loginUser("55555111Z", "NoSeSaBe");
		} catch (LoggedException | BannedUserException e1) {
			e1.printStackTrace();
			return;
		}
		System.out.print("\nOld credit card: " + user.getCreditCard());
		app.logut();
		try {
			admin = app.loginAdmin("ImTheMdfkAdmin", "OpenBalls");
		} catch (LoggedException e) {
			e.printStackTrace();
			return;
		}
		user.unbanUser("1234a12342", admin);
		app.logut();
		try {
			user = app.loginUser("55555111Z", "NoSeSaBe");
		} catch (LoggedException | BannedUserException e1) {
			e1.printStackTrace();
			return;
		}
		if (user != null) {
			System.out.println("\nWelcome: " + user);
		} else {
			System.out.println("Something went wrong");
			return;
		}
		System.out.print("\nNew credit card: " + user.getCreditCard());
		offer = app.searchOfferDate(LocalDate.now().minusDays(1000),LocalDate.now().plusDays(10000)).get(0);
		try {
			System.out.println(offer);
			if(offer.buyOffer(user, "10/10 IGN 2.0", true) != -1) {
				System.out.print("This won't happen never LUL\n");
				return;
			}
			System.out.println("\nBanned user. The credit card was false\n");
		} catch (GuestException e) {
			e.printStackTrace();
		}
		app.logut();
		System.out.println("We try to login with the same user\n");
		try {
			user = app.loginUser("55555111Z", "NoSeSaBe");
			return;
		} catch (LoggedException | BannedUserException e1) {
			System.out.println(e1);
			user = ((BannedUserException) e1).getUser();
		}
		System.out.println("\nWe unban the user with the admin\n");
		try {
			admin = app.loginAdmin("ImTheMdfkAdmin", "OpenBalls");
		} catch (LoggedException e) {
			e.printStackTrace();
			return;
		}
		user.unbanUser("7777222288885555", admin);
		app.logut();
		System.out.println("Unbanned. We try to login again and try to buy an offer\n");
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
		System.out.println("\nNew credit card: " + user.getCreditCard());
		System.out.println("\nWe get an Failed internet connection\n");
		
	}
}
