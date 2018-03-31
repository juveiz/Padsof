package junit;

import static org.junit.Assert.*;

import java.time.LocalDate;

import offer.*;

import org.junit.Test;

import Exception.HostException;
import User.RegisteredUser;

public class VacationalTest {

	@Test
	public void testVacational() {
		Vacational o = null;
		try {
			o = new Vacational(LocalDate.of(2022, 3, 31), 200009.9, new RegisteredUser("Paco", "Sanchez",1,"Wololo","1234a1234",true,true),new House("Madrid",28903,"Avenida de la Felicidad nº 23.\n Very wide\nPool"),LocalDate.of(2022, 4, 30));
			assertNotNull(o);
		} catch (HostException e) {
			fail("Not a host");
		}
	}

	@Test
	public void testGetEndingDate() {
		Vacational o = null;
		try {
			o = new Vacational(LocalDate.of(2022, 3, 31), 200009.9, new RegisteredUser("Paco", "Sanchez",1,"Wololo","1234a1234",true,true),new House("Madrid",28903,"Avenida de la Felicidad nº 23.\n Very wide\nPool"),LocalDate.of(2022, 4, 30));
			assertNotNull(o);
		} catch (HostException e) {
			fail("Not a host");
		}
		assertEquals(LocalDate.of(2022, 4, 30),o.getEndingDate());
	}

	@Test
	public void testModifyOfferHouseLocalDateDoubleLocalDate() {
		Vacational o = null;
		try {
			o = new Vacational(LocalDate.of(2022, 3, 31), 200009.9, new RegisteredUser("Paco", "Sanchez",1,"Wololo","1234a1234",true,true),new House("Madrid",28903,"Avenida de la Felicidad nº 23.\n Very wide\nPool"),LocalDate.of(2022, 4, 30));
			assertNotNull(o);
		} catch (HostException e) {
			fail("Not a host");
		}
		assertTrue( o.modifyOffer(new House("Madrid",28903,"Avenida de la Felicidad nº 23.\n Very wide\nPool"), LocalDate.of(2022, 5, 31), 500.5,LocalDate.of(2022, 6, 24)));
	}

}
