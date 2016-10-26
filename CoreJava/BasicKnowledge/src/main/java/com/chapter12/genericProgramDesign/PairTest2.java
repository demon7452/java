package com.chapter12.genericProgramDesign;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class PairTest2 {

    public static void main(String[] args) {
        GregorianCalendar[] calendars = new GregorianCalendar[3];
        calendars[0] = new GregorianCalendar(2016, Calendar.JANUARY, 1);
        calendars[1] = new GregorianCalendar(2016, Calendar.JANUARY, 2);
        calendars[2] = new GregorianCalendar(2016, Calendar.JANUARY, 3);

        Pair<GregorianCalendar> pair = ArrayAlg2.getMinMax(calendars);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(format.format(pair.getFirst().getTime()));
        System.out.println(format.format(pair.getSecond().getTime()));
    }

}
class ArrayAlg2{
    public static <T extends Comparable> Pair<T> getMinMax(T[] array){
        Pair<T> pair = new Pair<>();
        T min = array[0];
        T max = array[0];
        for(T e : array){
            if(min.compareTo(e) > 0)
                min = e;
            if(max.compareTo(e) < 0)
                max = e;
        }
        pair.setFirst(min);
        pair.setSecond(max);
        return pair;
    }
    
    public static <T extends Comparable<T>> Pair<T> getMinMax2(T[] array){
        return new Pair<>();
    }
    
    public static <T extends Comparable<? super T>> Pair<T> getMinMax3(T[] array){
        return new Pair<>();
    }
}