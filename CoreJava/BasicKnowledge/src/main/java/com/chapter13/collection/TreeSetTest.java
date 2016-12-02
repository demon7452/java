package com.chapter13.collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Description: tree set test
 * Created by lixiong on 2016/11/30.
 */
public class TreeSetTest {

    public static void main(String[] args){
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item(1234, "one"));
        parts.add(new Item(9876, "three"));
        parts.add(new Item(4567, "two"));
        printSet(parts);
        SortedSet<Item> sortByDescription = new TreeSet<>(
            new Comparator<Item>() {
                @Override
                public int compare(Item o1, Item o2) {
                    return o1.getDescription().compareTo(o2.getDescription());
                }
            }
        );
        sortByDescription.add(new Item(1234, "one"));
        sortByDescription.add(new Item(9876, "three"));
        sortByDescription.add(new Item(4567, "two"));
        printSet(sortByDescription);
    }

    private static void printSet(SortedSet<Item> treeSet){
        Iterator<Item> iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().getDescription());
        }
    }
}
class Item implements Comparable<Item>{
    private int partNumber;
    private String description;

    public Item(int partNumber, String description){
        this.partNumber = partNumber;
        this.description = description;
    }

    public int getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(int partNumber) {
        this.partNumber = partNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (partNumber != item.partNumber) return false;
        return description != null ? description.equals(item.description) : item.description == null;

    }

    @Override
    public int hashCode() {
        int result = partNumber;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Item o) {
        return partNumber - o.partNumber;
    }
}