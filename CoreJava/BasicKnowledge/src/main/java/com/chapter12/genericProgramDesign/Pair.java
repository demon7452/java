package com.chapter12.genericProgramDesign;

/**
 * 
 * Function: Generic class test
 *
 * @author   lixiong
 * @Date	 2016年10月12日		下午2:32:52
 *
 * @see 	 @param <T>
 */
public class Pair<T> {
    private T first;
    private T second;
    
    public Pair (){
        
    }
    
    public Pair (T first, T second){
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
