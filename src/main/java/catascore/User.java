package catascore;

public class User implements Comparable{

	private String name;
	private String key;
	private int score;
	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int compareTo(Object user) {
		return new Integer(this.score).compareTo(((User)user).score);
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", score=" + score +
				'}';
	}
}
