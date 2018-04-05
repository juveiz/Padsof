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
		app.logut();
	}
}
