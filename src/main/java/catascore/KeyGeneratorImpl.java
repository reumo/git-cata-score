package catascore;


public class KeyGeneratorImpl  implements KeyGenerator{

    private boolean first = true;
    private StringBuffer key = new StringBuffer("AAAAAA");
    private int currentPos = key.length() - 1;

    /**
     * Generate unique key
     */
    public String generateKey() throws Exception{

            if (!this.first) {
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
            this.first = false;
            return this.key.toString();
    }

    public String getCurrentKey(){
        return  key.toString();
    }
}
