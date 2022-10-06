package me.elvis.data.type.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @author Administrator
 */
public class ConcurrentSkipListTest {
    public static long count = 10000000L;
    public static List<Integer> dataList;

    public static void main(String[] args) {
        System.out.println("Hello world!");
        generateData(false);
        testSingleSkipList();
        testMultipleSkipList();
    }

    public static void generateData(Boolean seq) {
        System.out.println("Shuffle data");
        dataList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            dataList.add(i);
        }
        if (!seq) {
            Collections.shuffle(dataList);
        }
    }

    public static void testSingleSkipList() {


        System.out.print("Single SkipList: Insert " + count + " items:");
        ConcurrentSkipListSet<Integer> skipList = new ConcurrentSkipListSet<Integer>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            skipList.add(dataList.get(i));
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println(duration);
    }

    public static void testMultipleSkipList() {
        int listNum = 100;
        System.out.print("Multiple SkipList [with " + listNum  + " lists] : Insert " + count + " items:");
        List<ConcurrentSkipListSet<Integer>> skipListSetList = new ArrayList<>(listNum);
        for (int i = 0; i < listNum; i++) {
            skipListSetList.add(new ConcurrentSkipListSet<Integer>());
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            Integer data = dataList.get(i);
            ConcurrentSkipListSet<Integer> skipList = skipListSetList.get(data % listNum);
            skipList.add(data);
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println(duration);
    }
}