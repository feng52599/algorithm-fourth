package edu.feng.typicalstaticmethod;

import java.util.Iterator;

/**
 * @Classname ResizingArrayStack
 * @Description TODO
 * @Date 2019-08-05 08:45
 * @Created by feng
 * 下压（LiFo）栈（能够动态调整数组大小的实现） ⭐︎☆★★★
 */
public class ResizingArrayStack<Item> implements Iterable<Item>{
    // 栈元素 N 元素数量
    private Item[] a = (Item[]) new Object[1];
    private int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    // 将栈移动到一个大小为max的数组
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        // 数据更新
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        // 指向更新
        a = temp;
    }

    public void push(Item item) {
        if (N == a.length) resize(2 * a.length);
        a[N++] = item;
    }

    public Item pop() {
        Item item = a[--N];
        a[N] = null; // 避免对象游离
        if (N > 0 && N == a.length/4) resize(a.length/2);
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return (Iterator<Item>) new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterable<Item> {
        // 支持后进先出的迭代
        private int i = N;
        public boolean hasNext() {
            return i > 0;
        }
        public Item next() {
            return a[--i];
        }
        public void remove() {}

        @Override
        public Iterator<Item> iterator() {
            return null;
        }
    }

}
