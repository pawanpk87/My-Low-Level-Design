package org.buildcode;

import org.buildcode.controller.MagicalArenaGameController;
import org.buildcode.model.Player;
import org.buildcode.service.FightService;
import org.buildcode.service.MagicalArenaGameService;
import org.buildcode.strategy.IRandomGeneratorStrategy;
import org.buildcode.strategy.IRollDiceStrategy;
import org.buildcode.strategy.RandomNumRandomGeneratorStrategy;
import org.buildcode.strategy.RandomRollDiceStrategy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter details for Player 1:");
        int health1 = getPositiveInput(scanner, "Health");
        int strength1 = getPositiveInput(scanner, "Strength");
        int attack1 = getPositiveInput(scanner, "Attack");

        Player playerA = new Player(health1, strength1, attack1);

        System.out.println("Enter details for Player 2:");
        int health2 = getPositiveInput(scanner, "Health");
        int strength2 = getPositiveInput(scanner, "Strength");
        int attack2 = getPositiveInput(scanner, "Attack");

        Player playerB = new Player(health2, strength2, attack2);

        System.out.println();

        System.out.println("Player 1 details: " + playerA);
        System.out.println("Player 2 details: " + playerB);

        System.out.println();

        scanner.close();

        playMagicArenaGame(playerA, playerB);
    }

    private static void playMagicArenaGame(Player playerA, Player playerB){
        // Create dependencies
        IRandomGeneratorStrategy randomGeneratorStrategy = new RandomNumRandomGeneratorStrategy();
        IRollDiceStrategy rollDiceStrategy = new RandomRollDiceStrategy(randomGeneratorStrategy);
        FightService fightService = new FightService(rollDiceStrategy);
        MagicalArenaGameService magicalArenaGameService = new MagicalArenaGameService(fightService);
        MagicalArenaGameController magicalArenaGame = new MagicalArenaGameController(magicalArenaGameService);

        // Play Game
        magicalArenaGame.play(playerA, playerB);
    }

    private static int getPositiveInput(Scanner scanner, String prompt) {
        int value;
        do {
            System.out.print(prompt + ": ");
            value = scanner.nextInt();
            if (value <= 0) {
                System.out.println(prompt + " must be positive. Please enter again.");
            }
        } while (value <= 0);
        return value;
    }
}