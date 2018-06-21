package catascore;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import java.util.HashMap;
import java.util.Map;

public class ScoreManagerModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(KeyGenerator.class).to(KeyGeneratorImpl.class);
    }

    @Provides
    public Map<String, User> users(){
        HashMap<String, User> map;
        map = new HashMap<String, User>();
        return map;
    }


}
