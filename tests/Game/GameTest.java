package Game;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void givenPlayer1RollsTwoEqual_returnGetsExtraTurn(){
        //arrange, act
        Game game = setupDiceGame("nameOfPlayer1", "nameOfPlayer2", 2,2);

        ByteArrayInputStream in = new ByteArrayInputStream("\n\n".getBytes());
        System.setIn(in);
        Scanner input = game.setScanner( new Scanner(System.in) );
        //act
        game.playTurn();

        //assert
        assertEquals(4, game.getFirstPlayerPoints());
    }

    @Test
    void givenGameStart_returnThereIsNoWinner(){
        //arrange, act
        Game game = setupDiceGame("nameOfPlayer1", "nameOfPlayer2", 0,0);

        //assert
        assertEquals(false, game.hasWinner());
    }

    @Test
    void givenGameStart_returnPlayersHaveZeroPoints(){
        //arrange, act
        Game game = setupDiceGame("nameOfPlayer1", "nameOfPlayer2", 0,0);

        //assert
        assertEquals(0, game.getFirstPlayerPoints());
        assertEquals(0, game.getSecondPlayerPoints());
    }

    private Game setupDiceGame(String nameOfPlayer1, String nameOfPlayer2, int die1Value, int die2Value) {
        Game game = new Game();
        Player player1 = new Player(nameOfPlayer1);
        game.setFirstPlayer(player1);
        Player player2 = new Player(nameOfPlayer2);
        game.setSecondPlayer(player2);
        game.setDiceCup(DiceCupTest.setupFakeDiceCup(die1Value, die2Value));
        return game;
    }

}