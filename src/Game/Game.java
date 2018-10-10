package Game;

public class Game {

    private Player player1;
    private Player player2;
    private DiceCup cup;


    public Game(Player player1, Player player2, DiceCup cup){
        this.player1 = player1;
        this.player2 = player2;
        this.cup = cup;
    }

    public void playTurns(Player player1, Player player2){

        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(this.player1.getName() + " has " + this.player1.getPoints() + " points.");
        System.out.println(this.player2.getName() + " has " + this.player2.getPoints() + " points.");

        System.out.println(player1.getName() + "'s turn.");
        cup.shuffle();

        try {
            Thread.sleep(750);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(cup.isMatch() && player1.getPoints() >= 40){
            System.out.println(player1.getName() + " wins!");
            return;
        }

        System.out.println("You got: " + cup.getDie1().getValue() + " and " + cup.getDie2().getValue());
        player1.addToPoints(cup.getSum());

        try {
            Thread.sleep(750);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(cup.getSum()==2){
            System.out.println("Oh no, you lost all your points.");
        }

        if(cup.getSum()==12) {
            if (player1.getLastTurnPairSix()) {
                System.out.println(player1.getName() + " wins!");
                return;
            } else
                player1.setLastTurnPairSix(true);
        }
        else{
            player1.setLastTurnPairSix(false);
        }

        if(cup.isMatch()){
            System.out.println("Bonus turn!");
        }

        try {
            Thread.sleep(750);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean bonusTurn = cup.isMatch();

        if(bonusTurn){
            playTurns(player1,player2);
        }
        else{
            playTurns(player2,player1);
        }

    }




}
