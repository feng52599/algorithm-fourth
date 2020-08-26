package edu.feng.sort;

import StdLib.StdOut;
import StdLib.StdRandom;
import StdLib.Stopwatch;

/**
 * @Classname SortCompare
 * @Description TODO
 * @Date 2019-08-07 11:11
 * @Created by feng
 */
public class SortCompare {
    public static double time(String alg, Comparable[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Merge"))
            Merge.sort(a);
        if (alg.equals("Selection"))
            Selection.sort(a);
        if (alg.equals("Shell"))
            Merge.sort(a);
        if (alg.equals("Insertion"))
            Merge.sort(a);
        if (alg.equals("Quick"))
            Merge.sort(a);
        if (alg.equals("Heap"))
            Merge.sort(a);
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        // 使用算法1 将zT个长度为N的数组排序
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            // 进行一次测试（生成一个数组并排序）
            for (int i = 0; i < N; i++)
                a[i] = StdRandom.uniform();
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
//        String alg1 = args[1];
//        String alg2 = args[2];
//        int N = Integer.parseInt(args[3]);
//        int T = Integer.parseInt(args[4]);
        double t1 = timeRandomInput("Merge", 10000, 100);
        double t2 = timeRandomInput("Shell", 10000, 100);
        StdOut.printf("For %d random Double\n   %s is", 10000, "Merge");
        StdOut.printf(" %.1f times faster than %s \n", t2/t1, "Shell");
    }
}

