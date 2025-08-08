Given an integer array arr[]. Find the number of triangles that can be formed with three different array elements as lengths of three sides of the triangle. A triangle with three given sides is only possible if sum of any two sides is always greater than the third side.

Examples:

Input: arr[] = [4, 6, 3, 7]
Output: 3
Explanation: There are three triangles possible [3, 4, 6], [4, 6, 7] and [3, 6, 7]. Note that [3, 4, 7] is not a possible triangle.  
Input: arr[] = [10, 21, 22, 100, 101, 200, 300]
Output: 6
Explanation: There can be 6 possible triangles: [10, 21, 22], [21, 100, 101], [22, 100, 101], [10, 100, 101], [100, 101, 200] and [101, 200, 300]
Input: arr[] = [1, 2, 3]
Output: 0
Explanation: No triangles are possible.
Constraints:
1 ≤ arr.size() ≤ 103
0 ≤ arr[i] ≤ 105



// User function Template for Java

class Solution {
    // Function to count the number of possible triangles.
    static int countTriangles(int arr[]) {
        // code here
        // first sort the array
        Arrays.sort(arr);
        int count = 0;
        // k will be at the last index and k val >=2 and k --
        for( int k = arr.length -1 ; k>=2 ; k-- )
        {
            // initialise the i and j 
            int i = 0;
            int j = k-1;
            // so manupulate the i and j
            while(i < j)
            {
                if(arr[i] + arr[j] > arr[k])
                {
                    count += j-i;
                    j--;
                }
                else
                {
                    i++;
                }
            }
        }
        return count;
    }
}
