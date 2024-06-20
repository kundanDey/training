package dsa.dynamic.programming;

public class StockSellK {

    public int maxProfit(int k, int[] prices) {

        Integer dp[][] = new Integer[k+1][prices.length+1];

        if(k<1 || prices.length <= 1) return 0;

        return solve(prices,k,prices.length-1,dp);
    }

    public int solve(int[] prices, int k ,int i, Integer[][] dp){


        if(k <= 0 || i <= 0) return 0;

        if(dp[k][i] != null) return dp[k][i];

        int max = solve(prices,k,i-1,dp); // no transaction
        for(int m=0;m<i;m++){
            max = Math.max(max,prices[i]-prices[m]+solve(prices,k-1,m,dp));
        }

        dp[k][i] = max;
        //System.out.println(max);
        return max;
    }
}
