package Game;

public class DiceCup {

    private Die die1;
    private Die die2;

    public DiceCup(){ }

    public DiceCup(Die die1, Die die2){
        this.die1 = die1;
        this.die2 = die2;
    }

    public Die getDie1() {
        return die1;
    }

    public Die getDie2() {
        return die2;
    }

    public void shuffle(){
        die1.random();
        die2.random();
    }

    public int getSum(){
        return die1.getValue() + die2.getValue();
    }

    public boolean isMatch(){
        return die1.getValue() == die2.getValue();
    }

    protected void setFirstDie(Die die1) {
        this.die1 = die1;
    }
    protected void setSecondDie(Die die2) {
        this.die2 = die2;
    }
}
