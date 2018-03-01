package com.Javabootcamp.exercise.Advance.BowlingScore.main;

import com.Javabootcamp.exercise.Advance.BowlingScore.Class.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BowlingApp {
    public static void main(String[]args) throws IOException{
        BowlingSystem bowlingSystem = new BowlingSystem();
        List<Player> playerList = new ArrayList<Player>();

        String selection;
        String name;

        System.out.println("Please Enter Your Name: ");
        name = new BufferedReader(new InputStreamReader(System.in)).readLine();
        playerList.add(new Player(name));
    }
}

