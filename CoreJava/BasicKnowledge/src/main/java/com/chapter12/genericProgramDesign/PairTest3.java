package com.chapter12.genericProgramDesign;

public class PairTest3 {

    public static void main(String[] args) {
        Manager ceo = new Manager("ceo");
        Manager cfo = new Manager("cfo");
        Pair<Manager> pairMan = new Pair<Manager>(ceo, cfo);
        printBuddies(pairMan);
        ceo.setBounds(100);
        cfo.setBounds(10);
        
        Manager[] managers = {ceo,cfo};
        Pair<Employee> result = new Pair<>();
        minMax(managers, result);
        System.out.println("min:"+result.getFirst().getName());
        System.out.println("max:"+result.getSecond().getName());
        
        maxMin(managers, result);
        System.out.println("min:"+result.getFirst().getName());
        System.out.println("max:"+result.getSecond().getName());
        
        PairAlg.swap(result);
        System.out.println("min:"+result.getFirst().getName());
        System.out.println("max:"+result.getSecond().getName());
    }
    
    private static void printBuddies(Pair<? extends Employee> pair){
        System.out.println("first:"+pair.getFirst().getName());
        System.out.println("second:"+pair.getSecond().getName());
    }
    
    private static void minMax(Manager[] managers,Pair<? super Manager> result){
        Manager min = managers[0];
        Manager max = managers[0];
        for(Manager manager : managers){
            if(min.getBounds() > manager.getBounds())
                min = manager;
            if(max.getBounds() < manager.getBounds())
                max = manager;
        }
        result.setFirst(min);
        result.setSecond(max);
    }
    
    private static void maxMin(Manager[] managers,Pair<? super Manager> result){
        minMax(managers, result);
        swapHelper(result);
    }
    
    private static <T> void swapHelper(Pair<T> result){
        T t = result.getFirst();
        result.setFirst(result.getSecond());
        result.setSecond(t);
    }

}
class PairAlg{
    public static boolean hasNull(Pair<?> pair){
        return pair.getFirst() == null || null == pair.getSecond();
    }
    
    public static void swap(Pair<?> pair){
        //error,must use help method
        //? t = pair.getFirst(); 
        swapHelper(pair);
    }
    
    private static <T> void swapHelper(Pair<T> pair){
        T t = pair.getFirst();
        pair.setFirst(pair.getSecond());
        pair.setSecond(t);
    }
}

class Employee{
    private String name;
    
    public Employee(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Manager extends Employee{
    private String secretary;
    
    private int bounds;
    public Manager(String name){
        super(name);
        this.bounds = 0;
    }
    
    public Manager(String name,String secretary){
        super(name);
        this.secretary = secretary;
        this.bounds = 0;
    }

    public String getSecretary() {
        return secretary;
    }

    public void setSecretary(String secretary) {
        this.secretary = secretary;
    }

    public int getBounds() {
        return bounds;
    }

    public void setBounds(int bounds) {
        this.bounds = bounds;
    }
}