package catascore;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ScoreController {

    public static void main(String[] args) throws Exception {
        Injector injector = Guice.createInjector(new ScoreManagerModule());
        ScoreManagerImpl scoreManager = injector.getInstance(ScoreManagerImpl.class);

        String userName = scoreManager.createUser("Remo");
        scoreManager.setScore("Remo", "AAAAAA", 123);
        String userName2 = scoreManager.createUser("Flor");
        scoreManager.setScore("Flor", "AAAAAB", 111);

        System.out.println(userName);
        System.out.println(userName2);
        System.out.println(scoreManager.printScoreList());
    }
}
