package Game;

public class Die {

    private int faceValue = 0;

    public int getValue(){
        return this.faceValue;
    }

    public void random(){
        this.faceValue = ((int) (Math.random() * 6))+1;
    }

}
