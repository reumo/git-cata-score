package catascore;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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

	@Test
	public void compareEqualsScore(){
		user.setScore(10);
		User newUser = new User("user02");
		newUser.setScore(10);
		assertEquals(0, user.compareTo(newUser));
	}

	@Test
	public void compareHighestScore(){
		user.setScore(10);
		User newUser = new User("user02");
		newUser.setScore(20);
		assertEquals(-1, user.compareTo(newUser));
	}

	@Test
	public void compareLowestScore(){
		user.setScore(20);
		User newUser = new User("user02");
		newUser.setScore(10);
		assertEquals(1, user.compareTo(newUser));
	}
	
}
