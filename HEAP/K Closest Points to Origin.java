Given an array of points where each point is represented as points[i] = [xi, yi] on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance, defined as: 

sqrt( (x2 - x1)2 + (y2 - y1)2 )

Note: You can return the k closest points in any order, driver code will sort them before printing.

Examples:

Input: k = 2, points[] = [[1, 3], [-2, 2], [5, 8], [0, 1]]
Output: [[-2, 2], [0, 1]]
Explanation: The Euclidean distances from the origin are:
Point (1, 3) = sqrt(10)
Point (-2, 2) = sqrt(8)
Point (5, 8) = sqrt(89)
Point (0, 1) = sqrt(1)
The two closest points to the origin are [-2, 2] and [0, 1].
Input: k = 1, points = [[2, 4], [-1, -1], [0, 0]]
Output: [[0, 0]]
Explanation: The Euclidean distances from the origin are:
Point (2, 4) = sqrt(20)
Point (-1, -1) = sqrt(2)
Point (0, 0) = sqrt(0)
The closest point to origin is (0, 0).
Constraints:

1 <= k <= points.size() <= 105
-104 <= xi, yi <= 104


class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Your code here
        // create the proirity queue
        PriorityQueue<int[]>pq = new PriorityQueue<>((a , b)->Integer.compare(b[0] , a[0]));
        // now we will calculate the distance , and then put it to the heap or the pq
        
        for(int i = 0 ; i<points.length ; i++)
        {
            
            // now find the distance
            int dist = (points[i][0]*points[i][0]) +  (points[i][1]*points[i][1]);
            // now put the dist in the heap
            pq.add(new int[]{dist , i});
            // check if pq is >k
            if(pq.size()>k)
            {
                pq.poll();
            }
            
            
        }
        // foe the ans array
        // row will be the no. of values
        // and colm will be always 2
        int[][] ans= new int[k][2];
        int index = 0;
        while(!pq.isEmpty())
        {
            ans[index]=points[pq.poll()[1]];
            index++;
        }
        return ans;
    }
}
