package conversion;

/**
 *
 * @author Mangesh
 */
public class Distance {
    
    
    public Distance() {
    }    
    
    public static double footToMeter (double newFoot) {
        double foot = newFoot;
        return (0.305 * foot);
    }
    
    public static double meterToFoot (double newMeter) {
        double meter = newMeter;
        return (3.279 * meter);
    }
    
}
