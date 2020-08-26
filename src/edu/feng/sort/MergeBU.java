package edu.feng.sort;

import StdLib.In;
import StdLib.StdOut;

/**
 * @Classname MergeBU
 * @Description TODO
 * @Date 2019-08-05 15:43
 * @Created by feng
 * 归并排序（自底向上）
 */
public class MergeBU {
    // 辅助数组
    public static Comparable[] aux;

    public static void sort(Comparable[] a) {
        // 将a[] 按升序排序
        // 一次性分配空间
        int N = a.length;
        aux = new Comparable[N];
        // 先两两归并，之后是44归并，88.....
        // 每一次都是从头到尾分组排序
        for (int sz = 1; sz < N; sz = sz + sz)
            // 每一组的排序
            for (int lo = 0; lo < N - sz; lo += sz + sz)
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
    }

    // 原地归并的抽象方法
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        // 将a[lo..mid] 和 a[mid+a..hi]归并
        int i = lo, j = mid + 1;
        // 数组复制
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        // 归并到a[lo,hi]
        for (int k = lo; k <= hi; k++) {
            // 左半边用尽（取右半边的元素）、右半边用尽（取左半边的元素）、
            // 右半边的当前元素小于左半边的当前元素（取右半边的元素）
            // 右半边的当前元素大于等于左半边的当前元素（取左半边的元素）
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        // 单行打印
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        // 测试数组元素是否有序
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) {
                System.out.println("false");
                return false;
            }
        return true;
    }

    public static void main(String[] args) {
        String[] a = new In("tiny.txt").readAllStrings();
        sort(a);
        try {
            assert isSorted(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        show(a);
    }
}
