class Minimum_Value_to_Get_Positive_Step_by_Step_Sum {
    public int minStartValue(int[] nums) {
        int sum = 0;
        int minSum = 0;
        for(int i: nums){
            sum += i;
            minSum = Math.min(minSum, sum);
        }
        return -minSum+1;
        
    }
}
