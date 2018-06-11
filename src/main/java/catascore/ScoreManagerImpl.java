package catascore;

import java.util.HashSet;
import java.util.Set;

public class ScoreManagerImpl implements ScoreManager{
	
	Set<User> users;
	
	public ScoreManagerImpl() {
		users = new HashSet<User>();
	}

	public String createUser(String user) throws Exception {
		if (user.isEmpty()) {
			throw new Exception();
		}		
		if (users.contains(new User(user))) {
			throw new Exception();
		}
		return null;
	}

	public void setScore(String user, String key, int score) {
		// TODO Auto-generated method stub
		
	}

	public int getScore(String user, String key) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void printScoreList() {
		// TODO Auto-generated method stub
		
	}
	

}
