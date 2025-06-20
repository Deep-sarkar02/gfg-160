class Solution {
    public static int[] productExceptSelf(int arr[]) {
        // code here
        // prefix
        int[] pre = new int[arr.length];
        // suffix
        int[] suf = new int[arr.length];
        
        // for the prefix
        pre[0] = 1;
        // now form the prefix
        for(int i = 1 ;i < arr.length ; i++)
        {
            pre[i] = pre[i -1] * arr[i-1];
        }
        suf[arr.length - 1] = 1; // the last elem will be 1
        for(int i = arr.length-2 ; i>= 0 ; i--)
        {
            suf[i] = suf[i+1] * arr[i+1];
        }
        
        int[] ans = new int[arr.length];
        for(int i = 0 ; i< arr.length ; i++)
        {
            ans[i] = pre[i] * suf[i];
        }
        return ans;
    }
}
