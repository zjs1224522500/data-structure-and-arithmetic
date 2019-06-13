package tech.shunzi.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class StringSort {

    public static void main(String[] args) {

        List<String> originalList = randomStringList(20,5);
        Collections.sort(originalList);
        System.out.println(originalList.toString());

    }

    private static List<String> randomStringList(int size, int stringLength) {
        List<String> mockStringList = new ArrayList<>(size);
        for (int i = 0;i < size; i++)
        {
            mockStringList.add(getRanddomString(stringLength));
        }
        return mockStringList;
    }

    private static String getRanddomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            result.append(str.charAt(number));
        }
        return result.toString();
    }
}
