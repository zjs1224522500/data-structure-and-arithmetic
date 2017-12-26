package me.elvis.collection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.RandomAccess;
import java.util.Set;
import java.util.TreeSet;

import me.elvis.test.TestEfficiency;

/**
 * Version:v1.0 (description:  ) Date:2017/12/26 0026  Time:14:42
 */
public class Ergodic<E> {

	private static Ergodic instance = null;

	private Ergodic() {
	}

	public static Ergodic<String> getInstance() {
		if (null == instance) {
			instance = new Ergodic<String>();
		}
		return instance;
	}

	public void printAllUsingForEach(Set<E> set) {
		for (E e : set) {
			System.out.print(e);
		}
		System.out.println();
	}

	public void printAllUsingIterator(Set<E> set) {
		for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
			System.out.print(iterator.next());
		}
		System.out.println();
	}

	public void printAllUsingForEach(List<E> list) {
		for (E e : list) {
			System.out.print(e);
		}
		System.out.println();
	}

	public void printAllUsingFor(List<E> list) {
		for (int i = 0, size = list.size(); i < size; i++) {
			System.out.print(list.get(i));
		}
		System.out.println();
	}

	public void printAllUsingIterator(List<E> list) {
		for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
			E e = (E) iterator.next();
			System.out.print(e);
		}
		System.out.println();
	}

	/**
	 * 判断list是否支持随机访问，支持则使用for循环遍历，不支持则使用迭代器
	 *
	 * @param list
	 */
	public void printAll(List<E> list) {
		if (list instanceof RandomAccess) {
			printAllUsingFor(list);
		} else {
			printAllUsingIterator(list);
		}
	}

	public static String getListErgodicRunningTime(String methodName, Object param) {
		String str = null;
		try {
			str = TestEfficiency.getRunTimeResults(getInstance(),
					Ergodic.class.getMethod(methodName, List.class), param);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return str;
	}

	@Test
	public void test2() {
		Set<String> hashSet = new HashSet<String>() {{
			add("张三");
			add("李四");
			add("王五");
		}};

		Set<String> treeSet = new TreeSet<String>(){{
			add("张三");
			add("李四");
			add("王五");
		}};

		getInstance().printAllUsingIterator(hashSet);
		getInstance().printAllUsingIterator(treeSet);

		getInstance().printAllUsingForEach(hashSet);
		getInstance().printAllUsingForEach(treeSet);
	}

	@Test
	public void test1() {
		List<String> orderList = new ArrayList<String>() {{
			add("张三");
			add("李四");
			add("王五");
		}};

		List<String> randomList = new LinkedList<String>() {{
			add("张三");
			add("李四");
			add("王五");
		}};

		for (int i = 0; i < 100000; i++) {
			orderList.add("张三");
			randomList.add("张三");
		}

		Ergodic<String> ergodic = getInstance();
		//		ergodic.printAllUsingFor(orderList);
		//		ergodic.printAllUsingFor(randomList);
		//		ergodic.printAllUsingForEach(orderList);
		//		ergodic.printAllUsingForEach(randomList);
		//		ergodic.printAllUsingIterator(orderList);
		//		ergodic.printAllUsingIterator(randomList)

		System.out.println("顺序结构-For：" + getListErgodicRunningTime("printAllUsingFor", orderList));
		System.out.println("链式结构-For：" + getListErgodicRunningTime("printAllUsingFor", randomList));

		System.out.println(
				"顺序结构-ForEach：" + getListErgodicRunningTime("printAllUsingForEach", orderList));
		System.out.println(
				"链式结构-ForEach：" + getListErgodicRunningTime("printAllUsingForEach", randomList));

		System.out.println(
				"顺序结构-迭代器：" + getListErgodicRunningTime("printAllUsingIterator", orderList));
		System.out.println(
				"链式结构-迭代器：" + getListErgodicRunningTime("printAllUsingIterator", randomList));

		//		ergodic.printAll(orderList);
		//		ergodic.printAll(randomList);
	}

}
