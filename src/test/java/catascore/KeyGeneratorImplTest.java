package catascore;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class KeyGeneratorImplTest {

    final static int N_CHAR = 6;

    @Test
    public void generateSixCharacterKey() {
        KeyGenerator keyGenerator = new KeyGeneratorImpl();
        assertEquals(N_CHAR, keyGenerator.generateKey().length());
    }

    @Test
    public void generateUppercaseKey() {
        KeyGenerator keyGenerator = new KeyGeneratorImpl();
        String key = keyGenerator.generateKey();
        assertEquals(key.toUpperCase(),key);
    }

    @Test
    public void  generateUniqueKey() {
        KeyGenerator keyGenerator = new KeyGeneratorImpl();
        assertNotEquals(keyGenerator.generateKey(),keyGenerator.generateKey());
    }
}