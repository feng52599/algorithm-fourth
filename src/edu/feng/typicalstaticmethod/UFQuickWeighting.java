package edu.feng.typicalstaticmethod;

import StdLib.StdIn;
import StdLib.StdOut;

/**
 * @Classname UF
 * @Description TODO
 * @Date 2019-08-05 10:11
 * @Created by feng
 * union-find(加权）的实现
 */
public class UFQuickWeighting {
    // 分量id 以触点作为索引
    private int[] id;
    // (由触点索引的)各个跟节点所对应的分量的大小
    private int[] sz;
    // 分量数量
    private int count;

    public UFQuickWeighting(int N) {
        // 初始化分量id数组
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        sz = new int[N];
        // 初始权重1
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q) {
        // 将p和q归并到相同的分两种
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        if (sz[pRoot] < sz[qRoot]) {
            // 如果q树权重更大，就把p树链接到q树上
            // qRoot大树的根赋值给小树，就实现了小树转大树
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }
        else {
            id[qRoot] = id[pRoot];
            sz[pRoot] += sz[qRoot];
        }
//        id[pRoot] = qRoot;
        count--;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        UFQuickWeighting uf = new UFQuickWeighting(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            // 如果已经联通，则忽略
            if (uf.connected(p, q)) continue;
            // 归并分量
            uf.union(p, q);
            // 打印链接
            StdOut.println(p + " " + q);
            System.out.println(uf.count() + "components");

        }
        System.out.println(uf.count() + "components");
    }

}