package Game;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DieTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void givenSetMinDiceValue_returnDiceValue(){
        Die dice = new Die();
        dice.setValue(1);
        assertEquals(1, dice.getValue());
    }

    @Test
    void givenSetMaxDiceValue_returnDiceValue(){
        Die dice = new Die();
        dice.setValue(6);
        assertEquals(6, dice.getValue());
    }

    @Test
    void givenSetDiceValueLessOrEqualZero_returnPreviousDiceValue(){
        //arrange
        Die dice = new Die();
        dice.setValue(2);

        //act
        dice.setValue(-1);

        //assert
        assertEquals(2, dice.getValue());
    }

    @Test
    void givenSetDiceValueBiggerThanOrEqualToSeven_returnPreviousDiceValue(){
        //arrange
        Die dice = new Die();
        dice.setValue(2);

        //act
        dice.setValue(7);

        //assert
        assertEquals(2, dice.getValue());
    }
}