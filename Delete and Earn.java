class Solution {
    public int deleteAndEarn(int[] nums) {
        int count[] = new int[10001];
        for(int n : nums)
            count[n] += n;
        
        int dp[] = new int[10003];
        for(int i = 10000; i>=0; i--)
        {
            dp[i] = Math.max(count[i]+dp[i+2], dp[i+1]);
        }
        return dp[0];
    }
}


/* Approach: Here, the solution will make a count[] to keep track of all the elements in a sorted order. 
   At each index of count[] it will add the total sum of number = index. The equation here will find the max of two values.
   Value1 is calculated using count[i]+dp[i+2] i.e. it at index i it will consider the number itself and will ignore the next sequencial number
   of it and will add to the dp[i+2]. Value2 is calculated by not considering the number itself and so we can consider the next max sum till the consecutive number
   of it. 

*/
