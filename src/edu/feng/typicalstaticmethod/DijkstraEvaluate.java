package edu.feng.typicalstaticmethod;

import StdLib.StdIn;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.LinkedList;

/**
 * @Classname DijkstraEvaluate
 * @Description TODO
 * @Date 2019-07-31 15:16
 * @Created by feng
 * LinkedList 可替代Stack
 * Dijkstra算法测试通过字符串来计算值
 * 测试用例 ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) ;
 * 假设所有字符之间都用空格来表示，;用来结束字符串
 */
public class DijkstraEvaluate {
    public static void main(String[] args) {
        // ops存储操作符， vals存操作数
        LinkedList<String> ops = new LinkedList<String>();
        LinkedList<Double> vals = new LinkedList<Double>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("("))
                continue;
            else if (s.equals("+"))
                ops.push(s);
            else if (s.equals("-"))
                ops.push(s);
            else if (s.equals("*"))
                ops.push(s);
            else if (s.equals("/"))
                ops.push(s);
            else if (s.equals("sqrt"))
                ops.push(s);
            // 如果是） 操作符栈出栈一次，数值栈出栈两次
            else if (s.equals(")")){
                String op = ops.pop();
                // 在这里vals被出栈一次
                double v = vals.pop();
                // 在这里vals被出栈一次
                if (op.equals("+"))
                    v = vals.pop() + v;
                else if (op.equals("-"))
                    v = vals.pop() - v;
                else if (op.equals("*"))
                    v = vals.pop() * v;
                else if (op.equals("/"))
                    v = vals.pop() / v;
                else if (op.equals("sqrt"))
                    v = Math.sqrt(v);
                // 之后将结果入数值栈
                vals.push(v);
            }
            else if (s.equals(";"))
                break;
            // 如果不是运算符或者括号，就入double值栈
            else vals.push(Double.parseDouble(s));
        }
        System.out.println(vals.pop());
    }
}
