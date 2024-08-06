class BestTimeToBuyAndSellStock1 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for(int i: prices){
            min = Math.min(min, i);
            if(min < i)
                profit = Math.max(profit, i-min);
        }
        return profit;
        
    }
}
