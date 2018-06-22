package catascore;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import java.util.HashMap;
import java.util.Map;

/**
 * Creamos una nueva clase java que hereda de AbstractModule (clase perteneciente a la librería com.google.inject.*)
 * La c
 */
public class ScoreManagerModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(KeyGenerator.class).to(KeyGeneratorImpl.class);

        /**
         * Se puede generar el enlace mediante toInstance, este método es obligatorio
         * cuando la instancia del objeto a generar tiene parámetros de entrada.
         *
         * bind(KeyGenerator.class).toInstance(new KeyGeneratorImpl());
         *
         */

    }

    @Provides
    public Map<String, User> users(){
        HashMap<String, User> map;
        map = new HashMap<String, User>();
        return map;
    }


}
