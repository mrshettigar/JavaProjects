package averagearray;
import java.util.Scanner;

/**
 *
 * @author Mangesh
 */
public class AverageArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Ask number of items in array from user, and then get input for each array from user
        Scanner input =  new Scanner(System.in);
        System.out.print("Enter number of items: ");
        int n = input.nextInt();
        int[] intArray = new int[n];
        double[] doubleArray = new double[n];
        
        System.out.print("Enter integer items: ");
        for(int i = 0; i<n; i++)
            intArray[i] = input.nextInt();
        
        System.out.print("Enter double items: ");
        for(int i = 0; i<n; i++)
            doubleArray[i] = input.nextDouble();
        
        System.out.println("The average of integer array is "+average(intArray));
        System.out.println("The average of double array is "+average(doubleArray));
        
    }
    
    //Method to calculate average of int array
    
    public static int average(int[] array){
        int sum = 0, average = 0;
        for(int i = 0; i < array.length; i++)
            sum += array[i];
        average = sum/array.length;           
        return average;
    }
    
    //Method to calculate average of double array
    
    public static double average(double[] array){
        double sum = 0, average = 0;
        for(int i = 0; i < array.length; i++)
            sum += array[i];
        average = sum/array.length;           
        return average;
    }
    
}
