class CoinChange {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1; i<=amount; i++ ){
            for(int j=0; j<coins.length; j++){
                if(i<coins[j])
                    break;
                int dif = i - coins[j];
                if(dp[dif] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], 1+dp[dif]);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];

        
    }
}
