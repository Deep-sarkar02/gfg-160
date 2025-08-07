Difficulty: MediumAccuracy: 53.56%Submissions: 194K+Points: 4
Given an array arr[] of positive integers and an integer k, Your task is to return k largest elements in decreasing order. 

Examples:

Input: arr[] = [12, 5, 787, 1, 23], k = 2
Output: [787, 23]
Explanation: 1st largest element in the array is 787 and second largest is 23.
Input: arr[] = [1, 23, 12, 9, 30, 2, 50], k = 3 
Output: [50, 30, 23]
Explanation: Three Largest elements in the array are 50, 30 and 23.
Input: arr[] = [12, 23], k = 1
Output: [23]
Explanation: 1st Largest element in the array is 23.
Constraints:
1 ≤ k ≤ arr.size() ≤ 106
1 ≤ arr[i] ≤ 106



class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        // Your code here
        // create a new arralist
        ArrayList<Integer> a = new ArrayList<>();
        // first sort the given array
        Arrays.sort(arr);
        int c = 0;
        // now we will loop from the back to the from 
        for(int i = arr.length-1 ; i>=0 ; i--)
        {
            if(c == k) break;
            a.add(arr[i]);
            c++;
        }
        return a;
    }
}
