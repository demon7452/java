package com.chapter13.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description: shuffle 混乱排序
 * Created by lixiong on 2016/12/16.
 */
public class ShuffleTest {
    public static void main(String[] args){
        List<Integer> members = new ArrayList<>();
        for(int i = 0;i < 10; i++){
            members.add(i);
        }
        Collections.shuffle(members);//混排
        List<Integer> sub = members.subList(0,6);
        System.out.println(sub);
        Collections.sort(sub);//升序
        System.out.println(sub);
        Collections.sort(sub,Collections.reverseOrder());//逆转排序
        System.out.println(sub);
        Collections.reverse(sub);
        System.out.println(sub);
    }
}
