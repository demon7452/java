package com.chapter13.collection;

import java.util.ArrayList;
import java.util.Date;

/**
 * Description: view 视图测试
 * Created by lixiong on 2016/12/13.
 */
public class ViewTest {
    public static void main(String[] args){
        test1();
    }

    private static void test1(){
        //被检验视图
        ArrayList<String> strings = new ArrayList<>();
        ArrayList newString = strings;
        newString.add(new Date());//错误的add无法被检测到
        String date = (String) newString.get(0);//在这会抛出异常
        System.out.println(newString.iterator().next());
    }
}
