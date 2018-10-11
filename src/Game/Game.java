package Game;

import java.util.Scanner;

public class Game {

    private Scanner scanner = new Scanner(System.in);
    private Player thisPlayer;
    private Player nextPlayer;
    private DiceCup cup;
    private boolean bonusTurn = false;
    private boolean pairOne = false;
    private boolean winnerFound = false;

    public Game(Player player1, Player player2, DiceCup cup){
        this.thisPlayer = player1;
        this.nextPlayer = player2;
        this.cup = cup;
    }

    public boolean hasWinner(){
        return this.winnerFound;
    }

    public void playTurn(){
        bonusTurn = false;
        pairOne = false;

        System.out.println(thisPlayer.getName() + "'s turn. Press enter to roll!");
        scanner.nextLine();

        cup.shuffle();
        checkBonus();
        printResult();
        scanner.nextLine();

        if(!bonusTurn){
            Player middleMan = nextPlayer;
            this.nextPlayer = thisPlayer;
            this.thisPlayer = middleMan;
        }
    }

    private void printResult(){
        System.out.println(thisPlayer.getName()+" rolled "+cup.getDie1().getValue()+" and "+cup.getDie2().getValue()+". ");

        if(pairOne){
            thisPlayer.setPoints(0);
            System.out.println(" You rolled two ones... you lose all your points. ");
        }
        else {
            thisPlayer.addToPoints(cup.getSum());
            System.out.print(" You have earned ");
            System.out.print(cup.getSum());
            System.out.print(" points! ");
        }

        System.out.print("Now you have " + thisPlayer.getPoints() + ". ");

        if(!bonusTurn&&!winnerFound)
            System.out.println("Press enter to end turn!");

        if(winnerFound)
            System.out.println(thisPlayer.getName() + " won the game!");
        else if(bonusTurn)
            System.out.println(". You rolled two of a kind, so you get a bonus turn!");
    }

    private void checkBonus(){
        if(cup.getSum()==2)
            pairOne = true;

        if(cup.isMatch() && thisPlayer.getPoints() >= 40)
            winnerFound = true;

        if(cup.getSum()==12) {
            if (thisPlayer.getLastTurnPairSix()) {
                winnerFound = true;
            } else
                thisPlayer.setLastTurnPairSix(true);
        }
        else{
            thisPlayer.setLastTurnPairSix(false);
        }

        if(cup.isMatch())
            this.bonusTurn = true;
    }



}