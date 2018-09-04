package me.elvis.sort;

/**
 * Version:v1.0 (description:  ) Date:2017/11/26 0026  Time:15:03
 */
public interface SortTemplate {

    Integer[] a = {12, 5, 11, 4, 9, 6};

    void sort(Comparable[] a);

    default boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    default void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    default void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    default boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            if (less(a[i], a[i + 1])) {
                return false;
            }
        }
        return true;
    }

    default void test(Comparable[] a) {
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
