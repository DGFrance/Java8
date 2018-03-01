package com.Javabootcamp.exercise.Basic.Mapping;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main (String[] args){
        Map<String, Integer> mapping = new HashMap<>();
        mapping.put("Donny",23);
        mapping.put("Leo", 25);
        mapping.put("Agri", 24);
        mapping.put("Steven", 25);
        mapping.put("Hafi",22);

        System.out.println("Print Original : " + mapping);
    }
}
