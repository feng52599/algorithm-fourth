package edu.feng.typicalstaticmethod;

import java.util.Iterator;

/**
 * @Classname Queue
 * @Description TODO
 * @Date 2019-08-05 09:31
 * @Created by feng
 */
public class Queue<Item> implements Iterable<Item> {
    // 指向最早添加的节点的链接
    private Node first;
    // 指向最近添加节点的链接
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        // 向表尾添加元素
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        // 必须要考虑空栈情况
        if (isEmpty()) first = last;
        else oldLast.next = last;
        N++;
    }

    public Item dequeue(){
       Item item = first.item;
       first = first.next;
       // 空栈时尾指针也要是null
       if (isEmpty()) last = null;
       N--;
       return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
