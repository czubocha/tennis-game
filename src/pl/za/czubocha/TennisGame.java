package pl.za.czubocha;

/**
 * Created by Tomasz Czubocha on 14.05.2017.
 */

public class TennisGame {
    private final Player firstPlayer;
    private final Player secondPlayer;
    private String winner;

    public TennisGame() {
        firstPlayer = new Player("Server");
        secondPlayer = new Player("Receiver");
        winner = "";
    }

    public String getScore() {
        if (isGameOver())
            return sayWhoIsWinner();
        return getFirstPlayer().getScore() + ":" + getSecondPlayer().getScore();
    }

    public int pointWon(int i) {
        if (i != 1 && i != 2)
            return -1;
        else if (isGameOver())
            return 0;
        else if (i == 1 && isGameOn(getFirstPlayer(), getSecondPlayer())) {
            pointWon(getFirstPlayer(), getSecondPlayer());
            return 1;
        } else if (i == 2 && isGameOn(getSecondPlayer(), getFirstPlayer())) {
            pointWon(getSecondPlayer(), getFirstPlayer());
            return 2;
        } else
            return -2;
    }

    public boolean isGameOver() {
        return !getWinner().equals("");
    }

    private Player getFirstPlayer() {
        return firstPlayer;
    }

    private Player getSecondPlayer() {
        return secondPlayer;
    }

    private String getWinner() {
        return winner;
    }

    private void setWinner(String winner) {
        this.winner = winner;
    }

    private boolean isGameOn(Player playerGotPoint, Player otherPlayer) {
        String firstScore = playerGotPoint.getScore();
        String secondScore = otherPlayer.getScore();
        if (firstScore.equals("A") || firstScore.equals("40") && !secondScore.equals("40") && !secondScore.equals("A")) {
            setWinner(playerGotPoint.getName());
            return false;
        }
        return true;
    }

    private String sayWhoIsWinner() {
        return "And the winner is... " + getWinner() + "!";
    }


    private void pointWon(Player playerGotPoint, Player otherPlayer) {
        String increasedScore = playerGotPoint.getScore();
        switch (increasedScore) {
            case "0":
                playerGotPoint.setScore("15");
                return;
            case "15":
                playerGotPoint.setScore("30");
                return;
            case "30":
                playerGotPoint.setScore("40");
                return;
        }
        if (otherPlayer.getScore().equals("40"))
            playerGotPoint.setScore("A");
        else
            otherPlayer.setScore("40");
    }

    private class Player {
        private final String name;
        private String score;

        private Player() {
            score = "0";
            name = "";
        }

        private Player(String name) {
            this.score = "0";
            this.name = name;
        }

        private String getScore() {
            return score;
        }

        private void setScore(String score) {
            this.score = score;
        }

        private String getName() {
            return name;
        }
    }
}
