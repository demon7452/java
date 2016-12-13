package com.chapter13.collection;

import com.chapter05.abstractClass.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Description: map test
 * Created by lixiong on 2016/12/8.
 */
public class MapTest {
    public static void main(String[] args){
        Map<Integer,Employee> map = new HashMap<>();
        map.put(1,new Employee("one"));
        map.put(2,new Employee("two"));
        map.put(3,new Employee("three"));
        map.put(4,new Employee("four"));

        Set<Integer> set = map.keySet();
        set.remove(1);
        for(Integer key : set){
            System.out.println(map.get(key).getDescription());
        }

        Collection<Employee> employees = map.values();
        employees.remove(new Employee("three"));

        Set<Map.Entry<Integer,Employee>> sets= map.entrySet();
        for(Map.Entry<Integer,Employee> entry : sets){
            System.out.println(entry.getValue().getDescription());
        }
    }
}
