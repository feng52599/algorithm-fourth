package edu.feng.sort;

/**
 * @Classname TopM
 * @Description TODO
 * @Date 2019-08-09 10:31
 * @Created by feng
 * 一个优先队列的用例
 */
//public class TopM {
//    public static void main(String[] args) {
//        // 打印输入流中最大的M行
//        int M = Integer.parseInt(args[0]);
//        MinPQ<Transaction> pq = new MinPQ<Transaction>(M+1);
//        while (StdIn.hasNextLine()){
//            // 为下一行的输入创建一个元素并放入优先队列中
//            pq.insert(new Transaction(StdIn.readLine()));
//            // 如果优先队列中存在M+1个元素则删除其中最小的元素
//            if (pq.size() > M)
//                pq.delMin();
//        }// 最大的M个元素都在优先队列中
//    }
//    Stack<Transaction> stack = new Stack<Transaction>();
//    while(!pq.isEmpty) stack.push(pq.delMin());
//    for(Transaction t : stack) StdOut.println(t);
//}
