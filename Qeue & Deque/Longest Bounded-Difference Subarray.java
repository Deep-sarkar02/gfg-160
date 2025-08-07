Given an array of positive integers arr[] and a non-negative integer x, the task is to find the longest sub-array where the absolute difference between any two elements is not greater than x.
If multiple such subarrays exist, return the one that starts at the smallest index.

Examples: 

Input: arr[] = [8, 4, 2, 6, 7], x = 4 
Output: [4, 2, 6] 
Explanation: The sub-array described by index [1..3], i.e. [4, 2, 6] contains no such difference of two elements which is greater than 4.
Input: arr[] = [15, 10, 1, 2, 4, 7, 2], x = 5 
Output: [2, 4, 7, 2] 
Explanation: The sub-array described by indexes [3..6], i.e. [2, 4, 7, 2] contains no such difference of two elements which is greater than 5. 
Constraints:
1 <= arr.size() <= 105
1 <= arr[i] <= 109
0 <= x<= 109

class Solution {
    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        int s = 0 ,e = 0;
        int  maxlen = 0;
        int n = arr.length;
        int start = 0;
        // inserr the index to trhe queue
        Deque<Integer> mindq = new LinkedList<>();
        Deque<Integer> maxdq = new LinkedList<>();
        
        while(e<n)
        {
            
            // fidn the max and min by the deque
            while(!maxdq.isEmpty() && arr[e] > arr[maxdq.peekLast()])
            {
                // we will remove from the lasr
                maxdq.pollLast();
            }
            // insert from the last and remove all the element
            maxdq.offerLast(e);
            while(!mindq.isEmpty() && arr[e] < arr[mindq.peekLast()])
            {
                // we will remove from the lasr
                mindq.pollLast();
            }
            // insert from the last and remove all the element
            mindq.offerLast(e);
            
            
            int max = arr[maxdq.peekFirst()];
            int min = arr[mindq.peekFirst()];
            // while max - min >x
            // increse the start
            while(max - min >x)
            {
                // pop the element which are not in  the valid windoe
                if(mindq.peekFirst() == s)mindq.pollFirst();
                if(maxdq.peekFirst() == s)maxdq.pollFirst();
                // icrese the start
                s++;
                
                // update the new min and max
                if(!maxdq.isEmpty())max = arr[maxdq.peekFirst()];
                if(!mindq.isEmpty())min = arr[mindq.peekFirst()];
            }
            
          
                
                // store the max length
                if(e-s+1 > maxlen)
                {
                    maxlen = e-s+1;
                    start = s;
                    // clear the prev result for every new greater lenght
                    
                }
                // now end ++
                e++;
            
            
        }
        // make the res
                    for(int i = start ; i<start+maxlen ; i++)
                    {
                        res.add(arr[i]);
                    }
        return res; 
        
    
    }
}
