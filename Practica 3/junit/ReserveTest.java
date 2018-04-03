package junit;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import exception.GuestException;
import exception.HostException;
import offer.*;
import user.RegisteredUser;
public class ReserveTest {

	@Test
	public void testReserve() {
		Offer o = null; 
		try {
			o = new Living(LocalDate.of(2007,2,1), 20.3,new RegisteredUser("Paco", "Sanchez",1,"Wololo","1234a1234",false,true),new House("Madrid",28903,"Avenida de la Felicidad nº 23.\n Very wide\nPool"),10);
		} catch (HostException e) {
			fail("Not a host");
		}	
		RegisteredUser r = new RegisteredUser("Sergio", "Jimenez",31,"Wololo","1234a1234",true,false);
		try {
			assertNotNull(new Reserve(LocalDate.of(2011, 2, 3),r,o));
		} catch (GuestException e) {
			fail("Not a guest");
		}
	}

	@Test
	public void testGetDateFin() {
		Offer o = null; 
		Reserve res = null;
		try {
			o = new Living(LocalDate.of(2007,2,1), 20.3,new RegisteredUser("Paco", "Sanchez",1,"Wololo","1234a1234",false,true),new House("Madrid",28903,"Avenida de la Felicidad nº 23.\n Very wide\nPool"),10);
		} catch (HostException e) {
			fail("Not a host");
		}	
		RegisteredUser r = new RegisteredUser("Sergio", "Jimenez",31,"Wololo","1234a1234",true,false);
		try {
			res = new Reserve(LocalDate.of(2011, 2, 3),r,o);
			assertNotNull(res);
		} catch (GuestException e) {
			fail("Not a guest");
		}
		assertEquals(LocalDate.of(2011, 2, 3),res.getDateFin());
	}

	@Test
	public void testGetGuest() {
		Offer o = null; 
		Reserve res = null;
		try {
			o = new Living(LocalDate.of(2007,2,1), 20.3,new RegisteredUser("Paco", "Sanchez",1,"Wololo","1234a1234",false,true),new House("Madrid",28903,"Avenida de la Felicidad nº 23.\n Very wide\nPool"),10);
		} catch (HostException e) {
			fail("Not a host");
		}	
		RegisteredUser r = new RegisteredUser("Sergio", "Jimenez",31,"Wololo","1234a1234",true,false);
		try {
			res = new Reserve(LocalDate.of(2011, 2, 3),r,o);
			assertNotNull(res);
		} catch (GuestException e) {
			fail("Not a guest");
		}
		assertEquals(r,res.getGuest());
	}

	@Test
	public void testGetOffer() {
		Offer o = null; 
		Reserve res = null;
		try {
			o = new Living(LocalDate.of(2007,2,1), 20.3,new RegisteredUser("Paco", "Sanchez",1,"Wololo","1234a1234",false,true),new House("Madrid",28903,"Avenida de la Felicidad nº 23.\n Very wide\nPool"),10);
		} catch (HostException e) {
			fail("Not a host");
		}	
		RegisteredUser r = new RegisteredUser("Sergio", "Jimenez",31,"Wololo","1234a1234",true,false);
		try {
			res = new Reserve(LocalDate.of(2011, 2, 3),r,o);
			assertNotNull(res);
		} catch (GuestException e) {
			fail("Not a guest");
		}
		assertEquals(o,res.getOffer());
	}

}
