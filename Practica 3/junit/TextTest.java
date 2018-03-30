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
		RegisteredUser u = new RegisteredUser("Paco", "Sanchez",1,"Wololo","1234a1234",true,false);
		Text n;
		try {
			n = new Text("Hello im doing things",u);
			assertNotNull(n);
			n.commentComments("They are robots!",u);
			assertTrue(n.getComments().size() == 1);
		} catch (GuestException e) {
			fail("Don't work");
		}
	}
	//No se como hacerlo distinto
	@Test
	public void testCommentComments() {
		RegisteredUser u = new RegisteredUser("Paco", "Sanchez",1,"Wololo","1234a1234",true,false);
		Text n;
		try {
			n = new Text("Hello im doing things",u);
			assertNotNull(n);
			n.commentComments("They are robots!",u);
			assertTrue(n.getComments().size() == 1);
		} catch (GuestException e) {
			fail("Don't work");
		}
	}

	@Test
	public void testRateComment() {
		RegisteredUser u = new RegisteredUser("Paco", "Sanchez",1,"Wololo","1234a1234",true,false);
		Text n;
		try {
			n = new Text("Hello im doing things",u);
			assertNotNull(n);
			n.rateComment(2,u);
			assertTrue(n.getComments().size() == 1);
		} catch (GuestException e) {
			fail("Don't work");
		}
	}

	@Test
	public void testGetGuest() {
		RegisteredUser u = new RegisteredUser("Paco", "Sanchez",1,"Wololo","1234a1234",true,false);
		Text n;
		try {
			n = new Text("Hello im doing things",u);
			assertNotNull(n);
			assertEquals(n.getGuest(),u);
		} catch (GuestException e) {
			fail("Don't work");
		}
	}
	
	@Test
	public void testIsText() {
		RegisteredUser u = new RegisteredUser("Paco", "Sanchez",1,"Wololo","1234a1234",true,false);
		Text n;
		try {
			n = new Text("Hello im doing things",u);
			assertNotNull(n);
			assertTrue(n.isText());
		} catch (GuestException e) {
			fail("Don't work");
		}
	}

}
