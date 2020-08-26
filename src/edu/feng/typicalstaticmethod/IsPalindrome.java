package edu.feng.typicalstaticmethod;

/**
 * @Classname IsPalindrome
 * @Description TODO
 * @Date 2019-07-31 10:51
 * @Created by feng
 * 判断是否是回文
 */
public class IsPalindrome {
    public static boolean isPaindrome(String s) {
        int N = s.length();
        for (int i = 0; i < N; i++)
            if (s.charAt(i) != s.charAt(N - 1 - i))
                return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPaindrome("ollo"));
    }
}
