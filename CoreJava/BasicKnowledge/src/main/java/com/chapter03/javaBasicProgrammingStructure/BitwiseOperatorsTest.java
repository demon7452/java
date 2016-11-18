package com.chapter03.javaBasicProgrammingStructure;

/**
 * Description: bitwise operators 位运算符
 * Created by lixiong on 2016/11/17.
 */
public class BitwiseOperatorsTest {
    public static void main(String[] args){
        int a = 1;
        int b = 0;
        // 与运算 &
        System.out.println("& ： " + (a&b));

        // 或运算 |
        System.out.println("| ： " + (a|b));

        // 异或运算 ^
        System.out.println("^ ： " + (a^b));

        // 非运算 ~
        System.out.println("^ ： " + (~a));

        // 右移操作 >>
        System.out.println(">> ： " + (4>>2));


        // 用0填充高位 >>>   等同于 右移操作
        System.out.println(">>> ： " + (4>>>2));

        // 左移操作 <<
        System.out.println("<< ： " + (1<<2));

        // 没有 <<< 运算符
    }
}
