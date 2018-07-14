package minimum;
import java.util.Scanner;
/**
 *
 * @author Mangesh
 */
public class Minimum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner input =  new Scanner(System.in);
        
        double[] doubleArray = new double[10];
        System.out.print("Enter 10 numbers : ");
        for(int i = 0; i<10; i++)
            doubleArray[i] = input.nextDouble();
        
        System.out.println("The minimum number is: "+min(doubleArray));
        
    }
    
    //Method to find minimum number from array
    public static double min(double[] array){
        double minimum = array[0];
        for(int i = 1; i<array.length; i++)
            if(array[i] < minimum)
                minimum =  array[i];
            
        return minimum;
    }
    
}
