/**
 * Created by Gerald Glasgow on 6/22/17.
 *
 */

public class Main {
    /**
     * Main method runs the NQueens class to solve n-queens problem for specific n values
     * @param args
     */
    public static void main(String[] args) {
        NQueens queen = new NQueens();
        int []n = {4,5,8,9,10};
        int i=0;
        while(i<n.length){
            queen.setCount(0); //resets number of solutions to 0
            queen.solve(new int[n[i]], 0);
            System.out.println("Number of Solutions for N = " + n[i] + " is " + queen.getCount()); //prints number of solutions found
            System.out.println();
            i++;
        }
    }
}
