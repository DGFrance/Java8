package com.Javabootcamp.exercise.Advance.BowlingScore.Class;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String playerName;
    private List<Integer> firstBall = new ArrayList<Integer>();
    private List<Integer> secondBall = new ArrayList<Integer>();
    private int bonusBall;
    private int playerScore;
    private int bonusCounter;

    public Player(String name) {
        playerName = name;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int checkFirstBall(int frame) {
        return firstBall.get(frame);
    }

    public void setFirstBall(int frame, int score) throws IOException {
        this.firstBall.add(score);
    }

    public int checkSecondBall(int frame) {
        return secondBall.get(frame);
    }

    public void setSecondBall(int frame, int score) throws IOException {
        this.secondBall.add(score);
    }

    public int checkBonusBall() {
        return bonusBall;
    }

    public void setBonusBall(int score) {
        this.bonusBall = score;
    }

    public int chcekPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int score) {
        this.playerScore = playerScore + score;
    }

    public int checkBonusCounter() {
        return bonusCounter;
    }

    public void setBonusCounter(int bonusCounter) {
        this.bonusCounter = bonusCounter;
    }
}
