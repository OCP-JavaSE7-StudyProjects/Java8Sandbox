package com.nng;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

interface Selector {
    public boolean pick(int value);
}
//this is soo ugly and indokolatlanul long
//class EvenSelector implements Selector {
//    @Override
//    public boolean pick(final int value) {
//        return value % 2 == 0;
//    }
//}

public class Main {
    public static int sumValues(List<Integer> numbers, Selector selector) {
        int result = 0;
        for (int e : numbers) {
            if (selector.pick(e)) result += e;
        }
        return result;
    }


    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10);

        System.out.println(sumValues(values, e -> e % 2 == 0));
    }

}
