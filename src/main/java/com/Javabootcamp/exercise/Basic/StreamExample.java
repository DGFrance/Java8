package com.Javabootcamp.exercise.Basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public static void main (String[]args){
        String[][] listAlphabet = new String[3][5];
        listAlphabet[0] = new String[]{"A","B","C","D","E"};
        listAlphabet[1] = new String[]{"F","G","H","I","J"};
        listAlphabet[2] = new String[]{"K","L","M","N","O"};


        int [] int1 = new int[]{1,2,3};
        int[] int2 = new int[]{4,5,6};
        int[] int3 = new int[]{7,8,9};

        String[] arr = Arrays.stream(listAlphabet).flatMap(Arrays::stream).toArray(x -> new String[x]);
        System.out.println(Arrays.stream(arr).collect(Collectors.joining(",")));
//        String newvar = Arrays.stream(arr).collect(Collectors.joining(" "));
//        System.out.println(newvar);
    }
}

