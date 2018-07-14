/*
 * Copyright 2018 supermang.sh
 */
package generics;

/**
 *
 * @author Mangesh
 */
public class Generics{

    /**
     * @param args the command line arguments
     */
    
    public static <T extends Comparable<T>> T findMax(T a, T b){
        int n = a.compareTo(b);
        if(n < 0) { 
            return b;
        } else {
            return a;
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(findMax(2,3));
        System.out.println(findMax(3,3));
        System.out.println(findMax("Hello","There"));
        System.out.println(findMax("a","b"));
    }
    
}
