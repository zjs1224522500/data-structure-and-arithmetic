package me.elvis.sort;

/**
 * Version:v1.0 (description:  ) Date:2017/11/26 0026  Time:15:32
 */
public class SelectionSort implements SortTemplate {

    public static void main(String[] args) {
        new SelectionSort().test(a);
    }

    /**
     * 选择排序：每次选择一个最小的数
     * 时间复杂度：O(n^2)
     * 空间复杂度: O(1)
     * 稳定性：不稳定
     * 假设第一个是最小的数，遍历该数之后的数比较大小，若更小，则min指向该数
     * 循环遍历下来之后每一次都能找到未排序数组中的最小值。
     *
     * @param a
     */
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }
}
