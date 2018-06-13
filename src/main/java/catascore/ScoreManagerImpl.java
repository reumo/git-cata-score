package catascore;

import java.util.*;

public class ScoreManagerImpl implements ScoreManager{

	Map<String, User> users;
	KeyGenerator keyGenerator;
	
	public ScoreManagerImpl(Map<String, User> users, KeyGenerator keyGenerator) {
		this.keyGenerator = keyGenerator;
		this.users = users;
	}


	public String createUser(String userName) throws Exception {
		if (userName.isEmpty()) {
			throw new Exception("no empty user");
		}
		User user = new User(userName);
		if (users.containsKey(userName)) {
			throw new Exception("duplicated user");
		}
		user.setKey(keyGenerator.generateKey());
		users.put(userName,user);
		return user.getKey();
	}

	public void setScore(String userName, String key, int score) throws Exception{
		if(!users.containsKey(userName)){
			throw new Exception("user not exist");
		}
		User user = users.get(userName);
		if (!user.getKey().equals(key)){
			throw new Exception("Key is not correct");
		}
		if(user.getScore() < score){
			user.setScore(score);
		}
	}

	public int getScore(String userName, String key) throws Exception{
		if(!users.containsKey(userName)){
			throw new Exception("user not exist");
		}
		User user = users.get(userName);
		if (!user.getKey().equals(key)){
			throw new Exception("Key is not correct");
		}
		return user.getScore();
	}

	public String printScoreList() {
		List<User> usersOrdered = new ArrayList<User>(users.values());
		Collections.sort(usersOrdered, Collections.reverseOrder());
		return Arrays.toString(usersOrdered.toArray());
	}

}
