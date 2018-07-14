/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meansd;
import java.util.Scanner;

/**Mangesh Shettigar
 *UFID - 1282 8064
 *Program to calculate mean and standard deviation 
 */
public class MeanSD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        // TODO code application logic here
      Scanner input = new Scanner(System.in);
		// Set mean and deviation to 0
                double mean = 0.0; 			
		double deviation = 0.0; 		
		double number;				
                
		// Ask the user to enter ten numbers
		System.out.print("Enter ten numbers: ");

		// Computing mean and standard deviation
		for (int i = 0; i < 10; i++) {
			number = input.nextDouble();
			mean += number;
			deviation += Math.pow(number, 2); 
		}
		deviation =  Math.sqrt((deviation - (Math.pow(mean, 2) / 10)) / (10 - 1));
		mean /= 10;

		// Display results
		System.out.println("The mean is " + mean);
		System.out.printf("The standard deviation is %.5f\n", deviation);
        
    }
    
}
