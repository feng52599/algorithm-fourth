package edu.feng.typicalstaticmethod;

/**
 * @Classname BinarySearch
 * @Description TODO
 * @Date 2019-07-31 09:20
 * @Created by feng
 * 二分查找，key查找数，a必须是已经排序的数组
 */
public class BinarySearchCopy1 {
    public static int rank(int key, int[] a) {
        int min = 0, max =  a.length - 1;

        while (min <= max) {
            int mid = (min + max)/2;
            if (a[mid] > key) {
                max = mid - 1;
            } else if (a[mid] < key) {
                min = mid + 1;
            } else return mid;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 7, 10, 11, 16, 19};
        System.out.println(rank(19, a));
    }
}
