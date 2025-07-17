You are given a two-dimensional mat[][] of size n*m containing English alphabets and a string word. Check if the word exists on the mat. The word can be constructed by using letters from adjacent cells, either horizontally or vertically. The same cell cannot be used more than once.

Examples :

Input: mat[][] = [['T', 'E', 'E'], ['S', 'G', 'K'], ['T', 'E', 'L']], word = "GEEK"
Output: true
Explanation:

The letter cells which are used to construct the "GEEK" are colored.
Input: mat[][] = [['T', 'E', 'U'], ['S', 'G', 'K'], ['T', 'E', 'L']], word = "GEEK"
Output: false
Explanation:

It is impossible to construct the string word from the mat using each cell only once.
Input: mat[][] = [['A', 'B', 'A'], ['B', 'A', 'B']], word = "AB"
Output: true
Explanation:

There are multiple ways to construct the word "AB".




class Solution {
    public boolean helper(String s , char[][] mat ,int i , int row , int col , boolean[][] visited)
    {
        // we have taken a visited array of boolean
        // base case
        if(i == s.length())
        {
            return true;
        }
        
        //boundary values
        if(row < 0  || col < 0 || row >= mat.length || col>= mat[0].length || mat[row][col] != s.charAt(i) || visited[row][col])   //last will check that if that valeu is already visited
        {
         return false;   
        }
        
        
        // recursion
        // mark visited
        visited[row][col] = true;
        
        // now explore 4 directions
        boolean found = helper(s , mat ,i+1 ,  row+1 , col , visited) ||
                        helper(s , mat ,i +1 , row-1 , col , visited) ||
                        helper(s , mat , i+1 , row , col+1 , visited)||
                        helper(s , mat ,i+1 ,  row , col-1 , visited);
                        
        // backtract
        visited[row][col] = false;
        // if not found
        return found;
    }
    public boolean isWordExist(char[][] mat, String word) {
        // Code here
        int row = mat.length;
        int col = mat[0] .length;
        
        // we will traverse through the matrix if if the 1st elem is there then we will call the recursion
        for(int i = 0 ; i< row ; i++)
        {
            for(int j = 0 ; j < col ; j++)
            {
                // check for the  first elem
                if(mat[i][j] == word.charAt(0))
                {
                    // form the matrix
                    boolean[][] visited = new boolean[row][col];
                    // call the recursion
                    // i and j are the row anc col
                    if(helper(word , mat , 0  , i , j , visited) )
                    {
                        return true;
                    }
                }
            }
        }
        // if nothing works
        
        return false;
        
        
    }
}  
