package edu.feng.sort;

import StdLib.In;
import StdLib.StdOut;

/**
 * @Classname Multiway
 * @Description TODO
 * @Date 2019-08-09 11:23
 * @Created by feng
 * 使用优先队列的向归并
 */
public class Multiway {
    public static void merge(In[] streams) {
        int N = streams.length;
        IndexMinPQ<String> pq = new IndexMinPQ<>(N);

        for (int i = 0; i < N; i++) {
            if (!streams[i].isEmpty())
                pq.insert(i, streams[i].readString());
        }

        while(!pq.isEmpty()){
            StdOut.println(pq.min());
            int i = pq.delMin();
            if (!streams[i].isEmpty())
                pq.insert(i, streams[i].readString());
        }


    }
}
