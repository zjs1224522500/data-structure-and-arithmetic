package me.elvis.sort;

import java.util.Arrays;

/**
 * Version:v1.0 (description:  ) Date:2017/11/28 0028  Time:13:12
 */
public class RadixSort implements SortTemplate {

    /**
     * 基数排序:不需要比较关键字的大小。
     * 它是根据关键字中各位的值，通过对排序的N个元素进行若干趟“分配”与“收集”来实现排序的。
     * 按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。
     * 有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序，最后的次序就是高优先级高的在前，
     * 高优先级相同的低优先级高的在前。
     * 时间复杂度：O(d*(r+n)) r代表关键字基数，d代表长度，n代表关键字个数
     * 空间复杂度：O(rd+n)
     * 稳定性：稳定
     *
     * @param a
     */
    @Override
    public void sort(Comparable[] a) {
        Integer[] integers = (Integer[]) a;
        int[] list = Arrays.stream(integers).mapToInt(Integer::valueOf).toArray();
        radixSort(list, 0, list.length - 1, 2);
    }

    // 获取x这个数的d位数上的数字
    // 比如获取123的1位数，结果返回3
    public int getDigit(int x, int d) {
        int a[] = {1, 1, 10, 100, 1000, 10000};
        return ((x / a[d]) % 10);
    }

    public void radixSort(int[] list, int begin, int end, int digit) {
        final int radix = 10; // 基数
        int i = 0, j = 0;
        int[] count = new int[radix]; // 存放各个桶的数据统计个数
        int[] bucket = new int[end - begin + 1];

        // 按照从低位到高位的顺序执行排序过程
        for (int d = 1; d <= digit; d++) {

            // 置空各个桶的数据统计
            for (i = 0; i < radix; i++) {
                count[i] = 0;
            }

            // 统计各个桶将要装入的数据个数
            for (i = begin; i <= end; i++) {
                j = getDigit(list[i], d);
                count[j]++;
            }

            // count[i]表示第i个桶的右边界索引
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }

            // 将数据依次装入桶中
            // 这里要从右向左扫描，保证排序稳定性
            for (i = end; i >= begin; i--) {
                j = getDigit(list[i], d); // 求出关键码的第k位的数字， 例如：576的第3位是5
                bucket[count[j] - 1] = list[i]; // 放入对应的桶中，count[j]-1是第j个桶的右边界索引
                count[j]--; // 对应桶的装入数据索引减一
            }

            // 将已分配好的桶中数据再倒出来，此时已是对应当前位数有序的表
            for (i = begin, j = 0; i <= end; i++, j++) {
                list[i] = bucket[j];
            }
        }
    }

}
