package edu.feng.sort;

import StdLib.In;
import StdLib.StdOut;

/**
 * @Classname Selection
 * @Description TODO
 * @Date 2019-08-05 15:43
 * @Created by feng
 * 希尔排序：当一个h有序的数组按照增幅k排序之后，他仍然是h有序的
 */
public class Shell {
    public static void sort(Comparable[] a) {
        // 将a[] 按升序排序
        int N = a.length;
        int h = 1;
        // 1, 4, 13, 40, 121, 364, 1093
        while (h < N / 3)
            h = 3 * h + 1;

        while (h >= 1) {
            // 将数组变为h有序
            for (int i = h; i < N; i++) {
                // 将a[i]插入到a[i-h], a[i-2*h] a[i-3*h]中
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
                    exch(a, j, j-h);
            }
            h /= 3;
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
        }catch (Exception e){
            e.printStackTrace();
        }
        show(a);
    }
}
