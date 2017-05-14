package pl.za.czubocha;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by Tomasz Czubocha on 14.05.2017.
 */
public class TennisGameTest {

    TennisGame tennisGame = new TennisGame();

    @Test
    public void whenGameIsCreatedThenScoreIs0() {
        Assertions.assertEquals("0:0", tennisGame.getScore());
    }

    @Test
    public void whenScoreIs00Then150() {
        tennisGame.pointWon(1);
        Assertions.assertEquals("15:0", tennisGame.getScore());
    }

    @Test
    public void whenScoreIs00Then015() {
        tennisGame.pointWon(2);
        Assertions.assertEquals("0:15", tennisGame.getScore());
    }

    @Test
    public void whenScoreIs1515Then3015() {
        tennisGame.pointWon(1);
        tennisGame.pointWon(2);
        tennisGame.pointWon(1);
        Assertions.assertEquals("30:15", tennisGame.getScore());
    }

    @Test
    public void whenScoreIs3030Then3040() {
        tennisGame.pointWon(1);
        tennisGame.pointWon(1);
        tennisGame.pointWon(2);
        tennisGame.pointWon(2);
        tennisGame.pointWon(2);
        Assertions.assertEquals("30:40", tennisGame.getScore());
    }

    @Test
    public void whenScoreIs4030AndPlayer1WinsPointPlayer1Wins() {
        tennisGame.pointWon(1);
        tennisGame.pointWon(1);
        tennisGame.pointWon(1);
        tennisGame.pointWon(2);
        tennisGame.pointWon(2);
        tennisGame.pointWon(1);
        Assertions.assertEquals("And the winner is... Server!", tennisGame.getScore());
    }

    @Test
    public void whenScoreIs3030AndPlayer1WinsPointThen4030() {
        tennisGame.pointWon(1);
        tennisGame.pointWon(1);
        tennisGame.pointWon(2);
        tennisGame.pointWon(2);
        tennisGame.pointWon(1);
        Assertions.assertEquals("40:30", tennisGame.getScore());
    }

    @Test
    public void whenScoreIs040AndPlayer2WinsPointPlayer2WinsGame() {
        tennisGame.pointWon(2);
        tennisGame.pointWon(2);
        tennisGame.pointWon(2);
        tennisGame.pointWon(2);
        Assertions.assertEquals("And the winner is... Receiver!", tennisGame.getScore());
    }

    @Test
    public void whenScoreIs4040AndPlayer2WinsPointThen40A() {
        tennisGame.pointWon(1);
        tennisGame.pointWon(1);
        tennisGame.pointWon(1);
        tennisGame.pointWon(2);
        tennisGame.pointWon(2);
        tennisGame.pointWon(2);
        tennisGame.pointWon(2);
        Assertions.assertEquals("40:A", tennisGame.getScore());
    }

    @Test
    public void whenScoreIs4040AndPlayer1WinsPointThenPlayer1WinsGame() {
        tennisGame.pointWon(1);
        tennisGame.pointWon(1);
        tennisGame.pointWon(1);
        tennisGame.pointWon(2);
        tennisGame.pointWon(2);
        tennisGame.pointWon(2);
        tennisGame.pointWon(1);
        Assertions.assertEquals("A:40", tennisGame.getScore());
    }

    @Test
    public void whenScoreIs40AAndPlayer2WinsPointPlayer2WinsGame() {
        tennisGame.pointWon(1);
        tennisGame.pointWon(1);
        tennisGame.pointWon(1);
        tennisGame.pointWon(2);
        tennisGame.pointWon(2);
        tennisGame.pointWon(2);
        tennisGame.pointWon(2);
        tennisGame.pointWon(2);
        Assertions.assertEquals("And the winner is... Receiver!", tennisGame.getScore());
    }

    @Test
    public void whenScoreIsA40AndPlayer2WinsPointThen4040() {
        tennisGame.pointWon(1);
        tennisGame.pointWon(1);
        tennisGame.pointWon(1);
        tennisGame.pointWon(2);
        tennisGame.pointWon(2);
        tennisGame.pointWon(2);
        tennisGame.pointWon(1);
        tennisGame.pointWon(2);
        Assertions.assertEquals("40:40", tennisGame.getScore());
    }

}