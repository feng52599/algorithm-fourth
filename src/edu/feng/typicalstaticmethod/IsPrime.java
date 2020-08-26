package edu.feng.typicalstaticmethod;

/**
 * @Classname IsPrime 判断素数
 * @Description TODO
 * @Date 2019-07-31 08:46
 * @Created by feng
 */

/**
 * 判断素数算法：
 * 1、除了1和本省没有其他约数，遍历2开始的数证明都不能整除即可
 * 2、
 */
public class IsPrime {
    public static boolean isPrime(int N) {
        // 1 不是素数
        if (N < 2) return false;
        for (int i = 2; i * i <= N; i++) {
            if (N % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(119));
    }
}
