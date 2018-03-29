package junit;

import static org.junit.Assert.*;
import comments.*;

import org.junit.Test;

import Exception.GuestException;
import User.RegisteredUser;

public class TextTest {

	@Test
	public void testText() {
		RegisteredUser u = new RegisteredUser("Paco", "Sanchez",1,"Wololo","1234a1234",true,false);
		Text n;
		try {
			n = new Text("Hello im doing things",u);
			assertNotNull(n);
		} catch (GuestException e) {
			fail("Don't work");
		}
		u = new RegisteredUser("Paco", "Sanchez",1,"Wololo","1234a1234",false,false);
		try {
			n = new Text("Hello im doing things",u);
			fail("Don't work");
		} catch (GuestException e) {
			assertNotNull(e);
		}
	}

	@Test
	public void testGetText() {
		RegisteredUser u = new RegisteredUser("Paco", "Sanchez",1,"Wololo","1234a1234",true,false);
		Text n;
		try {
			n = new Text("Hello im doing things",u);
			assertNotNull(n);
			assertEquals("Hello im doing things",n.getText());
		} catch (GuestException e) {
			fail("Don't work");
		}
	}

	@Test
	public void testGetComments() {
		fail("Not yet implemented");
	}

	@Test
	public void testCommentComments() {
		fail("Not yet implemented");
	}

	@Test
	public void testRateComment() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetComments() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetGuest() {
		fail("Not yet implemented");
	}

}
