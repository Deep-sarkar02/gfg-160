Given a data stream arr[] where integers are read sequentially, the task is to determine the median of the elements encountered so far after each new integer is read.

There are two cases for median on the basis of data set size.

1. If the data set has an odd number then the middle one will be consider as median.
2. If the data set has an even number then there is no distinct middle value and the median will be the arithmetic mean of the two middle values.

Examples:

Input:  arr[] = [5, 15, 1, 3, 2, 8]
Output: [5.0, 10.0, 5.0, 4.0, 3.0, 4.0] 
Explanation: 
After reading 1st element of stream – 5 -> median = 5.0
After reading 2nd element of stream – 5, 15 -> median = (5+15)/2 = 10.0 
After reading 3rd element of stream – 5, 15, 1 -> median = 5.0
After reading 4th element of stream – 5, 15, 1, 3 ->  median = (3+5)/2 = 4.0
After reading 5th element of stream – 5, 15, 1, 3, 2 -> median = 3.0
After reading 6th element of stream – 5, 15, 1, 3, 2, 8 ->  median = (3+5)/2 = 4.0
Input: arr[] = [2, 2, 2, 2]
Output: [2.0, 2.0, 2.0, 2.0]
Explanation: 
After reading 1st element of stream – 2 -> median = 2.0
After reading 2nd element of stream – 2, 2 -> median = (2+2)/2 = 2.0
After reading 3rd element of stream – 2, 2, 2 -> median = 2.0
After reading 4th element of stream – 2, 2, 2, 2 ->  median = (2+2)/2 = 2.0
Constraints:
1 <= arr.size() <= 105
1 <= x <= 106

class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        // code here
        ArrayList<Double> a = new ArrayList<>();
        //create a max and a min heap
        PriorityQueue<Integer> min = new PriorityQueue<>();
        // max
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        // iteratre all the numbers in  the array
        // now decide where to put  the elem :- in the max  or in the min heap
        for (int i : arr)
        {
            if(max.isEmpty() || i<max.peek())
            {
                // put it in to max heap
                max.add(i);
                
            }
            else
            {
                min.add(i);
            }
            // we will balance the both the heap 
            // make sure that the gap will not more than +1 size 
            if(max.size() > min.size() +1)
            {
                min.add(max.poll()); // then weill add the top value to the min from the max
            }
            else if(min.size() >max.size() +1)
            {
                max.add(min.poll()); //  now we will push in to the max
            }
            // now we will take the top value of both the pq and then do the mean of the both 
            // if the size of the both pq are same
            if(max.size() == min.size())
            {
                // do the mean of both the top and push to the array\
                a.add((double)(max.peek() + min.peek())/2.0); // push the double format
                
            }// for the else case which have greater size that top will be pushed
            else if(max.size() > min.size())
            {
                a.add((double)max.peek());
            }
            else
            {
                a.add((double)min.peek());
            }
            
        }
        
        
        return a;
        
    }
}


