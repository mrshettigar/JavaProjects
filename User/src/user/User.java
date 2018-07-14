/*
 * Copyright 2018 supermang.sh
 */
package user;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Mangesh
 */
public class User {

    String username;
    String password;
    int age;
    Set<Integer> orderIDs;
    
    public User(String customUsername, String customPassword, int customAge, Set<Integer> orderIDs){
        this.username = customUsername;
        this.password = customPassword;
        this.age = customAge;
        this.orderIDs = orderIDs;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Set a = new HashSet();
        a.add(1212);
        User mangesh = new User("mongobyte", "HelloWorld", 20, a);
        
    }
    
}
