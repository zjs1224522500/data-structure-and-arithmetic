package me.elvis.sort;

/**
 * Version:v1.0 (description:  ) Date:2017/11/27 0027  Time:09:07
 */
public class MergeSort implements SortTemplate {

    public static void main(String[] args) {
        new MergeSort().test(a);
    }

    /**
     * 归并排序：（1）“分解”——将序列每次折半划分。
     * （2）“合并”——将划分后的序列段两两合并后排序。
     * 时间复杂度：O(NlogN)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     *
     * @param a
     */
    @Override
    public void sort(Comparable[] a) {
        splitAndSort(a, 0, a.length - 1);
    }

    public void splitAndSort(Comparable[] num, int low, int high) {
        if (high <= low)
            return;
        int mid = (low + high) / 2;
        splitAndSort(num, low, mid);
        splitAndSort(num, mid + 1, high);
        merge(num, low, mid, high);
    }

    /**
     * 将数组中low到high位置的数进行排序(划分后的序列段合并)
     * <p>
     * 在每次合并过程中，都是对两个有序的序列段进行合并，然后排序。
     * 这两个有序序列段分别为 R[low, mid] 和 R[mid+1, high]。
     * 先将他们合并到一个局部的暂存数组R2中，带合并完成后再将R2复制回R中。
     * 为了方便描述，我们称 R[low, mid] 第一段，R[mid+1, high] 为第二段。
     * 每次从两个段中取出一个记录进行关键字的比较，将较小者放入R2中。最后将各段中余下的部分直接复制到R2中。
     * 经过这样的过程，R2已经是一个有序的序列，再将其复制回R中，一次合并排序就完成了。
     *
     * @param num  待排序数组
     * @param low  待排的开始位置
     * @param mid  待排中间位置
     * @param high 待排结束位置
     */
    public void merge(Comparable[] num, int low, int mid, int high) {
        Comparable[] temp = new Comparable[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;

        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (less(num[i], num[j])) {
                temp[k++] = num[i++];
            } else {
                temp[k++] = num[j++];
            }
        }

        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = num[i++];
        }

        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = num[j++];
        }

        // 把新数组中的数覆盖num数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            num[k2 + low] = temp[k2];
        }
    }
}
