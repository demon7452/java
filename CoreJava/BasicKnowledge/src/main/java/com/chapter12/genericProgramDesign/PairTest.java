package com.chapter12.genericProgramDesign;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.chapter05.abstractClass.Person;
import com.chapter05.abstractClass.Student;

/**
 * 
 * Function: Generic class test
 *
 * @author   lixiong
 * @Date	 2016年10月12日		下午2:33:58
 *
 * @see
 */
public class PairTest {

    public static void main(String[] args) {
        String[] arrStrings = {"b","bd","d","w","zafd","fb"};
        Pair<String> pair = ArrayAlg.minMax(arrStrings);
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());
        
        String middle = ArrayAlg.<String>getMiddle(arrStrings);
        ArrayAlg.<String>getMiddle(arrStrings);
        System.out.println(middle);
        testExtend();
        testSuper();
        testWildCard();
    }
    
    private static void  testExtend(){
        Pair<? extends Person> pair = new Pair<>();
        //success,will return a Person object
        pair.getFirst();
        //error,the parameter of set method can't be confirm
        //pair.setFirst(aStudent);
    }
    
    private static void testSuper(){
        Pair<? super Student> pair = new Pair<>();
        Student aStudent = new Student("a", 1);
        pair.setFirst(aStudent);
        //can not confirm the return object type of the get method.
        Object object = pair.getFirst();
        System.out.println(object);
    }
    
    private static void testWildCard(){
        GregorianCalendar[] calendars = new GregorianCalendar[3];
        calendars[0] = new GregorianCalendar(2016, Calendar.JANUARY, 1);
        calendars[1] = new GregorianCalendar(2016, Calendar.JANUARY, 2);
        calendars[2] = new GregorianCalendar(2016, Calendar.JANUARY, 3);
        //error,GregorianCalendar not implements Comparable
//        GregorianCalendar min = ArrayAlg.<GregorianCalendar>getMin(calendars);
        GregorianCalendar max = ArrayAlg.<GregorianCalendar>getMax(calendars);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(format.format(max.getTime()));
    }

}

class ArrayAlg{
    public static Pair<String> minMax(String[] arr){
        Pair<String> pair = new Pair<>();
        String min = arr[0];
        String max = arr[0];
        for(String e : arr){
            if(min.compareTo(e) > 0)
                min = e;
            if(max.compareTo(e) < 0)
                max = e;
        }
        pair.setFirst(min);
        pair.setSecond(max);
        return pair;
    }
    /**
     * generic method
     * 泛型方法
     * @param array
     * @return
     */
    public static <T> T getMiddle(T[] array){
        return array[array.length/2];
    }
    /**
     * 类型限定
     * @param array
     * @return
     */
    public static <T extends Comparable<T> & Serializable> T getMin(T[] array){
        if(null == array || 0 == array.length)
            return null;
        T min = array[0];
        for(T e : array){
            if(min.compareTo(e) > 0)
                min = e;
        }
        return min;
    }
    /**
     * 类型限定 -- 超类型
     * @param array
     * @return
     */
    public static <T extends Comparable<? super T>> T getMax(T[] array){
        if(null == array || 0 == array.length)
            return null;
        T max = array[0];
        for(T e : array){
            if(max.compareTo(e) < 0)
                max = e;
        }
        return max;
    }
    
    
}