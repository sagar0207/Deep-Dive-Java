class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] start = new int[n];
        int[] after_buy = new int[n];
        int[] after_sell = new int[n];
        
        Arrays.fill(start, 0);
        Arrays.fill(after_buy, 0);
        Arrays.fill(after_sell, 0);
        
        if(n<=1)
            return 0;
        else
        {
            start[0] = 0;
            after_buy[0] = -prices[0];
            after_sell[0] = 0;
            for(int i = 1; i<n; i++)
            {
                start[i] = Math.max(start[i-1], after_sell[i-1]);
                after_buy[i] = Math.max(after_buy[i-1], start[i-1] - prices[i]);
                after_sell[i] = after_buy[i-1] + prices[i];
            }
        }
        return Math.max(start[n-1], after_sell[n-1]);
    }
}
