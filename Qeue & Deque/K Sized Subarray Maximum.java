Given an array arr[] of positive integers and an integer k. You hvae to find the maximum value for each contiguous subarray of size k. The output should be an array of maximum values corresponding to each contiguous subarray.

Examples:

Input: arr[] = [1, 2, 3, 1, 4], k = 3
Output: [3, 3, 4] 
Explanation: 
1st contiguous subarray [1, 2, 3], max = 3
2nd contiguous subarray [2, 3, 1], max = 3
3rd contiguous subarray [3, 1, 4], max = 4
Input: arr[] = [8, 5, 10, 7, 9, 4, 15, 12], k = 4
Output: [10, 10, 10, 15, 15]
Explanation: 
1st contiguous subarray [8, 5, 10, 7], max = 10
2nd contiguous subarray [5, 10, 7, 9], max = 10
3rd contiguous subarray [10, 7, 9, 4], max = 10
4th contiguous subarray [7, 9, 4, 15], max = 15
5th contiguous subarray [9, 4, 15, 12], max = 15
Input: arr[] = [5, 1, 3, 4, 2], k = 1
Output: [5, 1, 3, 4, 2]
Explanation: When k = 1, each element in the array is its own subarray, so the output is simply the same array
Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ k ≤ arr.size()
0 ≤ arr[i] ≤ 109
class Solution {
    static ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        // code here
        // form a deque for the data storing
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        // loop over the k size for the 1st windoe
        for(int i = 0 ; i <k ; i++)
        {
            // check from the last
            // 
            while(!dq.isEmpty() && arr[dq.getLast()] <=  arr[i])
            {
                //System.out.println("in while");
                // pop from the deque
                dq.removeLast();
            }
            // after the loop push
            // from last
            dq.addLast(i);
            //System.out.println(dq);
        }
        
        // for the next windows
        for(int i = k ; i <arr.length ; i++)
        {
            // System.out.println("++++++++++++++++++++++++");
            // System.out.println("for i ="+i);
            // now store the front of thedeque to the ans
            ans.add(arr[dq.getFirst()]);
            // System.out.println("=========");
            // System.out.println(ans);
            // System.out.println("=========");
            
            // remove the elem which are not the part of the current windoe
            while(!dq.isEmpty() && dq.getFirst() <= i-k) // condition written in the copy
            {
                // pop from the dq
                // pop from the front 
                dq.removeFirst();
                //System.out.println("dq  is :-"+dq);
            }
            
            // same logic copied from the above to  push to the dq
            while(!dq.isEmpty() && arr[dq.getLast()] <= arr[i])
            {
                // pop
                // from the back
                dq.removeLast();
            }
            // now push to the dq from the last
            dq.add(i);
            //System.out.println("dq  is :-"+dq);
            //System.out.println("++++++++++++++++++++++++++");
            // add the first elem to the ans
        
            
        }
        // // add the first elem to the ans
        // ans.add(arr[dq.getFirst()]);
        // System.out.println("ans-"+ans);
        ans.add(arr[dq.getFirst()]);
        //System.out.println("ans-"+ans);
        

        
        
        return ans;
    }
}
