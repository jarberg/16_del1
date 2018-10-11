package Game;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceCupTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void givenDieValueEqualOneAndDieValueEqualTwo_returnSumIsThree(){
        //arrange, act
        DiceCup diceCup = setupDiceCup(1, 2);

        //assert
        assertEquals(3, diceCup.getSum());
    }

    @Test
    void givenEqualDice_returnIsAMatch(){
        //arrange, act
        DiceCup diceCup = setupDiceCup(2, 2);

        //assert
        assertEquals(true, diceCup.isMatch());
    }

    @Test
    void givenDifferentDice_returnIsNotAMatch(){
        //arrange, act
        DiceCup diceCup = setupDiceCup(1, 2);

        //assert
        assertEquals(false, diceCup.isMatch());
    }

    private DiceCup setupDiceCup(int die1Value, int die2Value) {
        DiceCup diceCup = new DiceCup();
        Die die1 = new Die();
        die1.setValue(die1Value);
        Die die2 = new Die();
        die2.setValue(die2Value);
        diceCup.setFirstDie(die1);
        diceCup.setSecondDie(die2);
        return diceCup;
    }
}