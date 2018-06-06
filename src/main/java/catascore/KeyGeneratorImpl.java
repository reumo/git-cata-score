package catascore;

public class KeyGeneratorImpl implements KeyGenerator {

    private int first = 0;
    private StringBuffer key = new StringBuffer("AAAAAA");
    private int currentPos = key.length() - 1;

    @Override
    public String generateKey() {
        if( this.first != 0){
            if(this.key.charAt(this.currentPos) == 'Z'){
                this.key.setCharAt( this.currentPos, 'A');
                this.currentPos--;
            }
            char character = key.charAt(this.currentPos);
            this.key.setCharAt(this.currentPos , character++);
        }
        this.first = 1;
        return this.key.toString();
    }
}
