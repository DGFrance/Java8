package com.Javabootcamp.exercise.Advance.BowlingScore.main;

import com.Javabootcamp.exercise.Advance.BowlingScore.Class.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BowlingApp {
    public static void main(String[]args) throws Exception {
        BowlingSystem bowlingSystem = new BowlingSystem();
        List<Player> playerList = new ArrayList<Player>();

        String selection = "";
        String name;

        System.out.println("Please Enter Your Name: ");
        name = new BufferedReader(new InputStreamReader(System.in)).readLine();
        playerList.add(new Player(name));
        /*
         * Processes menu choices
         */
        while (!selection.equals("2")){

            bowlingSystem.welcomeMessage(playerList.get(0).getPlayerName()); // Prints welcome letter
            bowlingSystem.mainMenu(); // Prints menu

            selection = new BufferedReader(new InputStreamReader(System.in)).readLine(); // Gets menu selection number

            switch(Integer.parseInt(selection)) {
                case 1:
                    // Adds new players
                    System.out.println("Please enter the player name");
                    name = new BufferedReader(new InputStreamReader(System.in)).readLine();
                    playerList.add(new Player(name));
                    break;
                case 2:
                    // Prints list of players and starts game
                    bowlingSystem.printPlayerInfo(playerList);
                    break;
                case 3:
                    // Exits game
                    System.out.println("Goodbye.");
                    System.exit(0);
                default:
                    // Error message for invalid selections
                    System.out.println("You have entered an invalid selection. Please try again.");
                    System.out.println("");
            } // end menu switch
        } // end menu loop

        /*
         * The game begins!
         * The final frame is executed separately because of special scoring requirements.
         */
        for (int i=0; i<9; i++) {
            System.out.println("\n>>> Frame " + (i + 1) + " begins now! <<<");
            for (Player player:playerList) {
                bowlingSystem.bowlFrame(player, i);
            }
        }

        // Play final frame
        System.out.println("\n>>> The Final Frame begins now! <<<");
        for (Player player:playerList) {
            bowlingSystem.bowlLastFrame(player, 9);
        }

        /*
         * Prints the final scoreboard
         */
        final ScoreBoard scoreboard = new ScoreBoard();
        scoreboard.printScores(playerList);

    }
}

