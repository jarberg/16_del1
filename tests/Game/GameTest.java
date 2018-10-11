package Game;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void givenGameStart_returnPlayersHaveZeroPoints(){
        //arrange, act
        Game game = setupDiceGame("nameOfPlayer1", "nameOfPlayer2", 0,0);

        //assert

    }

    private Game setupDiceGame(String nameOfPlayer1, String nameOfPlayer2, int die1Value, int die2Value) {
        Game game = new Game();
        Player player1 = new Player(nameOfPlayer1);
        game.setFirstPlayer(player1);
        Player player2 = new Player(nameOfPlayer2);
        game.setSecondPlayer(player2);
        game.setDiceCup(DiceCupTest.setupDiceCup(die1Value, die2Value));
        return game;
    }

}