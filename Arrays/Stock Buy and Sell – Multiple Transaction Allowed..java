

// User function Template for Java
class Solution {
    public int maximumProfit(int p[]) {
        int sum=0;
        int b=0;
        for(int i=0 ; i<p.length-1; i++)
        {
            if(p[i]>p[i+1])
            {
                sum += p[i]-p[b] ;
                b=i+1;
            }
        }
        sum += p[p.length-1]-p[b];
        return sum;
    }
}
