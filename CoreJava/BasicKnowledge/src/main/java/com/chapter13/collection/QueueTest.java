package com.chapter13.collection;

import java.text.SimpleDateFormat;
import java.util.*;

public class QueueTest {

    public static void main(String[] args) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(format.format(gregorianCalendar.getTime()));
        gregorianCalendar.set(Calendar.DAY_OF_MONTH,0);
        System.out.println(format.format(gregorianCalendar.getTime()));
        gregorianCalendar.add(Calendar.MONTH,-1);
        System.out.println(format.format(gregorianCalendar.getTime()));
        gregorianCalendar.set(Calendar.DAY_OF_MONTH,1);
        System.out.println(format.format(gregorianCalendar.getTime()));
        gregorianCalendar.set(Calendar.DAY_OF_MONTH,0);
        System.out.println(format.format(gregorianCalendar.getTime()));

        Queue<String> queueList = new LinkedList<>();
        queueList.add("a");
        queueList.add("b");
        queueList.add("c");
        queueList.add("d");
        String teString = queueList.element();
//        for(String s : queueList){
//            queueList.remove(s);//will throw error
//        }
        Iterator<String> iterator = queueList.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            // without next() method,remove() method will throw exception
            iterator.remove();
        }
        

    }

}
