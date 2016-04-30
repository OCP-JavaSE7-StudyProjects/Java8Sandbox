package com.nng;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static boolean isEven(int number) {
        System.out.println("isEven " + number);
        return number % 2 == 0;
    }

    public static int doubleIt(int number) {
        System.out.println("doubleIt " + number);
        return number * 2;
    }

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10);

        Function<Integer, Predicate<Integer>> isGreaterThan =
                pivot ->
                        number ->
                //style with just a single operation
                              //  number > pivot;
                // style with not just one operation:
                                {
                                    System.out.println("isGreaterThan" + pivot + " " + number);
                                    return number > pivot;
                                };

        final Stream<Integer> streamPipe = values.stream()
                .filter(isGreaterThan.apply(3))
                .filter(Main::isEven)//if clear what is the parameter, we can use like this
                .map(Main::doubleIt);

        System.out.println(//without calling this, nothing will happen (!!lazy evaluation)
                streamPipe
                        .findFirst()
                        .get()//without this we get an Optional(8)

        );

    }

}
