package catascore;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class UserImplTest {

	User user;

	@Before
	public void inizializateUser() {
		user = new User("Remo");
	}

	@Test
	public void createUserTest() throws Exception {
		assertNotNull(user);
	}
	
	@Test
	public void nameNotNullTest() throws Exception {
		assertNotNull(user.getName());
	}
	
	@Test
	public void keyNotNullTest() throws Exception {
		user.setKey("BBBBBB");
		assertNotNull(user.getKey());
	}
	
	@Test
	public void scoreNotNullTest() throws Exception {
		user.setScore(100);
		assertNotNull(user.getScore());
	}
}
