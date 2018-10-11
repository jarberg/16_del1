package Game;

public class Die {

    //start with dummy value within the range 1 to 6
    private int faceValue = 0;

    public int getValue(){
        return this.faceValue;
    }

    //
    public void random(){
        this.faceValue = ((int) (Math.random() * 6))+1;
    }

    protected void setValue(int faceValue) {
        if( faceValue >= 1 && faceValue <= 6 )
            this.faceValue = faceValue;
    }

    /* Could be used, not what our initial design looked like.
    public int getRandomValue(){
        random();
        return getValue();
    }
    */


}
