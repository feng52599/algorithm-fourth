package edu.feng.sort;

import StdLib.In;
import StdLib.StdOut;
import StdLib.StdRandom;

/**
 * @Classname Quick
 * @Description TODO
 * @Date 2019-08-05 15:43
 * @Created by feng
 * 快速排序
 */
public class QuickCopy {
    public static void sort(Comparable[] a) {
        // 将a[] 按升序排序

        // 消除对输入的依赖
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (low >= high) return;
        int index = partition(a, low, high);
        //先对左半部分排序，再对右半部分排序
        sort(a, low, index - 1);
        sort(a, index + 1, high);
    }

    /**
     * 关键在于切分方法
     * 要切分的使对某个j，a[j]已经排定
     * 0-j的元素都不大于a[j]
     * j-..的元素都大于a[j]
     */
    private static int partition(Comparable[] a, int low, int high) {
        int i = low, j = high + 1;
        Comparable v = a[low];
        while (true) {
            // 扫描左右，检查扫描是否结束并交换元素
            // 必须是++i --j 因为在此处用的就是加了后的值 要比对的也是+了后的
            while (less(a[++i], v)) {
                if (i == high)
                    break;
            }
            while (less(v, a[--j])) {
                if (j == low)
                    break;
            }
            if (i >= j)
                break;
            exch(a, i, j);
        }
        //将v = a[j] 放入正确的位置
        exch(a, low, j);
        // a[lo..j-1] <= a[j] <= a[j+1..hi] 达成
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
