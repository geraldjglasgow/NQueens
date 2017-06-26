/**
 * Created by Gerald Glasgow on 6/22/17.
 *
 */

public class NQueens {

    private int count = 0;
    private int nodes = 0;

    /**
     * This method is called recursively to try to solve for all possible solutions for the
     * n-queens problem. If trying to place the queen in the nth+1 row, there must have been a solution and
     * so if needed the board solution will be printed and count incremented.
     * Else try to place the queen on the board in the specific row a.
     * @param board array of the current board
     * @param a row
     */
    public void solve(int[] board, int a){
        int n = board.length;
        if (a == n){            //if the board has been solved each recursive step will return 1 at a time and print the board
            if (count < 4){
                printQueens(board);
            }
            count++;
        }
        else {
            for (int i = 0; i < n; i++) { //else try to place the queen on the board
                nodes++;
                board[a] = i;
                if (canPlace(board, a)){  // check if placing the queen is valid
                    solve(board, a+1);    // if queen was placed without problem then move on to place the next queen recursively in the next row
                }
            }
        }
    }
    public void optimization1(int[] board, int a){
        int n = board.length;
        if (a == n){            //if the board has been solved each recursive step will return 1 at a time and print the board
            if (count < 4){
                printQueens(board);
            }
            count++;
        }
        else {
            for (int i = 0; i < n/2; i++) { //else try to place the queen on the board
                nodes++;
                board[a] = i;
                if (canPlace(board, a)){  // check if placing the queen is valid
                    solve(board, a+1);    // if queen was placed without problem then move on to place the next queen recursively in the next row
                }
            }
        }
    }
    public void optimization2(int[] board, int a){
        int n = board.length;
        if (a == n){            //if the board has been solved each recursive step will return 1 at a time and print the board
            if (count < 4){
                printQueens(board);
            }
            count++;
        }
        else {
            for (int i = 1; i < n/2; i++) { //else try to place the queen on the board
                nodes++;
                board[a] = i;
                if (canPlace(board, a)){  // check if placing the queen is valid
                    solve(board, a+1);    // if queen was placed without problem then move on to place the next queen recursively in the next row
                }
            }
        }
    }

    /**
     * can Place determines if a queen can be placed legally
     * @param board current board
     * @param a current row
     * @return
     */
    public boolean canPlace(int[] board, int a) {
        for (int i = 0; i < a; i++) { // for checking of placement if valid (when a=0 just returns true
            if (board[i] == board[a]){ // same column
                return false;
            }
            if(Math.abs(board[i] - board[a]) == Math.abs((a - i))){ // from the book to check if on same diagonal
                return false;
            }
        }
        return true;
    }

    /**
     * prints the board of queens
     * @param board board with solution
     */

    public void printQueens(int[] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) { // each row of the board
            for (int k = 0; k < n; k++) { // for each column of the board
                if (board[i] == k) System.out.print(" 1 "); // if the queen was placed print 1
                else           System.out.print(" 0 ");     // if no queen was placed print 0
            }
            System.out.println(); // new row
        }
        System.out.println(); // end of printing
    }
    /**
     * sets count (used for initialization)
     * @param n sets count = n
     */
    public void setCount(int n){
        this.count = n;
    }
    public void setNodes(int n){
        this.nodes = n;
    }
    /**
     * for obtaining the value of count
     * @return count
     */
    public int getCount(){
        return count;
    }
    public int getNodes(){
        return nodes;
    }
}