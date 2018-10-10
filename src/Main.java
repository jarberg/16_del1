import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter player name:");
        Player player1 = new Player(scanner.nextLine());
        System.out.println("Enter player name:");
        Player player2 = new Player(scanner.nextLine());

        Die die1 = new Die();
        Die die2 = new Die();

        DiceCup cup = new DiceCup(die1,die2);

        Game game = new Game(player1,player2,cup);
        game.playTurns(player1,player2);




    }
}
