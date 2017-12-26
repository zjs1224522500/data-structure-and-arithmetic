package me.elvis.interview;

import java.io.File;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Version:v1.0 (description:  ) Date:2017/11/28 0028  Time:14:37
 */
public class Test {

	public static void main(String[] args){
//		File newFile = new File("C:\\Users\\Administrator\\Desktop");
//		File file = new File(newFile,"1234.txt");
//		System.out.println(file.mkdir());

		TreeSet treeSet = new TreeSet();
		HashSet hashSet = new HashSet();
		hashSet.add(1);
		hashSet.add(0);
		hashSet.add(3);
		hashSet.add(2);
		hashSet.add(-1);
		hashSet.add(null);
		hashSet.add(null);
		System.out.println(hashSet);
		treeSet.add(1);
		treeSet.add(0);
		treeSet.add(3);
		treeSet.add(2);
		treeSet.add(-1);
		System.out.println(treeSet);
	}


}
