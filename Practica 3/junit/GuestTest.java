package junit;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import exception.HostException;
import offer.House;
import offer.Living;
import offer.ModifiableDate;
import offer.Offer;
import user.Guest;
import user.RegisteredUser;

public class GuestTest {

	@Test
	public void testAddOffer() {
		RegisteredUser user = new RegisteredUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, true);
		House house = new House("Madrid", 28903, "Avenida de la Felicidad nº 23.\n Very wide\nPool");
		Offer offer = null;
		Guest guest = new Guest();
		ModifiableDate.setToday();
		try {
			offer = new Living(LocalDate.of(2022, 3, 31), 2020202, user, house, 30);
			assertNotNull(offer);
			guest.addOffer(offer);
			assertEquals(1, guest.getOffers().size());
		} catch (HostException e) {
			fail("Not a host");
		}
	}

	@Test
	public void testRemoveOffer() {
		RegisteredUser user = new RegisteredUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, true);
		House house = new House("Madrid", 28903, "Avenida de la Felicidad nº 23.\n Very wide\nPool");
		Offer offer = null;
		Guest guest = new Guest();
		ModifiableDate.setToday();
		try {
			offer = new Living(LocalDate.of(2022, 3, 31), 2020202, user, house, 30);
			assertNotNull(offer);
			guest.addOffer(offer);
			assertEquals(1, guest.getOffers().size());
		} catch (HostException e) {
			fail("Not a host");
		}
	}

	@Test
	public void testIsGuest() {
		assertTrue(new Guest().isGuest());
	}

	@Test
	public void testGuest() {
		assertNotNull(new Guest());
	}

}
