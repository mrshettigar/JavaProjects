package greatestcommondivisor;
import java.util.Scanner;
/**
 *
 * @author Mangesh
 */
public class GreatestCommonDivisor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Create Scanner
        Scanner input = new Scanner(System.in);
        
        //Prompt the user to enter two integers
        System.out.print("Enter first integer: ");
        int n1 = input.nextInt();
        System.out.print("Enter second integer: ");
        int n2 = input.nextInt();
        
        int gcd = 1;
        int k = 2;
        while (k <=n1 && k <= n2){
            if(n1 % k == 0 && n2 % k == 0)
                gcd = k;
            k++;
        }
        
        System.out.println("The greatest common divisior is " +gcd);
    }
    
}
