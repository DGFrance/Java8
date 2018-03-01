package com.Javabootcamp.exercise.Advance.BowlingScore.main;

import com.Javabootcamp.exercise.Advance.BowlingScore.Class.Player;

import java.io.IOException;
import java.util.List;

public class BowlingSystem {

    public void mainMenu() {
        System.out.println("1. Enter a player name\n2. Begin bowling\n3. Quit");
        System.out.println("Enter a number between 1-3:");
    }

    public void printPlayerInfo(List<Player> playerList) {
        System.out.println("There are " + playerList.size() + "player(s) in the game.");
        System.out.println("The Players are : ");
        for(Player player:playerList) {
            System.out.println(player.getPlayerName());
        }
    }

    public void bowlFrame(Player player, int frame) throws IOException{
        int totalScore = 0;
        int bonusCounter = player.checkBonusCounter();
        System.out.println(player.getPlayerName());

        //Bowls First Round
        System.out.println("Enter your score for ball 1 : ");
        int score = getScore(totalScore);
        totalScore = totalScore + score;
        player.setFirstBall(frame,score);

        //update player Score
        if(bonusCounter == 1 | bonusCounter ==2){
            player.setPlayerScore(score + score);
            bonusCounter -= 1;
        }
        if(bonusCounter == 3) {
        player.setPlayerScore(score + score + score);
            bonusCounter -= 2;

        } else {
            player.setPlayerScore(score);
        }

        if (totalScore == 10){
            player.setSecondBall(frame, score);
            System.out.println("Strike");

        } else {
            System.out.println("Enter your score for ball2"); // Gets score for ball 2 if there was no strike
            score = getScore(totalScore);
            player.setSecondBall(frame, score);
            if(bonusCounter == 1){
                player.setPlayerScore(score + score);
                bonusCounter -= 1;
            } else {
                player.setPlayerScore(score);
            }
            totalScore = score + score;
            if(totalScore == 10){
                System.out.println("Spare");
            }
        }

    }

    private int getScore(int totalScore) throws IOException {
        return totalScore;
    }
}
