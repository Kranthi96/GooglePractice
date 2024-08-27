class MinCostClimbingStairs {
    private int min;    
    public int minCostClimbingStairs(int[] cost) {
        int d1 =0 ;
        int d2 = 0;
        for(int i=2; i< cost.length+1; i++){
            int temp = d1;
            d1 = Math.min(d1+cost[i-1], d2+cost[i-2] );
            d2 = temp;
        }
        return d1;
        
    }
}
