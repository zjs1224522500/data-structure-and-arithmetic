package me.elvis.sort;

/**
 * Version:v1.0 (description:  ) Date:2017/11/27 0027  Time:09:05
 */
public class HeapSort implements SortTemplate {

    public static void main(String[] args) {
        new HeapSort().test(a);
    }

    /**
     * 堆排序：选择排序的改进
     * 创建大顶堆，然后将第一个和最后一个节点进行交换，输出最后一个节点，再调整堆
     * 时间复杂度： O(NlogN)
     * 空间复杂度： O(1)
     * 稳定性：不稳定
     *
     * @param a
     */
    @Override
    public void sort(Comparable[] a) {
        buildMaxHeapify(a);
        heapSort(a);
    }

    /**
     * 排序，最大值放在末尾，data虽然是最大堆，在排序后就成了递增的
     *
     * @param data
     */
    private void heapSort(Comparable[] data) {
        //末尾与头交换，交换后调整最大堆
        for (int i = data.length - 1; i > 0; i--) {
            exch(data, 0, i);
            maxHeapify(data, i, 0);
        }
    }

    public void buildMaxHeapify(Comparable[] data) {
        //没有子节点的才需要创建最大堆，从最后一个的父节点开始
        int startIndex = getParentIndex(data.length - 1);
        //从尾端开始创建最大堆，每次都是正确的堆
        for (int i = startIndex; i >= 0; i--) {
            maxHeapify(data, data.length, i);
        }
    }

    /**
     * 创建最大堆
     *
     * @param data     数组
     * @param heapSize 需要创建最大堆的大小
     * @param index    当前需要创建最大堆的位置
     */
    private void maxHeapify(Comparable[] data, int heapSize, int index) {
        // 当前点与左右子节点比较
        int left = getChildLeftIndex(index);
        int right = getChildRightIndex(index);

        // 假定当前位置对应为最大值
        int largest = index;
        // 若左子节点大于最大值，则左子节点为最大值
        if (left < heapSize && less(data[index], data[left])) {
            largest = left;
        }
        // 若右子节点大于最大值，则右子节点为最大值
        if (right < heapSize && less(data[largest], data[right])) {
            largest = right;
        }
        // 得到最大值后可能需要交换，如果交换了，其子节点可能就不是最大堆了，需要重新调整
        if (largest != index) {
            exch(data, index, largest);
            maxHeapify(data, heapSize, largest);
        }
    }

    /**
     * 父节点位置 (x-1)/2
     *
     * @param current
     * @return
     */
    private int getParentIndex(int current) {
        return (current - 1) >> 1;
    }

    /**
     * 左子节点position注意括号，加法优先级更高 2x+1
     *
     * @param current
     * @return
     */
    private int getChildLeftIndex(int current) {
        return (current << 1) + 1;
    }

    /**
     * 右子节点position 2x+2
     *
     * @param current
     * @return
     */
    private int getChildRightIndex(int current) {
        return (current << 1) + 2;
    }

}
