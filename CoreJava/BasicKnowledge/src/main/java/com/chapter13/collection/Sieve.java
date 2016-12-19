package com.chapter13.collection;

import java.util.BitSet;

/**
 * Description: This program runs the Sieve Erathostenes benchmark. It computes all primes up to 200000;
 * 首先将所有位设置为‘开’的状态，将已知素数对应的倍数都设置为‘关’的状态，经过这个操作保留下来位就是素数
 * Created by lixiong on 2016/12/16.
 */
public class Sieve {
    public static void main(String[] args){
        int n = 10000;
        long start = System.currentTimeMillis();
        BitSet bitSet = new BitSet(n+1);
        int count = 0;
        int i;
        //首先将所有位设置为‘开’的状态
        for(i = 2; i <= n; i++){
            bitSet.set(i);
        }

        i = 2;
        while (i * i <= n){
            if(bitSet.get(i)){
                count++;
                System.out.print(i +"  ");

                //将已知素数对应的倍数都设置为‘关’的状态
                int k = i * i;// 比 i * i 小的数已经由小于i的素数校验过
                do{
                    bitSet.clear(k);
                    k += i;
                }while (k <= n);
            }
            i++;
        }

        while (i <= n){
            if(bitSet.get(i)){
                count++;
                System.out.print(i +"  ");
            }
            i++;
        }

        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println("count:"+count);
        System.out.println("consume time:"+(end - start) +" milliseconds");

    }
}
