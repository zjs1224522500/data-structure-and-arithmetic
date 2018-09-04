package me.elvis.sort;

/**
 * Version:v1.0 (description:  ) Date:2017/11/26 0026  Time:22:09
 */
public class ShellSort implements SortTemplate {

    public static void main(String[] args) {
        new ShellSort().test(a);
    }

    /**
     * 希尔排序（插入排序的改进）：
     * 时间复杂度：O(N^2) 或 O(N^1.3)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     * 插入排序是循环交换相邻元素；而希尔排序则是交换两元素间隔为h的元素。
     * 减少了交换次数提高了程序运行的速度
     *
     * @param a
     */
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

}
