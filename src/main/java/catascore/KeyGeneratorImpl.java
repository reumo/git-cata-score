package catascore;


public class KeyGeneratorImpl  implements KeyGenerator{

    private int first = 0;
    private StringBuffer key = new StringBuffer("AAAAAA");
    private int currentPos = key.length() - 1;

    public String generateKey() throws Exception{

            if (this.first != 0) {
                if (this.key.charAt(this.currentPos) == 'Z') {
                    this.key.setCharAt(this.currentPos, 'A');
                    this.currentPos--;
                }
                if(this.currentPos == -1){
                    throw new NotKeyAvailableException("Key not available");
                }
                char character = key.charAt(this.currentPos);
                this.key.setCharAt(this.currentPos, ++character);
            }
            this.first = 1;
            return this.key.toString();
    }
}
