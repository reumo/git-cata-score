package catascore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ScoreManagerImplTest {
	
	ScoreManagerImpl scoreManager;
    Map<String, User> users;

	@Before
	public void initialize() {
	    users = new HashMap<String, User>();
	    scoreManager = new ScoreManagerImpl(users);
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

    @Test
    public void setScoreHighestScore() throws Exception {
	    String userName = "user";
        String key = scoreManager.createUser(userName);
        int firstScore = 1;
        int secondScore = 2;
        scoreManager.setScore("user", key , firstScore);
        scoreManager.setScore("user", key , secondScore);
        assertEquals(secondScore,users.get(userName).getScore());
    }

    @Test
    public void setScoreLowestScore() throws Exception {
        String userName = "user";
        String key = scoreManager.createUser(userName);
        int firstScore = 2;
        int secondScore = 1;
        scoreManager.setScore("user", key , firstScore);
        scoreManager.setScore("user", key , secondScore);
        assertNotEquals(secondScore,users.get(userName).getScore());
    }
//TODO: Desacoplate from setScore
    @Test
    public void getCorrectScore() throws Exception {
        String userName = "user";
        String key = scoreManager.createUser(userName);
        int score = 2;
        scoreManager.setScore(userName, key , score);
        assertEquals(score,users.get(userName).getScore());
    }

    //TODO: Desacoplate from setScore...
    @Test
    public void printOrderedValues() throws Exception {
        String key = scoreManager.createUser("user01");
        scoreManager.setScore("user01", key , 1);
        key = scoreManager.createUser("user03");
        scoreManager.setScore("user03", key , 3);
        key = scoreManager.createUser("user02");
        scoreManager.setScore("user02", key , 2);
        assertEquals("[User{name='user03', score=3}, User{name='user02', score=2}, User{name='user01', score=1}]", scoreManager.printScoreList());
    }

    //TODO: Desacoplate from setScore...
    @Test
    public void printOrderedValuesNotNull() throws Exception {
        String key = scoreManager.createUser("user01");
        scoreManager.setScore("user01", key , 1);
        key = scoreManager.createUser("user03");
        assertNotNull(scoreManager.printScoreList());
    }


}
