package junit;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import exception.GuestException;
import exception.HostException;
import offer.*;
import user.*;

public class OfferTest {

	@Test
	public void testOffer() {
		RegisteredUser user = new RegisteredUser("Paco", "Sanchez","1","Wololo","1234a1234",true,true);
		House house = new House("Madrid",28903,"Avenida de la Felicidad nº 23.\n Very wide\nPool");
		Offer offer = null;
		ModifiableDate.setToday();
		try {
			offer = new Living(LocalDate.of(2022, 3, 31),2020202,user,house,30);
			assertNotNull(offer);
		} catch (HostException e) {
			fail("Not a host");
		}
	}

	
	@Test
	public void testApproveOffer() {
		Admin admin = new Admin("Pedro","Balodis","youaregoingtofail","2");
		RegisteredUser user = new RegisteredUser("Paco", "Sanchez","1","Wololo","1234a1234",true,true);
		House house = new House("Madrid",28903,"Avenida de la Felicidad nº 23.\n Very wide\nPool");
		Offer offer = null;
		ModifiableDate.setToday();
		try {
			offer = new Living(LocalDate.of(2022, 3, 31),2020202,user,house,30);
			assertNotNull(offer);
			offer.approveOffer(admin);
			assertEquals(1, offer.getState());
		} catch (HostException e) {
			fail("Not a host");
		}
	}

	@Test
	public void testDenyOffer() {
		Admin admin = new Admin("Pedro","Balodis","youaregoingtofail","2");
		RegisteredUser user = new RegisteredUser("Paco", "Sanchez","1","Wololo","1234a1234",true,true);
		House house = new House("Madrid",28903,"Avenida de la Felicidad nº 23.\n Very wide\nPool");
		Offer offer = null;
		ModifiableDate.setToday();
		try {
			offer = new Living(LocalDate.of(2022, 3, 31),2020202,user,house,30);
			assertNotNull(offer);
			offer.denyOffer(admin);
			assertEquals(-1, offer.getState());
		} catch (HostException e) {
			fail("Not a host");
		}
	}

	@Test
	public void testAskForChanges() {
		Admin admin = new Admin("Pedro","Balodis","youaregoingtofail","2");
		RegisteredUser user = new RegisteredUser("Paco", "Sanchez","1","Wololo","1234a1234",true,true);
		House house = new House("Madrid",28903,"Avenida de la Felicidad nº 23.\n Very wide\nPool");
		Offer offer = null;
		ModifiableDate.setToday();
		try {
			offer = new Living(LocalDate.of(2022, 3, 31),2020202,user,house,30);
			assertNotNull(offer);
			offer.askForChanges("wolo",admin);
			assertEquals(2, offer.getState());
		} catch (HostException e) {
			fail("Not a host");
		}
	}

	@Test
	public void testCancelOfer() {
		RegisteredUser user = new RegisteredUser("Paco", "Sanchez","1","Wololo","1234a1234",true,true);
		House house = new House("Madrid",28903,"Avenida de la Felicidad nº 23.\n Very wide\nPool");
		Offer offer = null;
		ModifiableDate.setToday();
		try {
			offer = new Living(LocalDate.of(2022, 3, 31),2020202,user,house,30);
			assertNotNull(offer);
			offer.cancelOfer();
			assertEquals(-1, offer.getState());
		} catch (HostException e) {
			fail("Not a host");
		}
	}

	@Test
	public void testModifyOffer() {
		RegisteredUser user = new RegisteredUser("Paco", "Sanchez","1","Wololo","1234a1234",true,true);
		House house = new House("Madrid",28903,"Avenida de la Felicidad nº 23.\n Very wide\nPool");
		Offer offer = null;
		ModifiableDate.setToday();
		try {
			offer = new Living(LocalDate.of(2022, 3, 31),2020202,user,house,30);
			assertNotNull(offer);
			offer.setState(2);
			assertTrue(offer.modifyOffer(house, LocalDate.now(), 10));
			offer.setState(1);
			assertFalse(offer.modifyOffer(house, LocalDate.now(), 10));
			ModifiableDate.plusDays(1000);
			assertFalse(offer.modifyOffer(house, LocalDate.now(), 10));
		} catch (HostException e) {
			fail("Not a host");
		}
	}

	@Test
	public void testReserveOffer() {
		RegisteredUser user = new RegisteredUser("Paco", "Sanchez","1","Wololo","1234a1234",true,true);
		House house = new House("Madrid",28903,"Avenida de la Felicidad nº 23.\n Very wide\nPool");
		Offer offer = null;
		ModifiableDate.setToday();
		try {
			offer = new Living(LocalDate.of(2022, 3, 31),2020202,user,house,30);
			assertNotNull(offer);
			offer.setState(2);
			try {
				assertFalse(offer.reserveOffer(user));
			} catch (GuestException e) {
				fail("Not a guest");
			}
			offer.setState(1);
			try {
				assertTrue(offer.reserveOffer(user));
			} catch (GuestException e) {
				fail("Not a guest");
			}
		} catch (HostException e) {
			fail("Not a host");
		}
	}

	@Test
	public void testBuyOffer() {
		fail("Not yet implemented");
	}

	@Test
	public void testCommentOffer() {
		fail("Not yet implemented");
	}

	@Test
	public void testRateOffer() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsLiving() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsVacational() {
		fail("Not yet implemented");
	}
}
