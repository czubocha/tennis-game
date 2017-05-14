package pl.za.czubocha;

import java.util.Scanner;

/**
 * Created by Tomasz Czubocha on 14.05.2017.
 */
public class Main {

    private static final String prompt = "Please enter the player that wins the point:";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TennisGame tennisGame = new TennisGame();
        System.out.println("Server=1\nReceiver=2\nEnter 0 to exit the program.");
        int i;
        do {
            System.out.println(prompt);
            i = scanner.nextInt();
            switch (i) {
                case 0:
                    System.out.println("Exiting.");
                    break;
                case 1:
                    tennisGame.pointWon(1);
                    System.out.println(tennisGame.getScore());
                    break;
                case 2:
                    tennisGame.pointWon(2);
                    System.out.println(tennisGame.getScore());
                    break;
                default:
                    System.out.println("Bad input.");
                    break;
            }
        } while (i != 0 && !tennisGame.isGameOver());
    }

}
