class Solution {
    public int maxProfit(int[] prices) {
        int curMin = prices[0];
        int maxProfit = 0;

        for(int i = 1; i < prices.length; i++) {
            int curProfit = prices[i] - curMin;
            if(curProfit > maxProfit) {
                maxProfit = curProfit;
            }

            if(prices[i] < curMin) {
                curMin = prices[i];
            }
        }
        

        return maxProfit;
    }
}