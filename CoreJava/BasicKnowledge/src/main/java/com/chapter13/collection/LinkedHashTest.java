package com.chapter13.collection;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/**
 * Description: LinkedHashMap , LinkedHashSet test
 * Created by lixiong on 2016/12/13.
 */
public class LinkedHashTest {
    public static void main(String[] args){
        LinkedHashMap<Integer,String> map = new LinkedHashMap<>();
        map.put(1,"one");
        map.put(2,"two");
        map.put(4,"four");
        map.put(3,"three");
        Iterator iterator = map.values().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(map.get(2));
        Iterator iterator2 = map.values().iterator();
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }
        System.out.println("=============");
        // LinkedHashSet
        LinkedHashSet<Item2> set = new LinkedHashSet<>();

        set.add(new Item2(1,"one"));
        set.add(new Item2(1,"two"));
        set.add(new Item2(1,"three"));
        for (Item2 item2 : set){
            System.out.println(item2.getValue());
        }
        System.out.println(set.iterator().next().getValue());
        for (Item2 item2 : set){
            System.out.println(item2.getValue());
        }
    }
}
class Item2{
    private int key;
    private String value;
    Item2(int key, String value){
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item2 item = (Item2) o;

//            if (key != item.key) return false;
        return value != null ? value.equals(item.value) : item.value == null;
    }

    @Override
    public int hashCode() {
        int result = key;
//            result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}