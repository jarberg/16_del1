public class Die {

    private int faceValue = 0;

    public int getValue(){
        return this.faceValue;
    }

    //
    public void random(){
        this.faceValue = ((int) (Math.random() * 6))+1;
    }

    /* Could be used, not what our initial design looked like.
    public int getRandomValue(){
        random();
        return getValue();
    }
    */


}
