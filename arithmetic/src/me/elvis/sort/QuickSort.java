package me.elvis.sort;

/**
 * Version:v1.0 (description:  ) Date:2017/11/27 0027  Time:09:08
 */
public class QuickSort implements SortTemplate {

    public static void main(String[] args) {
        new QuickSort().test(a);
    }

    /**
     * 快速排序：选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，将待排序列分成两部分,
     * 一部分比基准元素小,一部分大于等于基准元素,此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分。
     * 时间复杂度：O(NlogN)
     * 注意：若原序列有序，则快速排序时间复杂度变为 O(n^2)
     *
     * @param a
     */
    @Override
    public void sort(Comparable[] a) {
        if (a.length > 0) {
            quickSort(a, 0, a.length - 1);
        }
    }

    public int getMiddle(Comparable[] a, int low, int high) {
        Comparable temp = a[low];
        while (low < high) {
            while (low < high && less(temp, a[high])) {
                high--;
            }
            a[low] = a[high];
            while (low < high && less(a[low], temp)) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = temp;
        return low;
    }

    public void quickSort(Comparable[] a, int low, int high) {
        if (low < high) {
            int middle = getMiddle(a, low, high);
            quickSort(a, low, middle - 1);
            quickSort(a, middle + 1, high);
        }
    }
}
