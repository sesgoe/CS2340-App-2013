package edu.gatech.wheresmystuff.tests;

import edu.gatech.wheresmystuff.model.InMemoryModel;
import edu.gatech.wheresmystuff.model.User;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests the getAllItemsMatching() method.
 * 
 * @author Amy Domanico
 *
 */
public class AmyTest {

	@Test
	public void testUserClass() {
		//fail("Not yet implemented");
		User user = new User();
		user.setUsername("aldomanico");
	}
	
	@Test
	public void testModelClass() {
		User user = new User();
		user.setUsername("aldomanico");
		InMemoryModel model = new InMemoryModel();
		model.addPerson(user);
		assertTrue(model.findPersonById("aldomanico").equals(user));
	}

}
