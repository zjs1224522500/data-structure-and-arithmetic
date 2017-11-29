package me.elvis.interview;

/**
 * Version:v1.0 (description:  ) Date:2017/11/12 0012  Time:16:15
 */
public class VariableTest {

	//Java的中间缓存变量机制
	public static void testTemp() {
		int j = 0, m = 0;
		for (int i = 0; i < 100; i++) {
			j = j++;//等效为 int temp = j ; j = j + 1 ; j = temp ;所以分解之后可得出结论第二步未对结果造成影响
			m = ++m;//等效为 m = m + 1; int temp = m; m = temp;
		}
		System.out.println("j++ :" + j);
		System.out.println("++j :" + m);
	}

	public static void main(String[] args) {
		testTemp();
	}
}