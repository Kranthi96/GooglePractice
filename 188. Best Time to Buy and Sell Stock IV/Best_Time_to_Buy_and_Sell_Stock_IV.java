class Best_Time_to_Buy_and_Sell_Stock_IV {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] ahead = new int[2][k+1];
        int[][] curr = new int[2][k+1];
        for(int i=n-1; i>=0; i--){
            for(int buy=0; buy<=1; buy++ ){
                for(int cap=1; cap<=k; cap++){
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
        return ahead[1][k];
    }
}
