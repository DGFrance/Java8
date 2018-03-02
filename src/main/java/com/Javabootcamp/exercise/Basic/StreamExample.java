package com.Javabootcamp.exercise.Basic;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        String[][] listAlphabet = new String[3][5];
        listAlphabet[0] = new String[]{"A", "B", "C", "D", "E"};
        listAlphabet[1] = new String[]{"F", "G", "H", "I", "J"};
        listAlphabet[2] = new String[]{"K", "L", "M", "N", "O"};

        int[][] listNumber = new int[3][5];
        listNumber[0] = new int[]{0, 1, 2, 3, 4};
        listNumber[1] = new int[]{5, 6, 7, 8, 9};
        listNumber[2] = new int[]{10, 11, 12, 13, 14};

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

class Stream1 {
    public static void main(String[] args) {
        IntStream.range(1, 4).mapToObj(s -> "a" + s).forEach(System.out::println);

        Stream.of(1.1, 2.2, 3.3, 4.4).mapToInt(Double::intValue).mapToObj(s -> "b" + s).forEach(System.out::println);
    }
}

class Stream2 {
    public static void main(String[] args) {
        List<String> MyList = Arrays.asList("Donny", "Dani", "Deni", "Agri", "Steven");
        MyList.stream().filter(s -> s.startsWith("D")).map(String::toUpperCase).sorted().forEach(System.out::println);
    }
}

class Stream3 {
    public static void main(String[] args) {
        Arrays.asList("Donny", "Agri", "Stevem").stream().findFirst().ifPresent(System.out::println);
        // Same But Different, But Still Same.
        Stream.of("Donny", "Agri", "Steven").findFirst().ifPresent(System.out::println);
    }
}

class Stream4 {
    public static void main(String[] args) {
        Arrays.stream(new int[]{1, 2, 3, 4, 5}).map(n -> 2 * n + 1).average().ifPresent(System.out::println);

        Stream.of("D1", "A2", "S3").map(s -> s.substring(1)).mapToInt(Integer::parseInt).max().ifPresent(System.out::println);
    }
}

class Stream5 {
    public static void main(String[] args) {
        Stream.of("d1", "a2", "c3", "b4", "e5")
                .map(s -> {
                    System.out.println("Map : " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("Any Match : " + s);
                    return s.startsWith("A");
                });
    }
}

class Stream6 {
    public static void main(String[] args) {
        Stream.of("d1", "a2", "c3", "b4", "e5")
                .filter(s -> {
                    System.out.println("filter " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach " + s));
    }
}

class Stream7 {
    public static void main(String[] args) {
        Stream.of("d1", "a2", "c3", "b4", "e5")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s, %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));
    }
}

class Stream8 { //Advance Operation
    String name;
    int age;

    Stream8(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        List<Stream8> persons = Arrays.asList(
                new Stream8("Max", 18),
                new Stream8("Judy", 20),
                new Stream8("Angel", 10),
                new Stream8("Fredy", 15),
                new Stream8("Donny", 14));

        List<Stream8> Filtered = persons.stream()
                .filter(s -> s.name.startsWith("D")).collect(Collectors.toList());
        System.out.println(Filtered + "\n");

        Map<Integer, List<Stream8>> personByAge = persons.stream()
                .collect(Collectors.groupingBy(s -> s.age));
        personByAge.forEach((age, s) -> System.out.format("age %s: %s\n", age, s));

        Double averageAge = persons.stream()
                .collect(Collectors.averagingInt(p -> p.age));
        System.out.println("\n The Average Age is:" + averageAge);

        IntSummaryStatistics summaryStatistics = persons.stream()
                .collect(Collectors.summarizingInt(p -> p.age));
        System.out.println("\n" + summaryStatistics);

        String pharse = persons.stream()
                .filter(s -> s.age >= 18)
                .map(s -> s.name)
                .collect(Collectors.joining(( " In Indonesia" + " %s And %s " +"are of Legal Age.")));
                System.out.println("\n" + pharse);
    }
}
