package com.Javabootcamp.exercise.Basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
    public static void main (String[]args){
        String[][] listAlphabet = new String[3][5];
        listAlphabet[0] = new String[]{"A","B","C","D","E"};
        listAlphabet[1] = new String[]{"F","G","H","I","J"};
        listAlphabet[2] = new String[]{"K","L","M","N","O"};

        int[][] listNumber = new int[3][5];
        listNumber [0] = new int[]{0,1,2,3,4};
        listNumber [1]  = new int[]{5,6,7,8,9};
        listNumber [2] = new int[]{10,11,12,13,14};

        String[] arr = Arrays.stream(listAlphabet).flatMap(Arrays::stream).toArray(String[]::new);
        System.out.println(Arrays.stream(arr).collect(Collectors.joining(",")));
         //Another Method
        //        String newvar = Arrays.stream(arr).collect(Collectors.joining(" "));
       //        System.out.println(newvar);

        int[] ars = Arrays.stream(listNumber).flatMapToInt(Arrays::stream).toArray();
//        System.out.println(Arrays.stream(ars));
        Arrays.stream(ars).forEach(System.out::print);


    }
}

