package quadraticeq;
import java.util.Scanner;

/**
 *Program to find roots of quadratic equation
 * @author Mangesh
 */
public class QuadraticEq {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter values for a, b, c: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        
        //Find the value of (b^2 - 4ac)
        double discriminant = Math.pow(b,2) - 4.0 * a * c;
        
        if (discriminant > 0.0) //when discriminant is positive, calculate r1 and r2
        {
            double r1 = (-b + Math.sqrt(discriminant)) / (2 * a) ;
            double r2 = (-b - Math.sqrt(discriminant)) / (2 * a) ;
            System.out.println("The equation has two roots "+ (int)(r1 * 100)/100.0 + " and " + (int)(r2 * 100)/100.0);
        }
        else if (discriminant == 0.0) //when discriminant is zero, there is only one root, calculate r
        {
            double r = (-b / (2 * a));
            System.out.println("The equation has one root " + (int)(r * 100)/100.0);
        }
        else //when discriminant is negative, there are no real roots
            System.out.println("The equation has no real roots");
        
        
    }
    
}
