package edu.feng.typicalstaticmethod;

import java.util.Iterator;

/**
 * @Classname Stack
 * @Description TODO
 * @Date 2019-08-05 09:23
 * @Created by feng
 */
public class Stack<Item> implements Iterable<Item> {
    private Node first;     // 栈顶
    private int N;
    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    // 向栈顶添加元素
    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();;
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    // 栈顶删除
    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
