package com.Javabootcamp.exercise.Advance.BowlingScore.main;

import com.Javabootcamp.exercise.Advance.BowlingScore.Class.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class BowlingSystem {


    public void welcomeMessage(String player) {
        System.out.println(String.format("Welcome to BowlMania, %s!\nPlease choose one of the options below", player));
    }

    public void mainMenu() {
        System.out.println("1. Enter a player name\n2. Begin bowling\n3. Quit");
        System.out.println("Enter a number between 1-3:");
    }

    public void printPlayerInfo(List<Player> playerList) {
        System.out.println("There are " + playerList.size() + "player(s) in the game.");
        System.out.println("The Players are : ");

        //Old method
//        for (Player player : playerList) {
//            System.out.println(player.getPlayerName());
//        }

        //new method (Java 8)
        playerList.forEach(player -> System.out.println(player.getPlayerName()));


    }

    /*
     * The system for bowling frames 1-9
     *
     * Bonus points are calculated using bonusCounter. BonusCounter is incremented by 2 for every strike
     * and 1 for every spare. It is decremented by 1 for each bonus score added. If there are two bonus
     * scores added (e.g. the two previous balls were strikes) then the bonus score is decremented by 2.
     */
    public void bowlFrame(Player player, int frame) throws IOException {
        int totalScore = 0;
        int bonusCounter = player.checkBonusCounter();
        System.out.println(player.getPlayerName());

        //Bowls First Round
        System.out.println("Enter your score for ball 1 : ");
        int score = getScore(totalScore);
        totalScore = totalScore + score;
        player.setFirstBall(frame, score);

        //update player Score
        if (bonusCounter == 1 | bonusCounter == 2) {
            player.setPlayerScore(score + score);
            bonusCounter -= 1;
        }
        if (bonusCounter == 3) {
            player.setPlayerScore(score + score + score);
            bonusCounter -= 2;

        } else {
            player.setPlayerScore(score);
        }

        if (totalScore == 10) { //checks for Strike
            player.setSecondBall(frame, score);
            System.out.println("Strike");

        } else {
            System.out.println("Enter your score for ball2"); // Gets score for ball 2 if there was no strike
            score = getScore(totalScore);
            player.setSecondBall(frame, score);
            if (bonusCounter == 1) {
                player.setPlayerScore(score + score);
                bonusCounter -= 1;
            } else {
                player.setPlayerScore(score);
            }
            totalScore = score + score;
            if (totalScore == 10) { //check for spare
                System.out.println("Spare");
            }
        }
        if ((player.checkFirstBall(frame)) == 10) {
            bonusCounter += 2;

        } else if (totalScore == 10) {
            bonusCounter += 1;
        }
        player.setBonusCounter(bonusCounter);
        System.out.println(player.getPlayerName() + "'s Platyer total score is " + player.chcekPlayerScore());
    }// end bowlFrame Method


    /*
     * Special system for scoring the last frame.
     * Includes bonus ball if the player got a strike or spare.
     */
    public void bowlLastFrame(Player player, int frame) throws Exception {
        int totalScore = 0;
        int bonusCounter = player.checkBonusCounter();
        System.out.println("\n" + player.getPlayerName() + "is up \n");

        //Bowls first ball
        System.out.println("Enter your Score for ball 1:");
        int score = getScore(totalScore);
        totalScore = totalScore + score;
        player.setFirstBall(frame, score);

        if (bonusCounter == 1 | bonusCounter == 2) {
            player.setPlayerScore(score + score);
            bonusCounter -= 1;
        }
        if (bonusCounter == 3) {
            player.setPlayerScore(score + score + score);
            bonusCounter -= 2;
        } else {
            player.setPlayerScore(score);
        }
        //Bowl Second Ball - System for when player bowled a strike on the first ball
        if (totalScore == 10){
            System.out.println("you have bowled a Strike!!");
            bonusCounter += 2;
            System.out.println("Enter your Score for ball 2 ");
            score = getScore(0);
            player.setSecondBall(frame, score);
            if(score == 10){
                System.out.println("Strike!!!");
            }
            player.setPlayerScore(score);
        }
        System.out.println(player.getPlayerName()+"'s Total Score is" + player.chcekPlayerScore());
    }
    /*
     * Gets the bowling score from the player
     */
    public int getScore(int totalScore) throws IOException{
        boolean validScore = false;
        int tempScore = 0;
        while (validScore == false) {
            String temp = new BufferedReader(new InputStreamReader(System.in)).readLine();
            while (temp.equals("")) {
                System.out.println("Please enter a number.");
                temp = new BufferedReader(new InputStreamReader(System.in)).readLine();
            }
            tempScore = Integer.parseInt(temp);
            if ((tempScore < 0) | (tempScore + totalScore > 10) ){
                System.out.println("You have entered an invalid number. Please try again.");
            }
            else {
                validScore = true;
            }
        }
        return tempScore;
    } // end GetScore method

    /*
     * Gets the bowling scores for the bonus round
     */
    public int getScore() throws IOException{
        boolean validScore = false;
        int tempScore = 0;
        while (validScore == false) {
            String temp = new BufferedReader(new InputStreamReader(System.in)).readLine();
            if (temp == null){
                System.out.println("Please enter a number.");
            }
            tempScore = Integer.parseInt(temp);
            if (tempScore < 0 | tempScore > 10){
                System.out.println("You have entered an invalid number. Please try again.");
            }
            else {
                validScore = true;
            }
        }
        return tempScore;
    } // end GetScore method for bonus round
}
