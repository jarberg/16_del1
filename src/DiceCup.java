

public class DiceCup {

    private Die die1;
    private Die die2;
    private int[] valueSet = new int[2];

    DiceCup(Die die1, Die die2){
        this.die1 = die1;
        this.die2 = die2;
    }

    public int[] getRandomValues(){
        die1.random();
        die2.random();
        this.valueSet[0]=die1.getValue();
        this.valueSet[1]=die2.getValue();
        return valueSet;
    }

    public int getSum(){
        return valueSet[0]+valueSet[1];
    }

    public boolean isMatch(){
        return (valueSet[0]==valueSet[1]);
    }


}
