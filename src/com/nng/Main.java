package com.nng;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        System.out.println(isPrime(1));
        System.out.println(isPrime(2));
        System.out.println(isPrime(3));
        System.out.println(isPrime(4));
    }

    private static boolean isPrime(final int number) {
       return number >1 &&
               IntStream.range(2,number)
               .noneMatch(index ->number %index ==0);
    }
}
