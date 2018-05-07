package junit;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import exception.HostException;
import offer.House;
import offer.Living;
import offer.ModifiableDate;
import offer.Offer;
import user.Admin;
import user.RegisteredUser;

public class AdminTest {

	@Test
	public void testAdmin() {
		assertNotNull(new Admin("Pedro", "Balodis", "youaregoingtofail", "2"));
	}

	@Test
	public void testGetName() {
		Admin a = new Admin("Pedro", "Balodis", "youaregoingtofail", "2");
		assertEquals(a.getName(), "Pedro");
	}

	@Test
	public void testSetName() {
		Admin a = new Admin("Pedro", "Balodis", "youaregoingtofail", "2");
		a.setName("Paco");
		assertEquals(a.getName(), "Paco");
	}

	@Test
	public void testGetSurname() {
		Admin a = new Admin("Pedro", "Balodis", "youaregoingtofail", "2");
		assertEquals(a.getSurname(), "Balodis");
	}

	@Test
	public void testSetSurname() {
		Admin a = new Admin("Pedro", "Balodis", "youaregoingtofail", "2");
		a.setSurname("Wanolo");
		assertEquals(a.getSurname(), "Wanolo");
	}

	@Test
	public void testGetPassword() {
		Admin a = new Admin("Pedro", "Balodis", "youaregoingtofail", "2");
		assertEquals(a.getPassword(), "youaregoingtofail");
	}

	@Test
	public void testSetPassword() {
		Admin a = new Admin("Pedro", "Balodis", "youaregoingtofail", "2");
		a.setPassword("1234a1234");
		assertEquals(a.getPassword(), "1234a1234");
	}

	@Test
	public void testGetId() {
		Admin a = new Admin("Pedro", "Balodis", "youaregoingtofail", "2");
		assertTrue(a.getId().equals("2"));
	}

	@Test
	public void testSetId() {
		Admin a = new Admin("Pedro", "Balodis", "youaregoingtofail", "2");
		a.setId("1");
		assertTrue(a.getId().equals("1"));
	}

	@Test
	public void testGetState() {
		Admin a = new Admin("Pedro", "Balodis", "youaregoingtofail", "2");
		assertTrue(a.getState() == 0);
	}

	@Test
	public void testSetState() {
		Admin a = new Admin("Pedro", "Balodis", "youaregoingtofail", "2");
		a.setState(1);
		assertTrue(a.getState() == 1);
	}

	@Test
	public void testAddOffer() {
		Admin a = new Admin("Pedro", "Balodis", "youaregoingtofail", "2");
		RegisteredUser user = new RegisteredUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, true);
		House house = new House("Madrid", 28903, "Avenida de la Felicidad nº 23.\n Very wide\nPool");
		Offer offer = null;
		ModifiableDate.setToday();
		try {
			offer = new Living(LocalDate.of(2022, 3, 31), 2020202, user, house, 30);
			assertNotNull(offer);
			a.addOffer(offer);
			assertEquals(a.getOffers().size(), 1);
		} catch (HostException e) {
			fail("Not a host");
		}
	}

	@Test
	public void testGetOffers() {
		Admin a = new Admin("Pedro", "Balodis", "youaregoingtofail", "2");
		RegisteredUser user = new RegisteredUser("Paco", "Sanchez", "1", "Wololo", "1234a1234", true, true);
		House house = new House("Madrid", 28903, "Avenida de la Felicidad nº 23.\n Very wide\nPool");
		Offer offer = null;
		ModifiableDate.setToday();
		try {
			offer = new Living(LocalDate.of(2022, 3, 31), 2020202, user, house, 30);
			assertNotNull(offer);
			a.addOffer(offer);
			assertEquals(a.getOffers().size(), 1);
		} catch (HostException e) {
			fail("Not a host");
		}
	}

}
