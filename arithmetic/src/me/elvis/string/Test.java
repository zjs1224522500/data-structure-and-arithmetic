package me.elvis.string;

import java.util.Scanner;

/**
 * Version:v1.0 (description:  ) Date:2017/11/18 0018  Time:16:39
 */
public class Test {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("输入一个整数(小于5):");

		int a = scanner.nextInt();
		String[] strings = new String[5];
		for (int j = 0; j < a; j++) {
			System.out.println("输入一个字符串");
			String string = scanner.next();
			char[] chars = string.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				for (int j1 = i + 1; j1 < chars.length; j1++) {
					if (chars[i] > chars[j1]) {
						char a1;
						a1 = chars[i];
						chars[i] = chars[j1];
						chars[j1] = a1;
					}
				}
			}
			String string1 = String.valueOf(chars);
			strings[j] = string1;
		}
		int count = 0;
		for (int j = 0; j < a; j++) {
			for (int i = j + 1; i < a; a++) {
				if (strings[j].equals(strings[i])) {
					count = 1;
					break;
				} else {
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
