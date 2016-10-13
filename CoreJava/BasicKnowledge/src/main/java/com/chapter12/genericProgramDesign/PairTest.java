package com.chapter12.genericProgramDesign;
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
        
        String middle = ArrayAlg.getMiddle(arrStrings);
        System.out.println(middle);
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
    
    public static <T> T getMiddle(T[] array){
        return array[array.length/2];
    }
}