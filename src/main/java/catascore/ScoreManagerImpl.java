package catascore;

import java.util.HashSet;
import java.util.Set;

public class ScoreManagerImpl implements ScoreManager{

	Set<User> users;
	KeyGenerator keyGenerator;
	
	public ScoreManagerImpl() {
		keyGenerator = new KeyGeneratorImpl();
		users = new HashSet<User>();
	}

	public String createUser(String userName) throws Exception {
		if (userName.isEmpty()) {
			throw new Exception("no empty user");
		}
		User user = new User(userName);
		if (!users.add(user)) {
			throw new Exception("duplicated user");
		}
		user.setKey(keyGenerator.generateKey());
		return user.getKey();
	}

	public void setScore(String userName, String key, int score) throws Exception{
		if(!users.contains(new User(userName))){
			throw new Exception("user not exist");
		}
		
	}

	public int getScore(String userName, String key) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void printScoreList() {
		// TODO Auto-generated method stub
		
	}
	

}
