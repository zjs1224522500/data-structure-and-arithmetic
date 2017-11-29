package me.elvis.sort;

/**
 * Version:v1.0 (description:  ) Date:2017/11/27 0027  Time:09:00
 */
public class BubbleSort implements SortTemplate {

	/**
	 * 冒泡排序：每次比较相邻的两个数，根据大小关系进行交换。一趟下来，最大值位于最后
	 * 时间复杂度：O(N^2)
	 * 空间复杂度：O(1)
	 * 稳定性：稳定
	 * 优化：可通过设置标志位来进行标记减少比较次数（也可记录最后进行交换的位置）
	 * @param a
	 */
	@Override
	public void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < N - 1 - i; j++) {
				if (less(a[j + 1], a[j])) {
					exch(a, j, j + 1);
				}
			}
		}
	}

	public static void main(String[] args) {
		new BubbleSort().test(a);
	}
}
