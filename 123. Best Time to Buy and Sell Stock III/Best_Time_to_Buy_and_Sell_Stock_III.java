class Best_Time_to_Buy_and_Sell_Stock_III {
     public int maxProfit(int[] prices) {

    //     int t1Cost = Integer.MAX_VALUE, t2Cost = Integer.MAX_VALUE;
    //     int t1Profit = 0, t2Profit = 0;

    // for (int price : prices) {
    //     // the maximum profit if only one transaction is allowed
    //     t1Cost = Math.min(t1Cost, price);
    //     t1Profit = Math.max(t1Profit, price - t1Cost);
    //     // re-invest the gained profit in the second transaction
    //     t2Cost = Math.min(t2Cost, price - t1Profit);
    //     t2Profit = Math.max(t2Profit, price - t2Cost);

    //     System.out.println("t1cost =" + t1Cost+ "\tt1Profit =" + t1Profit + "\tt2cost =" + t2Cost+ "\tt2Profit =" + t2Profit);
    // }

    // return t2Profit;
        int n = prices.length;
        int[][] ahead = new int[2][3];
        int[][] curr = new int[2][3];

        // int[][][] dp =  new int[n+1][2][3];
        // for(int[][] x : dp)
        //     for(int[] y : x)
        //         Arrays.fill(y, -1);


        for(int i=n-1; i>=0; i--){
            for(int buy=0; buy<=1; buy++ ){
                for(int cap=1; cap<=2; cap++){
                    if(buy == 1){
                        curr[buy][cap] = Math.max(-prices[i] + ahead[0][cap], ahead[1][cap] );
                    }
                    else{
                        curr[buy][cap] = Math.max(prices[i] + ahead[1][cap-1], ahead[0][cap] );
                    }
                }
            }
            ahead = curr;
        }
        return ahead[1][2];
        // return helper(0, 1, 2, prices, dp);
        
    }

    public int helper(int i, int buy, int cap, int[] p, int[][][] dp){
        if(cap == 0 || i==p.length) return 0;
        if(dp[i][buy][cap] != -1) return dp[i][buy][cap];
        if(buy == 1){
            return dp[i][buy][cap] = Math.max(-p[i] + helper(i+1, 0, cap, p, dp), helper(i+1, 1, cap, p, dp) );
        }
        return dp[i][buy][cap] = Math.max(p[i] + helper(i+1, 1, cap-1, p, dp), helper(i+1, 0, cap, p, dp) );

    }

}
