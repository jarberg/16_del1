public class DiceCup {

    private Die die1;
    private Die die2;

    DiceCup(Die die1, Die die2){
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

    int getSum(){
        return die1.getValue() + die2.getValue();
    }

    boolean isMatch(){
        return die1.getValue() == die2.getValue();
    }




}
