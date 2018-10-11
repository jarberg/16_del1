package Game;

import java.util.Scanner;

public class Game {

    private Player thisPlayer;
    private Player nextPlayer;
    private DiceCup cup;
    private boolean bonusTurn = false;
    private boolean pairOne = false;
    private boolean winnerFound = false;
    private Scanner scanner = new Scanner(System.in);

    public Game(){}
    public Game(Player player1, Player player2, DiceCup cup){
        this.thisPlayer = player1;
        this.nextPlayer = player2;
        this.cup = cup;
    }
    protected void setFirstPlayer(Player player1) {
        this.thisPlayer = player1;
    }
    protected void setSecondPlayer(Player player2) {
        this.nextPlayer = player2;
    }
    protected void setDiceCup(DiceCup diceCup) {
        this.cup = diceCup;
    }

    public void playTurns(Player thisPlayer, Player nextPlayer){

        System.out.println(thisPlayer.getName() + "'s turn. Press enter to roll!");
        scanner.nextLine();

        cup.shuffle();
        checkBonus();
        result(cup, thisPlayer);
        scanner.nextLine();

        if(this.winnerFound)
            return;

        this.pairOne = false;

        if(bonusTurn){
            this.bonusTurn = false;
            playTurns(thisPlayer,nextPlayer);
        }
        else{
            playTurns(nextPlayer,thisPlayer);
        }
    }

    private void result(DiceCup cup, Player player){

        System.out.print(player.getName());
        System.out.print(" rolled ");
        System.out.print(cup.getDie1().getValue());
        System.out.print(" and ");
        System.out.print(cup.getDie2().getValue());
        if(pairOne){
            System.out.println(". You rolled two ones... you lose all your points.");
        }
        else {
            System.out.print(". You have earned ");
            System.out.print(cup.getSum());
            System.out.print(" points! ");
            player.addToPoints(cup.getSum());
        }
        System.out.print("Now you have ");
        System.out.print(player.getPoints() + " ");
        if(!bonusTurn&&!winnerFound)
            System.out.println(". Press enter to end turn!");
        if(winnerFound) {
            System.out.println(player.getName() + " won the game!");
        }
        else if(bonusTurn)
            System.out.println("You rolled two of a kind, so you get a bonus turn!");
    }

    private void checkBonus(){
        if(cup.getSum()==2){
            this.pairOne = true;
            thisPlayer.setPoints(0);
        }

        if(cup.isMatch() && thisPlayer.getPoints() >= 40)
            this.winnerFound = true;

        if(cup.getSum()==12) {
            if (thisPlayer.getLastTurnPairSix()) {
                this.winnerFound = true;
            } else
                thisPlayer.setLastTurnPairSix(true);
        }else
            thisPlayer.setLastTurnPairSix(false);

        if(cup.isMatch())
            this.bonusTurn = true;
    }


}
