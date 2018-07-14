package conversion;
/**
 *
 * @author Mangesh
 */
public class Conversion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Feet\t\tMeters\t\t|\t\tMeters\t\tFeet");
        System.out.println("-------------------------------------------------------------------------");
        Distance D = new Distance();
        for(int i = 1, j = 20; i <= 10 ; i++, j+=5 )
        {
            System.out.println((double)i + "\t\t" + D.footToMeter(i) + "\t\t|\t\t" + (double)j + "\t\t" + D.meterToFoot(j) );
            
        }
        
        
    }
    
}


