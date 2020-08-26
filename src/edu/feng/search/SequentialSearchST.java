package edu.feng.search;

import StdLib.StdIn;
import StdLib.StdOut;
import edu.feng.typicalstaticmethod.Queue;

import java.util.Scanner;
//import edu.princeton.cs.algs4.*;

/**
 * @Classname SequentialSearchST
 * @Description TODO
 * @Date 2019-08-13 09:13
 * @Created by feng
 * 顺序查找（基于无序链表）P237
 */
public class SequentialSearchST<Key, Value> {
    private int N;
    private Node first;

    private class Node {
        // 链表节点定义
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) {
        // 给定要查找的减返回相关的值
        for (Node x = first; x != null; x = x.next) {
            // 命中
            if (key.equals(x.key))
                return x.val;
        }
        return null;
    }

    public void put(Key key, Value val) {
        if (val == null) {
            delete(key);
            return;
        }
        // 查找给定的键，找到就更新值，找不到就在表中新建节点
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        N++;
    }

    public void delete(Key key) {
        first = delete(first, key);
    }

    private Node delete(Node first, Key key) {
        if (first == null) return null;
        if (key.equals(first.key)){
            N--;
            return first.next;
        }
        first.next = delete(first.next, key);
        return first;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
    }

    public static void main(String[] args) {
        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
        Scanner in = new Scanner(System.in);
        for (int i = 0; !in.hasNext("#"); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }

}
