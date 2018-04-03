package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import user.Guest;

public class GuestTest {

	/**
	 * preguntar profeS
	 */
	@Test
	public void testAddOffer() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveOffer() {
		fail("Not yet implemented");
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
