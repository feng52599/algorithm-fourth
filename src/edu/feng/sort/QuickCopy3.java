package edu.feng.sort;

import StdLib.In;
import StdLib.StdOut;
import StdLib.StdRandom;

/**
 * @Classname Selection
 * @Description TODO
 * @Date 2019-08-05 15:43
 * @Created by feng
 * 插入排序
 */
public class QuickCopy3 {
    public static void sort(Comparable[] a) {
        // 消除对输入的依赖
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        // --j
        int i = lo, j = hi + 1;
        Comparable v = a[lo];

        while (true) {
            // 如果i位置小于a[lo]右移指针
            while (less(a[++i], a[lo])){
                if (i == hi) break;
            }
            // 知道a[j]比a[lo]小为止
            while (less(a[lo], a[--j])){
                if (j == lo) break;
            }
            if (i >= j) break;
            exch(a, i, j);
        }
        // 把lo放到正确的位置(j)
        exch(a, lo, j);
        return j;
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
