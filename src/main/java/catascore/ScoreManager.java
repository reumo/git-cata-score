package catascore;

public interface ScoreManager {
	
	public String createUser (String user) throws Exception;

	public void setScore (String user, String key, int score);
	
	public int getScore (String user, String key); 
	
	public void printScoreList ();

}
