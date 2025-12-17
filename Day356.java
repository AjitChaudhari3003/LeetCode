// 3573. Best Time to Buy and Sell Stock V
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given an integer array prices where prices[i] is the price of a stock in dollars on the ith day, and an integer k.

// You are allowed to make at most k transactions, where each transaction can be either of the following:

// Normal transaction: Buy on day i, then sell on a later day j where i < j. You profit prices[j] - prices[i].

// Short selling transaction: Sell on day i, then buy back on a later day j where i < j. You profit prices[i] - prices[j].

// Note that you must complete each transaction before starting another. Additionally, you can't buy or sell on the same day you are selling or buying back as part of a previous transaction.

// Return the maximum total profit you can earn by making at most k transactions.

 

// Example 1:

// Input: prices = [1,7,9,8,2], k = 2

// Output: 14

// Explanation:

// We can make $14 of profit through 2 transactions:
// A normal transaction: buy the stock on day 0 for $1 then sell it on day 2 for $9.
// A short selling transaction: sell the stock on day 3 for $8 then buy back on day 4 for $2.




class Solution {
    private long f(int i,int j, int k ,int prices[], long dp[][][]){
        if(k < 0)return 0;
        if(i == prices.length){
            if(j != 0)return Long.MIN_VALUE / 2;
            return 0;
        }
        if(dp[i][j][k] != -1)return dp[i][j][k];
        long  buy = Long.MIN_VALUE, sell = Long.MIN_VALUE, skip = Long.MIN_VALUE;
        if(j == 0){
            buy = -prices[i] + f(i+1,1,k,prices,dp);
            sell = prices[i] + f(i+1,2,k,prices,dp);  
        }else if(j == 1){
            sell  = prices[i] + f(i+1,0,k-1,prices,dp);
        }else{
            buy   = -prices[i] + f(i+1,0,k-1,prices,dp);
        }
        skip = f(i+1,j,k,prices,dp);
        return dp[i][j][k] = Math.max(Math.max(skip,buy),Math.max(sell,skip)); 
    }
    public long maximumProfit(int[] prices, int k) {
        long[][][] dp = new long[prices.length][3][k];
        for(int i = 0;i < prices.length ; ++i){
            for(int j = 0 ; j < 3 ; ++j){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return f(0,0,k-1,prices,dp);
    }
}
