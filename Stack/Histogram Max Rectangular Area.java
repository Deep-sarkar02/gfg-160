You are given a histogram represented by an array arr, where each element of the array denotes the height of the bars in the histogram. All bars have the same width of 1 unit.

Your task is to find the largest rectangular area possible in the given histogram, where the rectangle can be formed using a number of contiguous bars.

Examples:

Input: arr[] = [60, 20, 50, 40, 10, 50, 60]
 Largest-Rectangular-Area-in-a-Histogram
Output: 100
Explanation: We get the maximum by picking bars highlighted above in green (50, and 60). The area is computed (smallest height) * (no. of the picked bars) = 50 * 2 = 100.
Input: arr[] = [3, 5, 1, 7, 5, 9]
Output: 15
Explanation:  We get the maximum by picking bars 7, 5 and 9. The area is computed (smallest height) * (no. of the picked bars) = 5 * 3 = 15.
Input: arr[] = [3]
Output: 3
Explanation: In this example the largest area would be 3 of height 3 and width 1.
Constraints:
1 ≤ arr.size() ≤ 105
0 ≤ arr[i] ≤ 104

class Solution {
    public static int getMaxArea(int arr[]) {
        // your code here
        // here we need to find the next smaller for the left and the next smaller for the right of the element
        int [] nsl = new int[arr.length];
        int [] nsr = new int [arr.length];
        int MaxA = 0;
        // for the ngr
        Stack<Integer> st = new Stack<>();
        for (int i = arr.length-1 ; i>=0; i-- )
        {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i])
            {
                // pop
                st.pop();
            }
            // if the stack is empty
            if(st.isEmpty())
            {
                nsr[i] = arr.length;
            }
            else
            {
                nsr[i] = st.peek();
            }
            // push for all the case
            st.push(i);
        }
        // for the nsl
        //reset the stack
        st = new Stack<>();
        for (int i = 0 ; i<arr.length; i++ )
        {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i])
            {
                // pop
                st.pop();
            }
            // if the stack is empty
            if(st.isEmpty())
            {
                nsl[i] = -1;
            }
            else
            {
                nsl[i] = st.peek();
            }
            // push for all the case
            st.push(i);
        }
        
        // now form the area
        for(int i = 0 ; i< arr.length ; i++)
        {
            int w = nsr[i] - nsl[i] -1;
            int h = arr[i];
            int ar = w *h ;
            MaxA = Math.max(MaxA , ar);
            
        }
        return MaxA;
        
    }
}
