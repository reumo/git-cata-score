package catascore;

public interface ScoreManager {
	
	public String createUser (String user) throws Exception;

	public void setScore (String userName, String key, int score) throws Exception;
	
	public int getScore (String userName, String key) throws Exception;
	
	public String printScoreList ();

}
