package catascore;

import static org.junit.Assert.assertFalse;
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
	
	@Test
	public void TwoDifferentNameUsersEqualsFalse() throws Exception {
		User user1 = new User("user1");
		User user2 = new User("user2");
		assertFalse(user1.equals(user2));
	}
	@Test
	public void TwoSameNameUsersEqualsTrue() throws Exception {
		User user1 = new User("user1");
		User user2 = new User("user1");
		assert(user1.equals(user2));
	}
	
	@Test
	public void TwoSameNameUserHaveSameHash() throws Exception {
		User user1 = new User("user1");
		User user2 = new User("user1");
		assert(user1.hashCode() == user2.hashCode());
	}
	
	@Test
	public void TwoDifferentNameUserHaveDifferentHash() throws Exception {
		User user1 = new User("user1");
		User user2 = new User("user2");
		assertFalse(user1.hashCode() == user2.hashCode());
	}
	
}
