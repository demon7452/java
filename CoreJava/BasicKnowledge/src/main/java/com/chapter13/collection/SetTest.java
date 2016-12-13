package com.chapter13.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Description: set
 * Created by lixiong on 2016/11/16.
 */
public class SetTest {
    public static void main(String[] args){
        String text = "this is a set test!";
        char[] characters = text.toCharArray();
        Set<String> stringSet = new HashSet<>();
        for(char character : characters){
            stringSet.add(String.valueOf(character));
        }
        Iterator<String> iterator = stringSet.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next());
        }

        Person a = new Person(1,"test");
        Person b = new Person(2,"test");
        System.out.println(a.hashCode() + "  : " + b.hashCode());
        Set<Person> personSet = new HashSet<>();
        personSet.add(a);
        personSet.add(b);
        System.out.print("over");
    }

    private static  class Person{
        private int key;

        private String name;

        private Person(int key,String name){
            this.key = key;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person)) return false;

            Person person = (Person) o;

//            if (key != person.key)
//                return false;
            return name.equals(person.name);

        }

        @Override
        public int hashCode() {
            return key + name.hashCode();
        }
    }
}
