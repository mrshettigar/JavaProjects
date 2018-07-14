package computeangles;

/**
 *
 * @author Mangesh
 */

import java.util.Scanner;

public class ComputeAngles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        
        //Promtp user to enter 3 points
        System.out.println("Enter three points (coordinates): ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double x3 = input.nextDouble();
        double y3 = input.nextDouble();
        
        //Compute the sides of the traingle
        double a = Math.sqrt((x2-x3)*(x2-x3)+(y2-y3)*(y2-y3));
        double b = Math.sqrt((x1-x3)*(x1-x3)+(y1-y3)*(y1-y3));
        double c = Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
        
        //Compute the angles 
        double A = Math.toDegrees(Math.acos(((a*a)-(b*b)-(c*c))/(-2*b*c)));
        double B = Math.toDegrees(Math.acos((-(a*a)+(b*b)-(c*c))/(-2*a*c)));
        double C = Math.toDegrees(Math.acos((-(a*a)-(b*b)+(c*c))/(-2*b*a)));
        
        System.out.println("The angles are : "+Math.round(A*100)/100.0 + "\t" +Math.round(B*100)/100.0 + "\t"+ Math.round(C*100)/100.0);
    }
    
}
