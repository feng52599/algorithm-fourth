package edu.feng.typicalstaticmethod;

/**
 * @Classname IsSort
 * @Description TODO
 * @Date 2019-07-31 11:05
 * @Created by feng
 * 检查字母是否排序
 */
public class IsSort {
    public static boolean isSorted(String[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i-1].compareTo(a[i]) > 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a = {"a", "da"};
        System.out.println(isSorted(a));
    }
}
