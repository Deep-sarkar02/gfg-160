The n-queens puzzle is the problem of placing n queens on a (n × n) chessboard such that no two queens can attack each other. Note that two queens attack each other if they are placed on the same row, the same column, or the same diagonal.

Given an integer n, find all distinct solutions to the n-queens puzzle.
You can return your answer in any order but each solution should represent a distinct board configuration of the queen placements, where the solutions are represented as permutations of [1, 2, 3, ..., n]. In this representation, the number in the ith position denotes the row in which the queen is placed in the ith column.
For eg. below figure represents a chessboard [3 1 4 2].



Examples:

Input: n = 1
Output: [1]
Explaination: Only one queen can be placed in the single cell available.
Input: n = 4
Output: [[2 4 1 3 ] [3 1 4 2 ]]
Explaination: There are 2 possible solutions for n = 4.
Input: n = 2
Output: []
Explaination: There are no possible solutions for n = 2.
// User function Template for Java

class Solution {
    
    // create the new arraylist
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here 
        // now the nqueen function will also return list of list
        // set up the matrix
        boolean [][] mat = new boolean[n][n];
        // start  with row 0
        // the given n
        solve(mat , 0 ,n , new ArrayList<>());
        return res;
                
        
    }
    
    public void solve(boolean [][] mat , int row , int n, ArrayList<Integer>chotoarr)
    {
        // base case
        if(row == n)
        {
            // we will append the curr choto array to the big arrau
            res.add(new ArrayList<>(chotoarr));
            return;
        }
        // else
        
        // now for breadth or the cols we will make the call
        for(int col = 0 ; col < n ; col++)
        {
            if(issafe(mat , row , col , n))
            {
                // if it is true then mark true
                mat[row][col] = true;
                // add the index to the small array
                chotoarr.add(col +1);
                // call for the next row
                solve(mat , row+1 , n , chotoarr);
                
                // backtrack
                mat[row][col] = false;
                
                // also remove  the eleme entrrerd in the arrya
                // we will pass the index 
                chotoarr.remove(chotoarr.size()-1);
            }
        }
    }
    public boolean issafe(boolean[][] mat , int row , int col , int n)
    {
        int r = row;
        int c = col;
        // check the upper 
        r = row;
        while(r >= 0)
        {
            if(mat[r][col] == true)
            {
                return false;
                
            }
            r --;
        }
        
        
        // chekc the upright
        r = row;
        c = col;
        while(r >= 0  && c <n)
        {
            if(mat[r][c] == true)
            {
                return false;
            }
            r --;
            c ++;
        }
        r = row;
        c = col;
        // for upleft
        while(r >= 0 && c >= 0)
        {
            if(mat[r][c] == true)
            {
                return false;
            }
            r --;
            c --;
        }
        return true;
    }
}
