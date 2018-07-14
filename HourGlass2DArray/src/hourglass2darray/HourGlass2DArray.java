package hourglass2darray;

import java.util.Scanner;

public class HourGlass2DArray {

    private static final int _MAX = 6; //size of matrix
    private static final int _OFFSET = 2; //hourglass width
    private static int matrix[][] = new int[_MAX][_MAX];
    private static int maxHourglass = -63; //initialize to lowest possible sum (-9x7)
    
    /** Given a starting index for an hourglass, sets maxHourglass
     *  @param i row
     *  @param j column
     * 
     **/
    
    private static void hourglass(int i, int j){
        int tmp = 0; //current hourglass sum
        for(int k = j; k<=j + _OFFSET; k++){
            tmp += matrix[i][k]; //top3 elements
            tmp += matrix[i +_OFFSET][k]; //bottom 3 elements
        }
        tmp += matrix[i+1][j+1]; //middle element
        
        if(maxHourglass < tmp) {
            maxHourglass = tmp;
        }
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        //read inputs
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i< _MAX; i++){
            for(int j=0; j< _MAX; j++){
                matrix[i][j] = scan.nextInt();
            }
        }
        scan.close();
        
        // find maximum hourglass
        for(int i =0; i< _MAX - _OFFSET; i++){
            for(int j=0; j < _MAX - _OFFSET; j++){
                hourglass(i,j);
            }
        }
        
        //print maximum hourglass
        System.out.println(maxHourglass);
    }
    
}
