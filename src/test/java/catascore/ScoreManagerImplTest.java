package catascore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class ScoreManagerImplTest {
	
	ScoreManagerImpl scoreManager;

	@Before
	public void initialize() {
	    scoreManager = new ScoreManagerImpl();
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
}
