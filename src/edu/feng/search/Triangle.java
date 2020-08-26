package edu.feng.search;

/**
 * @Classname Triangle
 * @Description TODO
 * @Date 2019-09-10 15:03
 * @Created by feng
 */
public class Triangle {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int deep = 6; // 定义杨辉三角的深度
        int length = 10; // 定义每个数值的固定长度，以便使其对称
        String space = ""; // 定义一开始的空格长度，也就是每行开始的1之间的水平间隔
        for (int i = 0; i < length / 2; i++) { // 长度为数值长度的一半
            space = space + " ";
        }
        int[][] a = new int[deep][]; // 不规则定义二维数组
        for (int i = 0; i < deep; i++) { // 给每一行定义列的数量
            a[i] = new int[i + 1];
        }
        for (int i = 0; i < deep; i++) { // 两边全部设置为1
            a[i][0] = 1;
            a[i][a[i].length - 1] = 1;
        }
        for (int i = 2; i < deep; i++) { // 计算中央每一个位置的数值
            for (int j = 1; j < i; j++) {
                a[i][j] = a[i - 1][j] + a[i - 1][j - 1];
            }
        }

        for (int i = 0; i < deep; i++) { // 打印
            for (int space_number = 0; space_number < deep - i; space_number++) {
                System.out.print(space); // 输出每行起始的空格，使得符合三角模型
            }
            for (int j = 0; j < a[i].length; j++) {  //打印数值，这个数值是固定长度，所以要先转换成字符串
                String output = a[i][j] + "";  //将数值转换成字符串，以便求其长度
                int output_length = output.length();
                int add_space = (length - output_length) / 2;
                for (int n = 0; n < add_space; n++) {  //添加空格时，要左右添加，看起来更加美观，所以上面要除以2
                    output = " " + output + " ";
                }
                while (output.length() < deep) {  //因为是除以2，所以可能形成的字符串长度要比固定长度短，这里要添加回来，否则等行数增多以后，会造成很大的差距
                    output = output + " ";
                }
                System.out.print(output);    //上面是准备工作，这个是真实打印出来

            }
            System.out.println("");
        }

    }

}