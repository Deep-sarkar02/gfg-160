Given an incomplete Sudoku configuration in terms of a 9x9  2-D interger square matrix, mat[][], the task is to solve the Sudoku. It is guaranteed that the input Sudoku will have exactly one solution.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Note: Zeros represent blanks to be filled with numbers 1-9, while non-zero cells are fixed and cannot be changed.

Examples:

Input: mat[][] = 

Output:

Explanation: Each row, column and 3 x 3 box of the output matrix contains unique numbers.
Input: mat[][] = 

Output:

Explanation: Each row, column and 3 x 3 box of the output matrix contains unique numbers.
Constraints:
mat.size() = 9
mat[i].size() = 9
0 ≤ mat[i][j] ≤ 9

// User function Template for Java

class Solution {
    public boolean issafe(int [][] mat , int row ,int col , int n)
    {
        // horizontal check
        for(int i = 0 ; i < 9 ; i++)
        {
            if(mat[row][i] == n)
            {
                return false;
            }
        }
        // vertical check
        for(int j = 0 ; j< 9 ; j++)
        {
            if(mat[j] [ col ] == n)
            {
                return false;
            }
        }
        
        // grid check
        int startrow = (row /3)*3;
        int startcol = (col/3) *3;
        
        for (int i = startrow  ; i<= startrow+2 ; i++)
        {
            for(int j = startcol ; j<= startcol+2 ; j++)
            {
                if(mat[i][j] == n)
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean helper(int [][]mat , int row , int col)
    {
        // base case
        if(row == 9)// if all the row will be checked
        {
            return true;
        }
        
        
        
        // esle
        // next row and next col
        // start the call from the com +1
        int nextrow = row;
        int nextcol = col+1;
        
        if(nextcol == 9)
        {
            // reset
            nextrow = row +1;
            nextcol = 0;
        }
        // now if the element id not 0 then 
        if(mat[row][col] != 0)
        {
            // then we can  call for the next 
             return helper(mat , nextrow , nextcol);
        }
        
        // place the digit
        // run a loop from 0 to 9
        for(int i = 1 ;i<=9 ; i++)
        {
            if(issafe(mat , row , col , i))
            {
                // place the value
                mat[row][col] = i;
                //call the next
                if(helper(mat , nextrow , nextcol))
                {
                    return true;
                }
                // backtrack
                mat[row][col] = 0;
            }
        }
        return false;
    }
    
    
    // Function to find a solved Sudoku.
    public  void solveSudoku(int[][] mat) {
        
        
        // code here
        // call the helper function
        helper(mat , 0 , 0 );
        
    }
}
