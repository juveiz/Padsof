package junit;

import static org.junit.Assert.*;

import org.junit.*;

import Exception.GuestException;
import User.*;
import comments.*;

public class NumericalTest {

	@Test
	public void testNumerical() {
		RegisteredUser u = new RegisteredUser("Paco", "Sanchez",1,"Wololo","1234a1234",true,false);
		Numerical n;
		try {
			n = new Numerical(1.0,u);
			assertNotNull(n);
		} catch (GuestException e) {
			fail("Don't work");
		}
		u = new RegisteredUser("Paco", "Sanchez",1,"Wololo","1234a1234",false,false);
		try {
			n = new Numerical(1.0,u);
			fail("Don't work");
		} catch (GuestException e) {
			assertNotNull(e);
		}
	}

	@Test
	public void testGetRate() {
		RegisteredUser u = new RegisteredUser("Paco", "Sanchez",1,"Wololo","1234a1234",true,false);
		Numerical n;
		try {
			n = new Numerical(1.0,u);
			assertNotNull(n);
			assertTrue(1.0 == n.getRate());
		} catch (GuestException e) {
			fail("Don't work");
		}
		
	}
	
	@Test
	public void testGetGuest() {
		RegisteredUser u = new RegisteredUser("Paco", "Sanchez",1,"Wololo","1234a1234",true,false);
		Numerical n;
		try {
			n = new Numerical(1.0,u);
			assertNotNull(n);
			assertNotNull(n.getGuest());
		} catch (GuestException e) {
			fail("Don't work");
		}
	}

}
