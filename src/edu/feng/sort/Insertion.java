package edu.feng.sort;

import StdLib.In;
import StdLib.StdOut;

/**
 * @Classname Selection
 * @Description TODO
 * @Date 2019-08-05 15:43
 * @Created by feng
 * 插入排序
 */
public class Insertion {
    public static void sort(Comparable[] a) {
        // 将a[] 按升序排序
        int N = a.length;
        for (int i = 1; i < N; i++) {
            // 从后往前扫描， a[j] 要比a[j-1]小才会交换 缓慢的向前移动
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--)
                exch(a, j, j-1);
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
