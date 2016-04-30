package com.nng;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static int sumValues(List<Integer> numbers, Predicate<Integer> selector) {
       return numbers.stream()
               .filter(selector)
               .reduce(0,Math::addExact);
    }


    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10);

        System.out.println(sumValues(values, e -> e % 2 == 0));
    }

}
