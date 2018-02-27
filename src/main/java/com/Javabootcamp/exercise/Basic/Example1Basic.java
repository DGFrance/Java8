package com.Javabootcamp.exercise.Basic;

public class Example1Basic {
    public static void main(String[] args){
        new Thread(() -> System.out.println("Lambda Expression")).start();
    }
}
