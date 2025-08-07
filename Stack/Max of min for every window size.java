Given an array of integers arr[], the task is to find the maximum of the minimum values for every possible window size in the array, where the window size ranges from 1 to arr.size().

More formally, for each window size k, determine the smallest element in all windows of size k, and then find the largest value among these minimums where 1<=k<=arr.size().

Examples :

Input: arr[] = [10, 20, 30, 50, 10, 70, 30]
Output: [70, 30, 20, 10, 10, 10, 10] 
Explanation: 
1. First element in output indicates maximum of minimums of all windows of size 1. Minimums of windows of size 1 are [10], [20], [30], [50], [10], [70] and [30]. Maximum of these minimums is 70. 
2. Second element in output indicates maximum of minimums of all windows of size 2. Minimums of windows of size 2 are [10], [20], [30], [10], [10], and [30]. Maximum of these minimums is 30. 
3. Third element in output indicates maximum of minimums of all windows of size 3. Minimums of windows of size 3 are [10], [20], [10], [10] and [10]. Maximum of these minimums is 20. 
Similarly other elements of output are computed.
Input: arr[] = [10, 20, 30]
Output: [30, 20, 10]
Explanation: First element in output indicates maximum of minimums of all windows of size 1. Minimums of windows of size 1 are [10] , [20] , [30]. Maximum of these minimums are 30 and similarly other outputs can be computed
Constraints:
1 <= arr.size() <= 105
1 <= arr[i] <= 106



class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        // Your code here
        ArrayList<Integer> ar = new ArrayList<>();
        // for each of the elem we will find the prev smaller and the next smaller
        int nsl[] = new int[arr.length];
        int nsr[] = new int[arr.length];
        
        Stack<Integer> st = new Stack<>();
        // for the nsr
        for(int i = arr.length-1 ; i>=0 ; i--)
        {
            // while the stack is empty
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) // if the elem will be greater then pop
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                nsr[i] = arr.length;
            }
            else
            {
                nsr[i] = st.peek();
            }
            st.push(i);
        }
        
        
        // for the nsl
        st = new Stack<>();
        for(int i = 0 ; i<arr.length ; i++)
        {
            // while the stack is empty
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) // if the elem will be greater then pop
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                // if no smaller then add -1
                nsl[i] = -1;
            }
            else
            {
                nsl[i] = st.peek();
            }
            st.push(i);
        }
        // for the ans arrray 
        int ans[] = new int[arr.length];
        int index;
        for(int i = 0 ; i<arr.length ;i++)
        {
            // form the index
            index = nsr[i] - nsl[i] -1;
            if(arr[i] > ans[index-1])
            {
                // form the ans
                ans[index-1] = arr[i];
                //System.out.println(Arrays.toString(ans));
            }
        }
        
        int max = ans[arr.length-1];
        //now loop from the end -2  to 0
        for(int i =arr.length-2 ; i >=0 ; i-- )
        {
            // fidn the max
            max = Math.max(max , ans[i]);
            // and the max will be stored
            ans[i] = max;
        }
        //System.out.println(Arrays.toString(ans));
        //System.out.println(Arrays.toString(ans));
        //System.out.println(Arrays.toString(nsl));
        //System.out.println(Arrays.toString(nsr));
        
        // form the arraylist from the ans
        for(int t = 0 ; t<ans.length ;t++)
        {
            ar.add(ans[t]);
        }
        return ar;
        
    }
}
