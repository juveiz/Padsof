package junit;

import static org.junit.Assert.*;
import offer.House;

import org.junit.Test;

public class HouseTest {

	@Test
	public void testHouse() {
		assertNotNull(new House("Madrid", 28903, "Avenida de la Felicidad nº 23.\n Very wide\nPool"));
	}

	@Test
	public void testGetCity() {
		House h = new House("Madrid", 28903, "Avenida de la Felicidad nº 23.\n Very wide\nPool");
		assertEquals("Madrid", h.getCity());
	}

	@Test
	public void testSetCity() {
		House h = new House("Madrid", 28903, "Avenida de la Felicidad nº 23.\n Very wide\nPool");
		h.setCity("Leganes");
		assertEquals("Leganes", h.getCity());
	}

	@Test
	public void testGetZip() {
		House h = new House("Madrid", 28903, "Avenida de la Felicidad nº 23.\n Very wide\nPool");
		assertTrue(28903 == h.getZip());
	}

	@Test
	public void testSetZip() {
		House h = new House("Madrid", 28903, "Avenida de la Felicidad nº 23.\n Very wide\nPool");
		h.setZip(23456);
		assertTrue(23456 == h.getZip());
	}

	@Test
	public void testGetDescription() {
		House h = new House("Madrid", 28903, "Avenida de la Felicidad nº 23.\n Very wide\nPool");
		assertEquals("Avenida de la Felicidad nº 23.\n Very wide\nPool", h.getDescription());
	}

	@Test
	public void testSetDescription() {
		House h = new House("Madrid", 28903, "Avenida de la Felicidad nº 23.\n Very wide\nPool");
		h.setDescription("Calle chile.\nVery long");
		assertEquals("Calle chile.\nVery long", h.getDescription());
	}

}
