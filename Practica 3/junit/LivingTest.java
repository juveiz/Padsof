package junit;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import exception.HostException;
import offer.*;
import user.RegisteredUser;

public class LivingTest {

	@Test
	public void testLiving() {
		Living o = null;
		try {
			o = new Living(LocalDate.of(2022, 3, 31), 200009.9, new RegisteredUser("Paco", "Sanchez","1","Wololo","1234a1234",true,true),new House("Madrid",28903,"Avenida de la Felicidad nº 23.\n Very wide\nPool"),2);
			assertNotNull(o);
		} catch (HostException e) {
			fail("Not a host");
		}
	}

	@Test
	public void testGetMonths() {
		Living o = null;
		try {
			o = new Living(LocalDate.of(2022, 3, 31), 200009.9, new RegisteredUser("Paco", "Sanchez","1","Wololo","1234a1234",true,true),new House("Madrid",28903,"Avenida de la Felicidad nº 23.\n Very wide\nPool"),2);
			assertNotNull(o);
		} catch (HostException e) {
			fail("Not a host");
		}
		assertTrue(2.0 == ((Living) o).getMonths());
	}

	@Test
	public void testModifyOffer() {
		Living o = null;
		try {
			o = new Living(LocalDate.of(2022, 3, 31), 200009.9, new RegisteredUser("Paco", "Sanchez","1","Wololo","1234a1234",true,true),new House("Madrid",28903,"Avenida de la Felicidad nº 23.\n Very wide\nPool"),2);
			assertNotNull(o);
		} catch (HostException e) {
			fail("Not a host");
		}
		assertTrue( o.modifyOffer(new House("Madrid",28903,"Avenida de la Felicidad nº 23.\n Very wide\nPool"), LocalDate.of(2022, 5, 31), 500.5,50));
	}

}
