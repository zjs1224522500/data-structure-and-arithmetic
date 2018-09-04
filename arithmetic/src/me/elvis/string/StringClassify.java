package me.elvis.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Version:v1.0
 * (description:
 * 牛牛有N个字符串，他想将这些字符串分类，他认为两个字符串A和B属于同一类需要满足以下条件：
 * A中交换任意位置的两个字符，最终可以得到B，交换的次数不限。比如：abc与bca就是同一类字符串。
 * 现在牛牛想知道这N个字符串可以分成几类。
 * in:	4
 * abcd
 * abdc
 * dabc
 * bacd
 * out: 1
 * )
 * <p>
 * Date:2017/11/16 0016  Time:15:25
 */
public class StringClassify {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String[] str = new String[N];
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < N; i++) {
            String temp = sc.nextLine();
            System.out.println(temp);
            str[i] = sortStr(temp);
            set.add(str[i]);
        }
        System.out.println(set.size());
    }

    public static String sortStr(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
