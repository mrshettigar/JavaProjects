package isuniquestring;

import java.util.Scanner;

public class IsUniqueString {

    public static boolean isUniqueChars(String str){
        if(str.length() > 128) return false;
        
        boolean[] char_set = new boolean[128];
        for(int i=0; i< str.length();i++){
            int val = str.charAt(i);
            if(char_set[val]) { //already found this char in string
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }
    
    public static String sort(String s){
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }
    
    public static boolean checkPermutation(String str1, String str2) {
        if(str1.length()!= str2.length())
            return false;
        
        return sort(str1).equals(sort(str2));
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        String input1 = sc.next();
        String input2 = sc.next();
        System.out.println(" Permutation is "+checkPermutation(input1,input2));
//        System.out.println("The String is unique."+ isUniqueChars(input));
    }
    
}
