package me.elvis.sort;

/**
 * Version:v1.0 (description:  ) Date:2017/11/26 0026  Time:16:08
 */
public class InsertionSort implements SortTemplate {

	/**
	 * 插入排序：每次从未排序的对象里选最小的插入到已排序的正确位置
	 * 时间复杂度: O(n^2)
	 * 空间复杂度：O(1)
	 * 稳定性：稳定
	 * 如何保证正确位置：遍历交换使得前一个元素小于后一个 a[j-1] < a[j]
	 * 每次交换都只能交换相邻的两个元素，效率较低
	 * @param a
	 */
	@Override
	public void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 1; i < N; i++) {
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
			}
		}
	}

	public static void main(String[] args) {
		new InsertionSort().test(a);
	}
}
