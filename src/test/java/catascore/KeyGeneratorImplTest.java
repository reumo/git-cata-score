package catascore;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class KeyGeneratorImplTest {

    final static int N_CHAR = 6;

    @Test
    public void generateSixCharacterKey() throws Exception{
        KeyGenerator keyGenerator = new KeyGeneratorImpl();
        assertEquals(N_CHAR, keyGenerator.generateKey().length());
    }

    @Test
    public void generateUppercaseKey() throws Exception{
        KeyGenerator keyGenerator = new KeyGeneratorImpl();
        String key = null;
        key = keyGenerator.generateKey();
        assertEquals(key.toUpperCase(),key);
    }

    @Test
    public void  generateUniqueKey() throws Exception{
        KeyGenerator keyGenerator = new KeyGeneratorImpl();
        assertNotEquals(keyGenerator.generateKey(),keyGenerator.generateKey());
    }

    @Test
    public void changeNextLetter() throws Exception{
        KeyGenerator keyGenerator = new KeyGeneratorImpl();
            String key;
        do{
                key = keyGenerator.generateKey();
        }while (key.charAt(key.length() -1) != 'Z');

        key = keyGenerator.generateKey();
        assertEquals('A', key.charAt(key.length() -1));
        assertEquals('B', key.charAt(key.length() -2));
    }

    @Test(expected = NotKeyAvailableException.class)
    public void getAfterLastKey() throws Exception {
            KeyGenerator keyGenerator = new KeyGeneratorImpl();
        String key;
            do {
                key = keyGenerator.generateKey();
            } while (key != "ZZZZZZ");
        key = keyGenerator.generateKey();
    }
}