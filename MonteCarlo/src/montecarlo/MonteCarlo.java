package montecarlo;
/**
 *
 * @author Mangesh
 */
public class MonteCarlo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.printf("%3.2f", 1234.567);
        System.out.println("SELECT".substring(4, 4));
         System.out.printf("%5d", 123456);
        
        final int NUMBER_OF_TRIALS = 1000000;
        int numberOfHits = 0;
        for(int i=0; i < NUMBER_OF_TRIALS; i++){
            //Creating random coordinates for each trial
            double x = Math.random() * 2 - 1;
            double y = Math.random() * 2 - 1;
            if(x*x + y*y <= 1)
                numberOfHits++;    
        }
        
        double pi = 4.0 * numberOfHits / NUMBER_OF_TRIALS;
        System.out.println("PI is "+pi);
    }
    
}
