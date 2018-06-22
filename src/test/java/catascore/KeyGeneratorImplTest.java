package catascore;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class KeyGeneratorImplTest {

    final static int N_CHAR = 6;
    KeyGenerator keyGenerator;

    @Before
    public void initialize(){
        keyGenerator = new KeyGeneratorImpl();
    }

    @Test
    public void generateSixCharacterKey() throws Exception{
        String generatedKey = keyGenerator.generateKey();
        assertEquals(N_CHAR, generatedKey.length());
    }

    @Test
    public void generateUppercaseKey() throws Exception{
        String key = null;
        key = keyGenerator.generateKey();
        assertEquals(key.toUpperCase(),key);
    }

    @Test
    public void  generateDistinctKey() throws Exception{
        String firstKey = keyGenerator.generateKey();
        String secondKey = keyGenerator.generateKey();
        assertNotEquals(firstKey,secondKey);
    }

    @Test
    public void changeNextLetter() throws Exception{
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
        String key;
        do {
            key = keyGenerator.generateKey();
        } while (key != "ZZZZZZ");
        key = keyGenerator.generateKey();
    }
}