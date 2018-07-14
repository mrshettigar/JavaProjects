package javatest;
import java.util.Scanner;

public class JavaTest {
    
    public static void main(String[] args) {
        // TODO code application logic here
Scanner input = new Scanner(System.in);

    System.out.print("Enter an integer: ");

    int number = input.nextInt();  

 

    int i;

 

    boolean isPrime = true;

    for (i = 2; i < number && isPrime; i++) {

      if (number % i == 0) {

        isPrime = false;

      }

    }

 

    System.out.println("i is " + i);

 

    if (isPrime)

      System.out.println(number + " is prime");

    else

      System.out.println(number + " is not prime");  
    }
}
