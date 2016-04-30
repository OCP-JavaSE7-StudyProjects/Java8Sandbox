package com.nng;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10);
        System.out.println(
                values.stream()
                        .filter(e -> e > 3)
                        .filter(e -> e % 2 == 0)
                        .map(e -> e * 2)
                        .findFirst()
                        .get());//without this we get an Optional(8)
    }

}
