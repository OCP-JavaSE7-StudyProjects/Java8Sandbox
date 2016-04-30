package com.nng;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static int doubleIt(int number) {
        //simulatnig complex calculation in time
        try {Thread.sleep(1000);} catch (Exception ex) {}
        return number * 2;
    }


    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 2, 3, 5, 4, 6);

        System.out.println(
                values.stream()
                        .mapToInt(Main::doubleIt)
                        .sum());

        //referential transparency needed ("clean function")
        System.out.println(
                values.parallelStream()
                        .mapToInt(Main::doubleIt)
                        .sum());
    }

}
