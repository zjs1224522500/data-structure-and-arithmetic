package me.elvis.test;

import org.junit.Test;

public class TestDemo {

    public static void main(String[] args) {

    }

    @Test
    public void efficientMod() {
        // 11111111111111111111  2^n-1
        int length = 2047;
        int i = 23;
        System.out.println((i % length) == (i & length));;
    }
}
