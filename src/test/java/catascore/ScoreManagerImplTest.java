package catascore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class ScoreManagerImplTest {
	
	ScoreManagerImpl scoreManager;

	@Before
	public void initialize() {
        Injector injector = Guice.createInjector(new ScoreManagerModule());
        scoreManager = injector.getInstance(ScoreManagerImpl.class);

	}
	
	@Test(expected = Exception.class)
    public void createEmptyUser() throws Exception{
        scoreManager.createUser("");
    }
	
	@Test(expected = Exception.class)
    public void createExistingUser() throws Exception {
        scoreManager.createUser("user1");
        scoreManager.createUser("user1");
    }

    @Test
    public void createUserReturnKey() throws Exception {
	    String key = scoreManager.createUser("user");
	    assertNotNull(key);
    }

    @Test
    public void createUserReturnCorrectKey() throws Exception {
        String key = scoreManager.createUser("user");
        KeyGenerator keyGenerator = scoreManager.getKeyGenerator();
        assertEquals(keyGenerator.getCurrentKey(), key);
    }

    @Test
    public void  generateDistinctKey() throws Exception{
        String firstKey = scoreManager.createUser("user1");
        String secondKey = scoreManager.createUser("user2");
        assertNotEquals(firstKey,secondKey);
    }

    @Test(expected = Exception.class)
    public void setScoreUserNotExist() throws Exception {
	    scoreManager.setScore("user", "aaa", 1);
    }

    @Test(expected = Exception.class)
    public void setScoreIncorrectKey() throws Exception {
	    String key = scoreManager.createUser("user");
        scoreManager.setScore("user", key + "aa", 1);
    }

    @Test
    public void setScoreHighestScore() throws Exception {
	    String userName = "user";
        String key = scoreManager.createUser(userName);
        int firstScore = 1;
        int secondScore = 2;
        scoreManager.setScore("user", key , firstScore);
        scoreManager.setScore("user", key , secondScore);
        HashMap<String, User> users = (HashMap<String, User>) scoreManager.getUsers();
        User user = users.get(userName);
        assertEquals(secondScore,user.getScore());
    }

    @Test
    public void setScoreLowestScore() throws Exception {
        String userName = "user";
        String key = scoreManager.createUser(userName);
        int firstScore = 2;
        int secondScore = 1;
        scoreManager.setScore("user", key , firstScore);
        scoreManager.setScore("user", key , secondScore);
        HashMap<String, User> users = (HashMap<String, User>) scoreManager.getUsers();
        User user = users.get(userName);
        assertNotEquals(secondScore,user.getScore());
    }
    
    @Test
    public void getCorrectScore() throws Exception {
        User user = new User("user");
        HashMap<String, User> users = (HashMap<String, User>) scoreManager.getUsers();
        users.put("user", user);
        user.setKey("A");
        user.setScore(2);
        assertEquals(2, scoreManager.getScore("user", "A"));
    }

    @Test
    public void printOrderedValues() throws Exception {
    	User user1 = new User("user02");
        scoreManager.getUsers().put("user1", user1);
        user1.setKey("A");
        user1.setScore(2);
        User user2 = new User("user01");
        scoreManager.getUsers().put("user2", user2);
        user2.setKey("A");
        user2.setScore(1);
        User user3 = new User("user03");
        scoreManager.getUsers().put("user3", user3);
        user3.setKey("A");
        user3.setScore(3);
        assertEquals("[User{name='user03', score=3}, User{name='user02', score=2}, User{name='user01', score=1}]", scoreManager.printScoreList());
    }

    @Test
    public void printOrderedValuesNotNull() throws Exception {
    	User user1 = new User("user02");
        scoreManager.getUsers().put("user1", user1);
        user1.setKey("A");
        user1.setScore(2);
        assertNotNull(scoreManager.printScoreList());
    }


}
