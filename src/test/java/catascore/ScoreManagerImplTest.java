package catascore;

import static org.junit.Assert.assertEquals;

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
    public void createExistingUser() throws Exception{
        scoreManager.createUser("user1");
        scoreManager.createUser("user1");
    }
}
