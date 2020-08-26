package edu.feng.sort;

import StdLib.StdIn;
import StdLib.StdOut;

/**
 * @Classname MaxPQ
 * @Description TODO
 * @Date 2019-08-09 10:59
 * @Created by feng
 * 基于堆的优先队列
 */

// 这里相当于使用泛型，但是这里的泛型Key有限制，表示必须实现Comparable<Key>这个接口才能当成参数传递；如Java自带的Integer、String都符合这个要求；而且这种写法只能当成类的泛型使用，这里其实是将泛型Key擦除到它的一个边界
public class MaxPQ<Key extends Comparable<Key>> {
    // 基于堆的完全二叉树
    private Key[] pq;
    // 存储与pq[1..N]中， pq[0]没有使用
    private int N = 0;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public MaxPQ() { this(1); }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        // 从跟节点得到最大元素
        Key max = pq[1];
        // 将其和最后一个节点交换
        exch(1, N--);
        // 防止越界
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    // 上浮
    public void swim(int k) {
        // 如果k不是root节点，并且根节点小于k所在节点交换，如果还大，就继续上浮
        while (k > 1 && less(k/2, k)){
            exch(k/2, k);
            k = k/2;
        }
    }

    // 下沉
    private void sink(int k) {
        // 当这个节点的两倍小于数组长度，或者说这个节点至少有一个子节点时
        while (2 * k <= N) {
            int j = 2*k;
            // 如果j比N小并且 j的值比j+1的值还要笑，那么就将j+1，
            if (j < N && less(j, j+1)) j++;
            // 如果a[k] > a[j] 就不能下沉
            if (!less(k, j)) break;
            exch(k, j);
            // 如果还小的话，可能可以继续下沉
            k = j;
        }
    }

    public static void main(String[] args) {
        MaxPQ<String> pq = new MaxPQ<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) pq.insert(item);
            else if (!pq.isEmpty()) StdOut.print(pq.delMax() + " ");
        }
        StdOut.println("(" + pq.size() + " left on pq)");
    }

}
