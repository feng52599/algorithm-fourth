package edu.feng.typicalstaticmethod;

import StdLib.StdIn;
import StdLib.StdOut;

/**
 * @Classname UF
 * @Description TODO
 * @Date 2019-08-05 10:11
 * @Created by feng
 * union-find的实现
 */
public class UF
{
    // 分量id 以触点作为索引
    private int[] id;
    // 分量数量
    private int count;

    public UF(int N) {
        // 初始化分量id数组
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {
        // 将p和q归并到相同的分两种
        int pID = find(p);
        int qID = find(q);
        // 如果p和q已经存在于相同的分量，则不必采取任何行动
        if (pID == qID) return;
        // 将p的分量重命名为q的名称
        for (int i = 0; i < id.length; i++)
            if (id[i] == pID)
                id[i] = qID;
        count--;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new UF(N);
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