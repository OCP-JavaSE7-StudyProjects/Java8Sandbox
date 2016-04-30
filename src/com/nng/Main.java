package com.nng;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    private static Consumer<List<Integer>> consumer = Main::doSorting;
    private static Function<Integer, String> function = Main::convert;
    private static Predicate<Integer> predicate = (Integer i) -> i > 2 && i < 8;

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 5, 3, 20, 5);
        List<Integer> numbers2 = Arrays.asList(10, 5, 3, 20, 5);

        System.out.println(numbers);
        sort(numbers, Main::doSorting);
        sort(numbers, consumer);

        System.out.println(numbers);

        String l = numbers.stream().filter(i -> i >= 10).map(i -> i.toString()).collect(Collectors.joining(", "));
        System.out.println(l);

        numbers.stream().filter(i -> i >= 5).forEach(System.out::println);

        System.out.println("--------- ez meglehetősen cseles ---------");
        Stream.of(numbers,numbers2,numbers).distinct().forEach(System.out::println); //WOOOOWW
        Stream.of(400,400, 23,2,23).distinct().forEach(System.out::println);
        Stream.of("-", "aa", "bbasd", "-").distinct().forEach(System.out::println);

//        List<Integer> evenNumbers = numbers.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        List<Integer> evenNumbers = numbers.stream().filter(Main::isEven).collect(Collectors.toList());
        System.out.println(evenNumbers);

        List<Integer> n = numbers.stream().filter(predicate).collect(Collectors.toList());

        Optional<Integer> min = numbers.stream().min(Integer::compare);
        System.out.println(min);

        long count = IntStream.range(0, 10).filter(Main::isEven).filter(Main::greaterThanFive).count();
        System.out.println(count);

//        IntStream.range(10,50).flatMap()

//        System.out.println(stream.toArray());
    }

    private static boolean isEven(Integer i) {
        return i % 2 == 0;
    }

    private static boolean greaterThanFive(Integer i) {
        return i > 5;
    }

    private static void sort(List<Integer> array, Consumer<List<Integer>> consumer) {
        consumer.accept(array);
    }

    private static void doSorting(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    private static String convert(Integer i) {
        return i.toString();
    }


}