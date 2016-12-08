package com.chapter13.collection;

import java.util.*;

/**
 * Description: priority queue 优先级队列
 * Created by lixiong on 2016/12/5.
 */
public class PriorityQueueTest {
    public static void main(String[] args){
        PriorityQueue<GregorianCalendar> queue = new PriorityQueue<>(new Comparator<GregorianCalendar>() {
            @Override
            public int compare(GregorianCalendar o1, GregorianCalendar o2) {
                return o2.compareTo(o1);
            }
        });
        queue.add(new GregorianCalendar(2016, Calendar.FEBRUARY, 12));
        queue.add(new GregorianCalendar(2017, Calendar.APRIL, 23));
        queue.add(new GregorianCalendar(2015, Calendar.DECEMBER, 20));
        queue.add(new GregorianCalendar(2012, Calendar.OCTOBER, 22));
        Iterator<GregorianCalendar> iterator = queue.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().get(Calendar.YEAR));
        }
    }
}
