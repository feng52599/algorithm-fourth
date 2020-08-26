package edu.feng.search;

/**
 * @Classname BST
 * @Description TODO
 * @Date 2019-08-19 10:30
 * @Created by feng
 * 基于二叉查找树的符号表
 */
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int N;

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            this.N = n;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if (root == null) return 0;
        else return root.N;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node root, Key key) {
        if (root == null) return null;
        int cmp = key.compareTo(root.key);
        if (cmp < 0) return get(root.left, key);
        else if (cmp > 0) return get(root.right, key);
        else return root.val;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node root, Key key, Value val) {
        // 如果key存在root为根节点紫薯中则更新他的值，
        // 否则将keyval为键值对的新节点插入到子树中
        if (root == null) return new Node(key, val, 1);
        int cmp = key.compareTo(root.key);
        if (cmp < 0) root.left = put(root.left, key, val);
        if (cmp > 0) root.right = put(root.right, key, val);
        else root.val = val;
        root.N = size(root.left) + size(root.right) + 1;
        return root;
    }

    // 最小值
    public Key min() {
        return min(root).key;
    }

    private Node min(Node root) {
        if (root.left == null) return root;
        return min(root.left);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;
        return root.key;
    }

    private Node floor(Node root, Key key) {
        if (root == null) return null;
        int cmp = key.compareTo(root.key);
        if (cmp == 0) return root;
        if (cmp < 0) return floor(root.left, key);
        Node t = floor(root.right, key);
        if (t != null) return t;
        else return root;
    }

}
