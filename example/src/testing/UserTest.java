package testing;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import application.User;

public class UserTest {

	public static User u;
	@After
	public void after() {
		System.out.println("Adios");
	}
	
	@Before
	public void esteEsBefore() {
		u = new User("antonio", "agpardo");
	}
	
	@Test
	public void testSumaAnyos(){
		assertEquals(u.sumaAnyos(1),46);
	}
	
	@Test
	public void testSumaAnyos2(){
		assertEquals(u.sumaAnyos(1),49);
	}

}
