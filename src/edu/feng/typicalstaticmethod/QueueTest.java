package edu.feng.typicalstaticmethod;

import StdLib.StdIn;
import StdLib.StdOut;

/**
 * @Classname QueueTest
 * @Description TODO
 * @Date 2019-08-05 09:42
 * @Created by feng
 */
public class QueueTest {
    public static void main(String[] args) {
        Queue<String> q = new Queue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                q.enqueue(item);
            else if (!q.isEmpty())
                StdOut.print(q.dequeue() + " ");

        }
        StdOut.println("(" + q.size() + "left on queue");
    }
}
