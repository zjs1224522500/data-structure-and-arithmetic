package me.elvis.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Version:v1.0 (description:  )
 */
public class TestEfficiency {

	public static void main(String[] args)
			throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		System.out.println(
				getRunTimeResults(TestEfficiency.class.getMethod("mod", int.class, int.class), 323,
						10));
		System.out.println(
				getRunTimeResults(TestEfficiency.class.getMethod("add", int.class, int.class), 321,
						10));
	}

	public static void mod(int a, int b) {
		int c = a % b;
	}

	public static void add(int a, int b) {
		int c = a + b;
	}

	public static String getRunTimeResults(Method method, Object... args)
			throws InvocationTargetException, IllegalAccessException {
		long startTime = System.nanoTime();

		method.invoke(null, args);

		long endTime = System.nanoTime();
		long runTimeWithNS = endTime - startTime;
		long runTimeWithMS = runTimeWithNS / 1000000;
		long runTimeWithS = (endTime - startTime) / 1000000000;
		String result =
				method.getName() + "运行时间为" + runTimeWithS + "秒！！\n" + method.getName() + "运行时间为"
						+ runTimeWithMS + "毫秒！！\n" + method.getName() + "运行时间为" + runTimeWithNS
						+ "纳秒！！\n";
		return result;
	}

}
