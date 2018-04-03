package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import user.Admin;

public class AdminTest {

	@Test
	public void testAdmin() {
		assertNotNull(new Admin("Pedro","Balodis","youaregoingtofail",2));
	}

	@Test
	public void testGetName() {
		Admin a = new Admin("Pedro","Balodis","youaregoingtofail",2);
		assertEquals(a.getName(),"Pedro");
	}

	@Test
	public void testSetName() {
		Admin a = new Admin("Pedro","Balodis","youaregoingtofail",2);
		a.setName("Paco");
		assertEquals(a.getName(),"Paco");
	}

	@Test
	public void testGetSurname() {
		Admin a = new Admin("Pedro","Balodis","youaregoingtofail",2);
		assertEquals(a.getSurname(),"Balodis");
	}

	@Test
	public void testSetSurname() {
		Admin a = new Admin("Pedro","Balodis","youaregoingtofail",2);
		a.setSurname("Wanolo");
		assertEquals(a.getSurname(),"Wanolo");
	}

	@Test
	public void testGetPassword() {
		Admin a = new Admin("Pedro","Balodis","youaregoingtofail",2);
		assertEquals(a.getSurname(),"youaregoingtofail");
	}

	@Test
	public void testSetPassword() {
		Admin a = new Admin("Pedro","Balodis","youaregoingtofail",2);
		a.setPassword("1234a1234");
		assertEquals(a.getPassword(),"1234a1234");
	}

	@Test
	public void testGetId() {
		Admin a = new Admin("Pedro","Balodis","youaregoingtofail",2);
		assertTrue(a.getId() == 2);
	}

	@Test
	public void testSetId() {
		Admin a = new Admin("Pedro","Balodis","youaregoingtofail",2);
		a.setId(1);
		assertTrue(a.getId() == 1);
	}

	@Test
	public void testGetState() {
		Admin a = new Admin("Pedro","Balodis","youaregoingtofail",2);
		assertTrue(a.getState() == 0);
	}

	@Test
	public void testSetState() {
		Admin a = new Admin("Pedro","Balodis","youaregoingtofail",2);
		a.setState(1);
		assertTrue(a.getState() == 1);
	}
	/**
	 * preguntar estos dos al profo
	 */
	@Test
	public void testAddOffer() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOffers() {
		fail("Not yet implemented");
	}

}
