package summation;

/**
 *
 * @author Mangesh
 */
public class Summation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("i\t\t\tm(i)");
        System.out.println("-------------------------------------------------");
        for(int i = 1; i<=20; i++){
           System.out.print(i+"\t\t\t");
           System.out.printf("%.4f",sum(i));
           System.out.println();
        }
    }
    
    
    public static double sum(int n)
        {
            double m = 0;
            for(int i = 1; i<=n; i++)
                m += (double)i/(i+1);
            return m;
        }
}
