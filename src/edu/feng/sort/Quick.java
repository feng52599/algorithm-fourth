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
 * P194
 */
public class Quick {
    public static void sort(Comparable[] a) {
        // 将a[] 按升序排序

        // 消除对输入的依赖
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        /**
         * 使用partition将a[j]放到合适的位置
         * 关键在于切分 这个过程要满足下面三个条件
         * 对某个j，a[j]已经排定
         * a[lo] 到a[j-1]中的所有元素都不大于a[j]
         * a[j+1] 到 a[hi]中的所有元素都不小于a[j]
         */
        int j = partition(a, lo, hi);
        // 将j左边元素排序
        sort(a, lo, j - 1);
        // 将j右边元素排序
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        // 将数组切分成a[lo..i-1], a[i], a[i+1..hi]
        // 左右扫描指针
        int i = lo, j = hi + 1;
        // 切分元素
        Comparable v = a[lo];
        while (true) {
            // 扫描左右，检查扫描是否结束并交换元素
            // 循环结束后，这个i是他碰到的第一个比他大的元素，i左边的都比它小
            // a[i]大于v的话 ，就跳出循环
            while (less(a[++i], v)) {
                if (i == hi)
                    break;
            }
            // 循环结束后，这个j是他碰到的第一个比他小的元素，j右边的都比它大
            // 从后往前扫描，如果v 大于 j的话跳出循环
            while (less(v, a[--j])) {
                if (j == lo)
                    break;
            }
            if (i >= j)
                break;
            // 交换a[i] 和 a[j]的位置，此时a[0]->a[i]不一定有序
            exch(a, i, j);

        }
        // 此时交换lo和j的位置，那么，这个这个j 的位置一定是有序的，j以前的数据都比他小，j以后的数据逗比他大
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
