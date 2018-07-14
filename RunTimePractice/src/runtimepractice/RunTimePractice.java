/*
 * Copyright 2018 supermang.sh
 */
package runtimepractice;

import java.util.HashMap;

/**
 *
 * @author Mangesh
 */
public class RunTimePractice {

    /**
     * @param args the command line arguments
     */
    
    public static int[] findNumOfRepititions(String s, char[] c){
        int[] sum = new int[c.length];
        for(int i =0; i<s.length(); i++) {
            for(int j =0; j < c.length; j++){
                if(s.charAt(i) == c[j]) {
                    sum[j] = sum[j] + 1;
                }
            }
        }
        return sum;
    }
    
    public static int[] findNumOfRepititionsv2(String s, char[] c){
        int[] sums = new int[c.length];
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<s.length(); i++) {
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i),1);
            } else {
                int sum = map.get(s.charAt(i));
                map.put(s.charAt(i),sum+1);
            }
        }
        return sums;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        long startTime = System.currentTimeMillis();
        //
        
        //
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Test: "+ duration + "ms");
    }
    
}
